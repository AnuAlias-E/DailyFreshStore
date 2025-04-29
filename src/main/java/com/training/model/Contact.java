package com.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "contacts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id",nullable=false)
	@EqualsAndHashCode.Include
	private int contactId;

	@Column
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Column
	@Email(message = "Email should be valid")
	private String email;

	@Column
	@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	private String phone;
}
