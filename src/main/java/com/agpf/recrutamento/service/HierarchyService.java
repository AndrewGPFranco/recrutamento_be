package com.agpf.recrutamento.service;

import com.agpf.recrutamento.dto.employee.EmployeeDTO;
import com.agpf.recrutamento.enumType.HierarchyType;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HierarchyService {

    @Autowired
    private OrientGraphFactory orient;

    public GraphTraversalSource getGraph() {
        return orient.getNoTx().traversal();
    }

    public void addEmployeeEdgeToHierarchy(String label, EmployeeDTO employee, HierarchyType hierarchyType) {
        GraphTraversalSource g = getGraph();

        try {
            boolean alreadyHave = g.V().has("funcionario", "idunico", employee.id())
                    .out("level_funcionario").hasNext();

            if(!alreadyHave) {
                g.addE(label)
                        .from(__.V().has("funcionario", "idunico", employee.id()))
                        .to(__.V().has("hierarquia", "level", hierarchyType.getDescription())).iterate();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao adicionar aresta." + e.getMessage());
        }
    }
}
