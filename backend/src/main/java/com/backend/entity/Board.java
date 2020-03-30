package com.backend.entity;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends CommonDateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_id;
	@Column(nullable = false, length = 100)
	private String name;
}
