package com.IsefEneyen.Gastropedia.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "coments")
@Builder
@Data
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
    @Size(min = 3, max = 400)
    private String content;

    @NotNull
    @Column(name = "create_date")
    private Date create_date;

    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Recipe recipe;
}
