package com.example.multipleDB.MultipleDB.admissions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Entity

@Component
@Validated
@ConfigurationProperties
//@PropertySource(value= {"multipleDB.properties"})
@PropertySource("file:/Git/db.properties")
public class Admission {
	
	@Id
	private int id;
	private String description;
	
	public Admission() {
		super();
	}

	public Admission(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	
}
