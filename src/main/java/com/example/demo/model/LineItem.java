package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Line_Item")
public class LineItem extends BaseEntity {
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "unit_type")
	@Enumerated(EnumType.STRING)
	private UnitType type;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public UnitType getType() {
		return type;
	}
	public void setType(UnitType type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineItem other = (LineItem) obj;
		if (quantity != other.quantity)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
