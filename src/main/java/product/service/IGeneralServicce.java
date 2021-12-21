package product.service;

import java.util.Optional;

public interface IGeneralServicce<A> {
    Iterable<A> findAll();
    Optional<A> findById();
    void save(A a);
    void remote(Long id);
}
