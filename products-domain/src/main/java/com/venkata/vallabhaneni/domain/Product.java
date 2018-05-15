package com.venkata.vallabhaneni.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name="products")
public class Product {

	@Id
	@SequenceGenerator(name = "productsSeqGen", sequenceName = "seq_id_products", initialValue = 5, allocationSize = 100)
	@GeneratedValue(generator = "productsSeqGen")
	private Long id;

	@NotNull
	private String name;

}
