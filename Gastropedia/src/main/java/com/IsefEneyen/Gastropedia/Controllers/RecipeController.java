package com.IsefEneyen.Gastropedia.Controllers;

import com.IsefEneyen.Gastropedia.DTOs.RecipeDTO;
import com.IsefEneyen.Gastropedia.Models.Recipe;
import com.IsefEneyen.Gastropedia.Services.RecipeService;
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
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("")
    public ResponseEntity<?> GetRecipes()
    {
        List<Recipe> recipes = recipeService.getRecipes();

        if(!recipes.isEmpty())
        {
            return ResponseEntity.ok(recipes);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no hay recetas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetRecipe(@PathVariable Long id)
    {
        Recipe recipe = recipeService.getRecipeById(id);

        if(recipe != null)
        {
            return ResponseEntity.ok(recipe);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró esa receta");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> Delete(@PathVariable Long id)
    {
        Recipe recipe = recipeService.getRecipeById(id);

        if(recipe != null)
        {
            recipeService.delete(recipe);
            return ResponseEntity.ok().body("Se ha elminiado correctamente");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró esa receta");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> Delete(@RequestBody String recipe) throws JsonProcessingException
    {
        RecipeDTO dto = MAPPER.readValue(recipe, RecipeDTO.class);
        Date date = new Date();

        new Recipe();
        Recipe newRecipe = Recipe.builder()
                .title(dto.getTitle())
                .history(dto.getHistory())
                .instruction(dto.getInstruction())
                .image(dto.getImage())
                .date(date)
                .build();

        recipeService.save(newRecipe);
        return ResponseEntity.ok(newRecipe);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> Update(@RequestBody String recipe, @PathVariable Long id) throws JsonProcessingException
    {
        RecipeDTO dto = MAPPER.readValue(recipe, RecipeDTO.class);
        Date date = new Date();
        Recipe updateRecipe = recipeService.getRecipeById(id);

        if (updateRecipe == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la receta");
        }

        updateRecipe = Recipe.builder()
                .id(id)
                .title(dto.getTitle())
                .history(dto.getHistory())
                .instruction(dto.getInstruction())
                .image(dto.getImage())
                .updateDate(date)
                .build();

        recipeService.save(updateRecipe);
        return ResponseEntity.ok(updateRecipe);
    }

}
