package com.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board extends CommonDateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;
	@Column(nullable = false, length = 100)
	private String name;
}
