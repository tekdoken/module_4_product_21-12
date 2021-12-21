package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import product.model.Category;
import product.model.Product;
import product.repository.IProductRepository;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
iProductRepository.save(product);
    }

    @Override
    public void remote(Long id) {
iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByNameContaining(Pageable pageable, String name) {
        return (Page<Product>) iProductRepository.findByNameContaining(pageable,name);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return iProductRepository.findAllByCategory(category);
    }
}
