package net.rch.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
	
	//For Creating Setters & Getters, so that encapsulation picture is coming.
	//Not giving to give access to use direct fields so that we are creating setters and getters
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	/*	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}*/
	
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}



		//Private Fields
		//Every ENtity have must id, so add @Id
		@Id
		//Use below for auto incremented id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private String name;
		
		private String description;
		
		//To reflect same column name in class
		@Column(name = "image_url")
		private String imageURL;
		
		@Column(name = "is_active")
		//private boolean active = true;
		private int active = 1;


				
}
