package com.IsefEneyen.Gastropedia.Services;

import com.IsefEneyen.Gastropedia.Models.Ingredient;
import com.IsefEneyen.Gastropedia.Repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getComments(){return ingredientRepository.findAll();}
    public Ingredient getCommentById(Long id){return ingredientRepository.findById(id).orElse(null);}
    public void save(Ingredient ingredient){ingredientRepository.save(ingredient);}
    public void delete(Ingredient ingredient){ingredientRepository.delete(ingredient);}
}