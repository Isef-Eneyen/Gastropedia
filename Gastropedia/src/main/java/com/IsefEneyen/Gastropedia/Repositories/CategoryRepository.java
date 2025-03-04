package com.IsefEneyen.Gastropedia.Repositories;

import com.IsefEneyen.Gastropedia.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
