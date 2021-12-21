package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import product.model.Category;
import product.repository.ICategoryRepository;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remote(Long id) {

    }
}
