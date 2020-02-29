package jp.akinori.multidb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author akinori
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "jp.akinori.multidb.dao.mysqlDao",
        entityManagerFactoryRef = "client2EntityManager",
        transactionManagerRef = "client2TransactionManager"
)
public class Client2DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.client2")
    public DataSourceProperties client2Properties() {
        return new DataSourceProperties();
    }

    @Bean
    @Autowired
    public DataSource client2DataSource(@Qualifier("client2Properties")
                                                DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean client2EntityManager(EntityManagerFactoryBuilder builder,@Qualifier("client2DataSource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages("jp.akinori.multidb.entity")
                .persistenceUnit("client2")
                .build();
    }


    @Bean
    @Autowired
    public JpaTransactionManager client2TransactionManager(@Qualifier("client2EntityManager") LocalContainerEntityManagerFactoryBean client2EntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(client2EntityManager.getObject());
        return transactionManager;
    }
    
    @Bean
    @Autowired
    public JdbcTemplate client2JdbcTemplate(@Qualifier("client2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

