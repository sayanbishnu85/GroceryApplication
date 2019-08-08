package com.example.Groceries.Demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Groceries.Demo.model.Grocery;

@Repository

public interface GroceryRepository extends CrudRepository<Grocery,Long>  {

}
