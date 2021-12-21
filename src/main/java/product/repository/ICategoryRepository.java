package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.model.Category;

import java.net.CacheRequest;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {

}
