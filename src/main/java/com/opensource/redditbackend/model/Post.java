package com.opensource.redditbackend.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {

	@Id
	@SequenceGenerator(name = "POST_GEN", sequenceName = "SEQ_POST", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_GEN")
	private Long postId;

	@NotBlank(message = "Post title is required")
	private String postTitle;

	@Nullable
	private String url;

	@Nullable
	@Lob
	private String description;

	private Integer voteCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	private Instant creationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Subreddit subreddit;
}
