package com.opensource.redditbackend.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subreddit {

	@Id
	@SequenceGenerator(name = "SUB_GEN", sequenceName = "SEQ_SUB", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUB_GEN")
	private Long id;

	@NotBlank(message = "Subreddit name is required")
	private String name;

	@NotBlank(message = "Subreddit description is required")
	private String description;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	private Instant creationDate;

}
