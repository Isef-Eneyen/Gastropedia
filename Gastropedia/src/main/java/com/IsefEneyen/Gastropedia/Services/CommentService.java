package com.IsefEneyen.Gastropedia.Services;

import com.IsefEneyen.Gastropedia.Models.Comment;
import com.IsefEneyen.Gastropedia.Repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(){return commentRepository.findAll();}
    public Comment getCommentById(Long id){return commentRepository.findById(id).orElse(null);}
    public void save(Comment comment){commentRepository.save(comment);}
    public void delete(Comment comment){commentRepository.delete(comment);}
}
