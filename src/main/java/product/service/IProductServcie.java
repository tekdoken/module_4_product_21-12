package product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import product.model.Category;
import product.model.Product;

public interface IProductServcie extends IGeneralService<Product> {
    public Page<Product> findAllByCategory(Category category);

    public Page<Product> findByName(String name);

    public Page<Product> findAllByOrderByPriceDesc();

    public Page<Product> findAllByOrderByPriceAsc();

    Page<Product> findAll(Pageable pageable);
}
