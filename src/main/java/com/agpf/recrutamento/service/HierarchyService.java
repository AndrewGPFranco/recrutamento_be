package com.agpf.recrutamento.service;

import com.agpf.recrutamento.dto.employee.EmployeeDTO;
import com.agpf.recrutamento.dto.employee.EmployeeHierarchyDTO;
import com.agpf.recrutamento.enumType.HierarchyType;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HierarchyService {

    @Autowired
    private OrientGraphFactory orient;

    private static final String label = "idunico";

    public GraphTraversalSource getGraph() {
        return orient.getNoTx().traversal();
    }

    public void addEmployeeEdgeToHierarchy(String label, EmployeeDTO employee, HierarchyType hierarchyType) {
        GraphTraversalSource g = getGraph();

        try {
            boolean alreadyHave = g.V().has("funcionario", HierarchyService.label, employee.id())
                    .out("level_funcionario").hasNext();

            if(!alreadyHave) {
                g.addE(label)
                        .from(__.V().has("funcionario", HierarchyService.label, employee.id()))
                        .to(__.V().has("hierarquia", "level", hierarchyType.getDescription())).iterate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar aresta.");
        }
    }

    public void removeAllEdges(
            String fromLabelClass, String fromPropertyKey, String fromValueProperty, String labelEdge,
            String toLabelClass, String toPropertyKey, String toValueProperty
    ) {
        GraphTraversalSource g = getGraph();

        try {
            g.V().has(fromLabelClass, fromPropertyKey, fromValueProperty)
                    .bothE(labelEdge)
                    .where(__.V().has(toLabelClass, toPropertyKey, toValueProperty)).drop().iterate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover aresta.");
        }
    }

    public EmployeeHierarchyDTO getHierarchyByEmployee(String id) {
        GraphTraversalSource g = getGraph();
        Vertex employeeFound = g.V().has("funcionario", label, id).next();
        HierarchyType level = null;

        if(employeeFound != null) {
            GraphTraversal<Vertex, Vertex> response = g.V().has("funcionario", label, id).out("level_funcionario");
            if(response.hasNext()) {
                Map<Object, Object> next = g.V().has("funcionario", label, id).out("level_funcionario").elementMap().next();
                level = HierarchyType.fromDescription(next.get("level").toString());
            }
        }
        String uniqueId = (String) employeeFound.property(label).value();
        String name = (String) employeeFound.property("name").value();

        return new EmployeeHierarchyDTO(null, new EmployeeDTO(uniqueId, name), level != null ? level : HierarchyType.SEM_CARGO);
    }

    public void updateHierarchyOfEmployee(String id, String name, String hierarchy) {
        GraphTraversalSource g = getGraph();

        GraphTraversal<Vertex, Vertex> employee = g.V().has("funcionario", label, id)
                .out("level_funcionario");

        if(employee.hasNext()) {
            Vertex employeeFound = g.V().has("funcionario", label, id).next();
            g.V().has("funcionario", label, id).outE("level_funcionario").drop().iterate();
            g.addE("level_funcionario")
                    .from(__.V().has("funcionario", label, employee.id()))
                    .to(__.V().has("hierarquia", "level", hierarchy)).iterate();
        }
    }
}
