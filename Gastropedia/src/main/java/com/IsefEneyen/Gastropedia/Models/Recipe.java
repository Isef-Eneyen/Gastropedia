package com.IsefEneyen.Gastropedia.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recipes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotBlank
    @Lob
    @Column(name = "history", columnDefinition = "mediumtext")
    private String history;

    @ManyToMany(mappedBy = "recipes")
    private List<Ingredient> ingredients;

    @NotBlank
    @Lob
    @Column(name = "instruction", columnDefinition = "mediumtext")
    private String instruction;

    @ManyToOne
    private Category category;

    @NotBlank
    @Column(name = "image_url")
    private String image;

    @NotBlank
    @Column(name = "created_date")
    private Date date;

    @NotBlank
    @Column(name = "update_date")
    private Date updateDate;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "comments")
    private List<Comment> comments;

    @ManyToOne
    private User user;
}
