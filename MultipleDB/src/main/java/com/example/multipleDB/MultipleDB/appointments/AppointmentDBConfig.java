package com.example.multipleDB.MultipleDB.appointments;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "appointmentsEntityManagerFactory", basePackages = {
		"com.example.multipleDB.MultipleDB.appointments" }, transactionManagerRef = "appointmentsTransactionManager")
public class AppointmentDBConfig {

	@Bean(name = "appointmentsDatasource")
	@ConfigurationProperties(prefix = "spring.appointment.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "appointmentsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("appointmentsDatasource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
		return builder.dataSource(dataSource).packages("com.example.multipleDB.MultipleDB.appointments")
				.properties(properties).persistenceUnit("Appointments").build();
	}

	@Bean(name = "appointmentsTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("appointmentsEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
