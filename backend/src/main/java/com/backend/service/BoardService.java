package com.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.backend.advice.exception.CNotOwnerException;
import com.backend.advice.exception.CResourceNotExistException;
import com.backend.advice.exception.CUserNotFoundException;
import com.backend.dto.ParamsPost;
import com.backend.entity.Board;
import com.backend.entity.Post;
import com.backend.entity.User;
import com.backend.repo.BoardJpaRepo;
import com.backend.repo.PostJpaRepo;
import com.backend.repo.UserJpaRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final BoardJpaRepo boardJpaRepo;
    private final PostJpaRepo postJpaRepo;
    private final UserJpaRepo userJpaRepo;
 
    // 게시판 이름으로 게시판을 조회. 없을경우 CResourceNotExistException 처리
    public Board findBoard(String boardName) {
        return Optional.ofNullable(boardJpaRepo.findByName(boardName)).orElseThrow(CResourceNotExistException::new);
    }
    // 게시판 이름으로 게시물 리스트 조회.
    public List<Post> findPosts(String boardName) {
        return postJpaRepo.findByBoard(findBoard(boardName));
    }
    // 게시물ID로 게시물 단건 조회. 없을경우 CResourceNotExistException 처리
    public Post getPost(long postId) {
        return postJpaRepo.findById(postId).orElseThrow(CResourceNotExistException::new);
    }
    // 게시물을 등록합니다. 게시물의 회원UID가 조회되지 않으면 CUserNotFoundException 처리합니다.
    public Post writePost(String email, String boardName, ParamsPost paramsPost) {
        Board board = findBoard(boardName);  
        Post post = new Post(userJpaRepo.findByEmail(email).orElseThrow(CUserNotFoundException::new), board, paramsPost.getAuthor(), paramsPost.getTitle(), paramsPost.getContent());
        return postJpaRepo.save(post);
    }
    // 게시물을 수정합니다. 게시물 등록자와 로그인 회원정보가 틀리면 CNotOwnerException 처리합니다.
    public Post updatePost(long postId, String uid, ParamsPost paramsPost) {
        Post post = getPost(postId);
        User user = post.getUser();
        if (!uid.equals(user.getEmail()))
            throw new CNotOwnerException();
    //# 영속성 컨텍스트의 변경감지(dirty checking) 기능에 의해 조회한 Post내용을 변경만 해도 Update쿼리가 실행됩니다.
        post.setUpdate(paramsPost.getAuthor(), paramsPost.getTitle(), paramsPost.getContent());
        return post;
    }
    // 게시물을 삭제합니다. 게시물 등록자와 로그인 회원정보가 틀리면 CNotOwnerException 처리합니다.
    public boolean deletePost(long postId, String uid) {
        Post post = getPost(postId);
        User user = post.getUser();
        if (!uid.equals(user.getEmail()))
            throw new CNotOwnerException();
        postJpaRepo.delete(post);
        return true;
    }
}