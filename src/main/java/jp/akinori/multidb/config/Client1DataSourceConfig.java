package jp.akinori.multidb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "client1EntityManager",
        transactionManagerRef = "client1TransactionManager"
)
public class Client1DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.client1")
    public DataSourceProperties client1Properties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @Autowired
    public DataSource client1DataSource(@Qualifier("client1Properties")
                                                DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    @Autowired
    public LocalContainerEntityManagerFactoryBean client1EntityManager(EntityManagerFactoryBuilder builder,@Qualifier("client1DataSource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages("jp.akinori.multidb.entity")
                .persistenceUnit("client1")
                .build();
    }


    @Bean
    @Primary
    @Autowired
    public JpaTransactionManager client1TransactionManager(@Qualifier("client1EntityManager") LocalContainerEntityManagerFactoryBean client1EntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(client1EntityManager.getObject());
        return transactionManager;
    }
    
    @Bean
    @Primary
    @Autowired
    public JdbcTemplate client1JdbcTemplate(@Qualifier("client1DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

