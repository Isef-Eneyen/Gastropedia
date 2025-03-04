package com.IsefEneyen.Gastropedia.Services;

import com.IsefEneyen.Gastropedia.Models.Recipe;
import com.IsefEneyen.Gastropedia.Repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<Recipe> getComments(){return recipeRepository.findAll();}
    public Recipe getCommentById(Long id){return recipeRepository.findById(id).orElse(null);}
    public void save(Recipe recipe){recipeRepository.save(recipe);}
    public void delete(Recipe recipe){recipeRepository.delete(recipe);}
}