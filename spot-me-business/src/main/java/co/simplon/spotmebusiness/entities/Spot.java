package co.simplon.spotmebusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_spots")
public class Spot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_spot")
	private Long id;

	@Column(name = "spot_name")
	private String name;

	@Column(name = "spot_desc")
	private String description;

	@Column(name = "spot_lat")
	private double lat; // Not null garantie dans le DTO donc pas besoin d'objet Double, primitive
						// suffit

	@Column(name = "spot_lng")
	private double lng;

	@Column(name = "spot_img")
	private String imageId; // 41

	@ManyToOne // One Category to Many Spot
	@JoinColumn(name = "spot_category_id")
	private Category category;

	public Spot() {
		// default for ORM (Object-Relational Mapping)

	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		// handled by db
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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Spot [id=" + id + ", name=" + name + ", description=" + description + ", lat=" + lat + ", lng=" + lng
				+ ", imageId=" + imageId + "]";
	}
}
