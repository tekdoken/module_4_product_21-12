package product.service;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IGeneralService<A> {
    Page<A> findAll();

    Optional<A> finById(int id);

    void save(A a);

    void remove(A a);
}
