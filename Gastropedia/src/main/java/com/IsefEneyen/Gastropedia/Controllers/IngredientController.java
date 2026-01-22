package com.IsefEneyen.Gastropedia.Controllers;

import com.IsefEneyen.Gastropedia.DTOs.IngredientDTO;
import com.IsefEneyen.Gastropedia.Models.Ingredient;
import com.IsefEneyen.Gastropedia.Services.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingrendientServise;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("")
    public ResponseEntity<?> GetIngredients()
    {
        List<Ingredient> ingredients = ingrendientServise.getIngredients();

        if(!ingredients.isEmpty())
        {
            return ResponseEntity.ok(ingredients);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay ingredientes");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetIngredient(@PathVariable Long id)
    {
        Ingredient ingredient = ingrendientServise.getIngredientById(id);

        if(ingredient != null)
        {
            return ResponseEntity.ok(ingredient);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el ingrediente con el id: " + id);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateIngredient(@RequestBody String ingredient) throws JsonProcessingException
    {
        IngredientDTO dto = MAPPER.readValue(ingredient, IngredientDTO.class);

        new Ingredient();
        Ingredient newIngredient = Ingredient.builder()
                .name(dto.getName())
                .build();
        ingrendientServise.save(newIngredient);

        return ResponseEntity.status(HttpStatus.CREATED).body(newIngredient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateIngredient(@RequestBody String ingredient, @PathVariable Long id) throws JsonProcessingException
    {
        IngredientDTO dto = MAPPER.readValue(ingredient, IngredientDTO.class);

        Ingredient ingredientUpdate = ingrendientServise.getIngredientById(id);

        if(ingredientUpdate == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el ingrediente con el id: " + id);
        }

        ingredientUpdate = Ingredient.builder()
                .id(id)
                .name(dto.getName())
                .build();
        ingrendientServise.save(ingredientUpdate);

        return ResponseEntity.ok(ingredientUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteIngredient(@PathVariable Long id)
    {
        Ingredient ingredient = ingrendientServise.getIngredientById(id);

        if(ingredient != null)
        {
            ingrendientServise.delete(ingredient);
            return ResponseEntity.ok("Se elminó el ingrediente correctamente");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el ingrediente con id: " + id);
        }
    }
}
