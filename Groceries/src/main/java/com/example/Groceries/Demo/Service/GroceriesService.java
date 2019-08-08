package com.example.Groceries.Demo.Service;

import java.util.Optional;

import com.example.Groceries.Demo.model.Grocery;

public interface GroceriesService {
	public Iterable<Grocery> findAllGroceries();

	public void addGrocery(Grocery grocery);

	public void deleteGrocery(long id);

	public Optional<Grocery> getGrocery(long id);

	public void updateGrocery(long id, Grocery grocery);

	public void countNoOfGroceries();

	public boolean existsById(long Id);

}
