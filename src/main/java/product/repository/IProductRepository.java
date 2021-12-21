package product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.model.Category;
import product.model.Product;


@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByCategory(Category category);
    Page<Product> findByNameContaining(String name);
    Page<Product> findAllByOrderByPriceDesc();
    Page<Product> findAllByOrderByPriceAsc();
}
