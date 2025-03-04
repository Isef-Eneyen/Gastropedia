package com.IsefEneyen.Gastropedia.Repositories;

import com.IsefEneyen.Gastropedia.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
