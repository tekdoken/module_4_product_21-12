package product.service;

import java.util.Optional;

public interface IGeneralServicce<A> {
    Iterable<A> findAll();
    Optional<A> findById(Long id);
    void save(A a);
    void remote(Long id);
}
