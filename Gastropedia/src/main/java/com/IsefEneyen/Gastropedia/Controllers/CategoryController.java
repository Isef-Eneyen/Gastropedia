package com.IsefEneyen.Gastropedia.Controllers;

import com.IsefEneyen.Gastropedia.DTOs.CategoryDTO;
import com.IsefEneyen.Gastropedia.Models.Category;
import com.IsefEneyen.Gastropedia.Services.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("")
    public ResponseEntity<?> GetCategories()
    {
        List<Category> categories = categoryService.getAll();

        if(!categories.isEmpty())
        {
            System.out.print("esta funcionando" + categories);
            return ResponseEntity.ok(categories);
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay categorias");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetCategory(@PathVariable Long id)
    {
        Category category = categoryService.getById(id);

        if(category == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la categoria con el id: "+ id);
        }
        else{
            return ResponseEntity.ok(category);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateCategory(@RequestBody String category) throws JsonProcessingException {
        CategoryDTO dto = MAPPER.readValue(category, CategoryDTO.class);
        System.out.println("DTO recibido: " + dto.getName());

        new Category();
        Category newCategory = Category.builder()
                .name(dto.getName())
                .build();

        categoryService.save(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateCategory(@PathVariable Long id, @RequestBody String category) throws  JsonProcessingException {
        CategoryDTO dto = MAPPER.readValue(category, CategoryDTO.class);

        Category categoryUpdate = categoryService.getById(id);

        if(categoryUpdate == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar la categoria con id: " + id);
        }

        categoryUpdate = Category.builder()
                .id(id)
                .name(dto.getName())
                .build();

        categoryService.save(categoryUpdate);

        return ResponseEntity.ok(categoryUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteCategory(@PathVariable Long id)
    {
        Category category = categoryService.getById(id);

        if(category == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la categoria con id: " + id);
        }
        else{
            categoryService.delete(category);
            return ResponseEntity.ok("La categoria se ha eliminado correctamente");
        }
    }
}
