package edu.mum.cs.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descriotion;
	private String picture_path;
	
	@ManyToOne
	public Brand brand;
	
	@ManyToOne
	public Category category;
	
	@OneToMany(mappedBy = "product")
	List<ProductSize> productSizes;
}
