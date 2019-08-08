package com.example.Groceries.Demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grocery")
public class Grocery {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	public Grocery() {
		
		
	}

	/*
	 * @NotBlank(message = "Price is mandatory")
	 * 
	 * @Column(name="price")
	 * 
	 * public double getPrice() { return price; }
	 * 
	 * public void setPrice(double price) { this.price = price; }
	 * 
	 * private double price;
	 */

	
	public String getName() {
		return name;
	}

	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Grocery(String name,String type) {
		this.name=name;
		this.type=type;


	}

}
