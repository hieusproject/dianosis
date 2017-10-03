///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package config;
//
//
//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
///**
// *
// * @author PC
// */
//@Configuration
//@EnableTransactionManagement
//public class SpringConfig {
//    @Bean
//        public DataSource dataSource() {
//            Connection connection = DriverManager.getConnection(dbUrl,
//    username, password);
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//       return dataSource;
//}
////    @Bean
////    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
////        LocalContainerEntityManagerFactoryBean entityManager= new LocalContainerEntityManagerFactoryBean();
////        entityManager.setDataSource(dataSource);
////        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////        entityManager.setPackagesToScan("entity");
////        //jpa properties 
////        Properties jpaProperties= new Properties();
////        jpaProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
////        jpaProperties.setProperty("hibernate.hbm2ddl.auto","update");
////        entityManager.setJpaProperties(jpaProperties);
////        return entityManager;
////    }
////    @Bean 
////    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory ){
////        JpaTransactionManager jpaTransactionManager= new JpaTransactionManager();
////        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
////        return jpaTransactionManager;
////    }
//}
