package com.agpf.recrutamento.configuration;

import org.apache.tinkerpop.gremlin.orientdb.OrientGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
public class OrientDBConfig {

    private static final Logger logger = LoggerFactory.getLogger(OrientDBConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public OrientGraphFactory getOrientGraphFactory() {
        OrientGraphFactory orientGraphFactory = new OrientGraphFactory(
                Objects.requireNonNull(env.getProperty("gpf.orientdb.connection.url")),
                env.getProperty("gpf.orientdb.connection.usuario"),
                env.getProperty("gpf.orientdb.connection.senha")
        );

        try(OrientGraph noTx = orientGraphFactory.getNoTx()) {
            logger.info("Executando teste de conexão com o OrientDB.");
            noTx.executeSql("SELECT 1");
        } catch (Exception e) {
            logger.error("Erro ao conectar com o OrientDB!", e);
        }

        return orientGraphFactory;
    }
}
