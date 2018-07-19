package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	private String name;
	private float cost;
	@OneToMany(targetEntity = LineItem.class, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id", name = "product_id")
	private Set<LineItem> lineItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	

}
