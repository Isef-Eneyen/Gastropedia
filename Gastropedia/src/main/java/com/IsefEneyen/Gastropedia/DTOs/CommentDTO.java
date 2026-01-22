package com.IsefEneyen.Gastropedia.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {
    @NotBlank
    @Column(name = "content", columnDefinition = "mediumtext")
    @Lob
    @Size(min = 3, max = 400)
    private String content;

    @NotBlank
    @Column(name = "create_date")
    private Date create_date;
}
