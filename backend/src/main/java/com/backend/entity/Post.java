package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post extends CommonDateEntity{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long post_id;
	    @Column(nullable = false, length = 50)
	    private String author;
	    @Column(nullable = false, length = 100)
	    private String title;
	    @Column(length = 500)
	    private String content;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "board_id")
	    private Board board; // 게시글 - 게시판의 관계 - N:1

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private User user;  // 게시글 - 회원의 관계 - N:1

	    // Join 테이블이 Json결과에 표시되지 않도록 처리.
	    @JsonIgnore
	    public Board getBoard() {
	        return board;
	    }

	    // 생성자
	    public Post(User user, Board board, String author, String title, String content) {
	        this.user = user;
	        this.board = board;
	        this.author = author;
	        this.title = title;
	        this.content = content;
	    }

	    // 수정시 데이터 처리
	    public Post setUpdate(String author, String title, String content) {
	        this.author = author;
	        this.title = title;
	        this.content = content;
	        return this;
	    }
}
