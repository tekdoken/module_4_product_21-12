package product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import product.model.Category;
import product.model.Product;

public interface IProductService extends IGeneralServicce<Product>{
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByNameContaining(Pageable pageable,String name);
     Iterable<Product> findAllByCategory(Category category);
}
