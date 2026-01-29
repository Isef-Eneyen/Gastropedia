package com.IsefEneyen.Gastropedia.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RecipeDTO {
    @NotBlank
    @Column(name = "title")
    @Size(min = 3, max = 20)
    private String title;

    @NotBlank
    @Lob
    @Column(name = "history", columnDefinition = "mediumtext")
    private String history;

    @NotBlank
    @Lob
    @Column(name = "instruction", columnDefinition = "mediumtext")
    private String instruction;

    @Column(name = "image_url")
    private String image;

    @NotNull
    @Column(name = "created_date")
    private Date date;

    @Column(name = "update_date")
    private Date updateDate;
}
