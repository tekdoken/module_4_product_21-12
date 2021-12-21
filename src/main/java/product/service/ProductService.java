package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import product.model.Category;
import product.model.Product;

import java.util.Optional;

@Service
public class ProductService implements IProductServcie {
    @Autowired
    IProductServcie iProductServcie;

    @Override
    public Page<Product> findAll() {
        return iProductServcie.findAll();
    }

    @Override
    public Optional<Product> finById(int id) {
        return iProductServcie.finById(id);
    }

    @Override
    public void save(Product product) {
        iProductServcie.save(product);
    }

    @Override
    public void remove(Product product) {
        iProductServcie.remove(product);
    }

    @Override
    public Page<Product> findAllByCategory(Category category) {
        return iProductServcie.findAllByCategory(category);
    }

    @Override
    public Page<Product> findByName(String name) {
        return null;
    }

    @Override
    public Page<Product> findAllByOrderByPriceDesc() {
        return null;
    }

    @Override
    public Page<Product> findAllByOrderByPriceAsc() {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductServcie.findAll(pageable);
    }
}
