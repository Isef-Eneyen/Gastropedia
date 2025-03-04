package com.IsefEneyen.Gastropedia.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "coments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "content", columnDefinition = "mediumtext")
    @Lob
    private String content;

    @NotBlank
    @Column(name = "create_date")
    private Date create_date;

    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Recipe recipe;
}
