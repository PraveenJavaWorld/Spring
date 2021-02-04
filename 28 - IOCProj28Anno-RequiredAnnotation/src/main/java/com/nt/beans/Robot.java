package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class Robot {

	private int id;
	private String name;
	private String category;
	private float age;

	@Required
	public void setId(int id) {
		this.id = id;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAge(float age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Robot [id=" + id + ", name=" + name + ", category=" + category + ", age=" + age + "]";
	}

}
