package com.venkata.vallabhaneni.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name="attributes")
public class Attribute {

	@Id
	@SequenceGenerator(name = "characterSeqGen", sequenceName = "seq_id_attribute", initialValue = 5, allocationSize = 100)
	@GeneratedValue(generator = "characterSeqGen")
	private Long id;

	@NotNull
	private String name;


}
