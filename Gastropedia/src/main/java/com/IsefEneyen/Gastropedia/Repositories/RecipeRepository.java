package com.IsefEneyen.Gastropedia.Repositories;

import com.IsefEneyen.Gastropedia.Models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
