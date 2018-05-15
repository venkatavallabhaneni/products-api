package com.venkata.vallabhaneni.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name="categories")
public class Category {
	@Id
	@SequenceGenerator(name = "categorySeqGen", sequenceName = "seq_id_category", initialValue = 5, allocationSize = 100)
	@GeneratedValue(generator = "categorySeqGen")
	private Long id;

	@NotNull
	private String name;

	

}
