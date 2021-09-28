package com.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name="user_id")
	private String user_id;

	@NotBlank
	@Column(name = "first_name")
	@Size(max = 40)
	private String firstName;

	@Column(name = "activation_Status")
	private Boolean ActivationStatus;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE })
	private List<PhoneEntity> phone;

}
