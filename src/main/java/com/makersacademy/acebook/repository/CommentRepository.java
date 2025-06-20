package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findByPost_IdOrderByCreatedAtAsc(Long postId);
    List<Comment> findByUser_Id(Long userId);
    void deleteAllByPostId(Long postId);
}
