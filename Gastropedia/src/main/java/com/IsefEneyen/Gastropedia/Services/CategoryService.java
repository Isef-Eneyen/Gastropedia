package com.IsefEneyen.Gastropedia.Services;

import com.IsefEneyen.Gastropedia.Models.Category;
import com.IsefEneyen.Gastropedia.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll(){return categoryRepository.findAll();}
    public Category getById(Long id){return categoryRepository.findById(id).orElse(null);}
    public void save(Category category){categoryRepository.save(category);}
    public void delete(Category category){categoryRepository.delete(category);}
}
