package com.demo.hplus.repositories;

import com.demo.hplus.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    String query = "select p from Product p where p.name like %:name%";
    @Query(query)
    public List<Product> searchByName(@Param("name") String name);
}
