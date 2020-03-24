package com.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity //jpa entity임을 명시
@Getter
@Setter
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성
@Table(name = "test") // 테이블과 매핑
public class Test {
	 @Id // primaryKey임을 알립니다.
	 @GeneratedValue(strategy = GenerationType.IDENTITY) //  pk생성전략을 DB에 위임한다는 의미입니다. mysql로 보면 pk 필드를 auto_increment로 설정해 놓은 경우로 보면 됩니다.
	 private int id;
	 @Column(length= 100)
	 private String title;
	 @Column(length= 100)
	 private String content;
	 
}
