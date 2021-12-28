package com.example.multipleDB.MultipleDB.appointments;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Entity

@Component
@ConfigurationProperties
//@PropertySource(value= {"multipleDB1.properties"})
@PropertySource("file:/Git/db1.properties")
public class Appointments {

	@Id
	private int id;
	private String status;
	
	public Appointments() {
		super();
	}

	public Appointments(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
