package com.github.alex_moon.noise.entities.texts;

import java.time.LocalDateTime;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Tokenization {
	@GraphId
	private Long id;

	private LocalDateTime requested;

	private LocalDateTime completed;

	private LocalDateTime rejected;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRequested() {
		return requested;
	}

	public void setRequested(LocalDateTime requested) {
		this.requested = requested;
	}

	public LocalDateTime getCompleted() {
		return completed;
	}

	public void setCompleted(LocalDateTime completed) {
		this.completed = completed;
	}

	public LocalDateTime getRejected() {
		return rejected;
	}

	public void setRejected(LocalDateTime rejected) {
		this.rejected = rejected;
	}
}
