package com.IsefEneyen.Gastropedia.Controllers;

import com.IsefEneyen.Gastropedia.DTOs.CommentDTO;
import com.IsefEneyen.Gastropedia.Models.Comment;
import com.IsefEneyen.Gastropedia.Services.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("")
    public ResponseEntity<?> GetComments()
    {
        List<Comment> comments = commentService.getComments();

        if(!comments.isEmpty())
        {
            return ResponseEntity.ok(comments);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay ningun comentario");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetCommnet(@PathVariable Long id)
    {
        Comment comment = commentService.getCommentById(id);

        if (comment != null)
        {
            return ResponseEntity.ok(comment);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el comentario con el id: "+id);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> Create(@RequestBody String comment) throws JsonProcessingException
    {
        CommentDTO dto = MAPPER.readValue(comment, CommentDTO.class);
        Date date = new Date();

        new Comment();
        Comment newComment = Comment.builder()
                .content(dto.getContent())
                .create_date(date)
                .build();

        commentService.save(newComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newComment);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> Update(@RequestBody String commet, @PathVariable Long id) throws JsonProcessingException
    {
        CommentDTO dto = MAPPER.readValue(commet, CommentDTO.class);
        Comment commnetUpdate = commentService.getCommentById(id);
        Date date = new Date();

        if(commnetUpdate == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar ese comentario");
        }

        commnetUpdate = Comment.builder()
                .id(id)
                .content(dto.getContent())
                .create_date(date)
                .build();

        commentService.save(commnetUpdate);
        return ResponseEntity.ok(commnetUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> Delete(@PathVariable Long id)
    {
        Comment comment = commentService.getCommentById(id);

        if(comment != null)
        {
            commentService.delete(comment);
            return ResponseEntity.ok("El comentario ha sido eliminado");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el comentario");
        }
    }
}
