package com.example.Groceries.Demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Groceries.Demo.Repository.GroceryRepository;
import com.example.Groceries.Demo.model.Grocery;

@Service
public class GroceriesServiceImpl implements GroceriesService {
	@Autowired
	private GroceryRepository groceryRepository;
	@Autowired
	private Optional<Grocery> groceryDetails;

	
	@Override
	public Iterable<Grocery> findAllGroceries() {

		return groceryRepository.findAll();
	}

	
	@Override
	public void addGrocery(Grocery grocery) {

		groceryRepository.save(grocery);
	}

	
	@Override
	public void deleteGrocery(long id) {
		groceryRepository.deleteById(id);

	}

	
	@Override
	public Optional<Grocery> getGrocery(long id) {
		if (groceryRepository.existsById(id))
			System.out.println("This item exists");
		else {
			/* groceryRepository.findById(id).orElseGet(Grocery::new); */
			groceryDetails = groceryRepository.findById(id);

		}
		return groceryDetails;

	}

	
	

	@Override
	public void countNoOfGroceries() {
		groceryRepository.count();

	}

	
	


	@Override
	public void updateGrocery(long id, Grocery grocery) {
		if (groceryRepository.existsById(id))
			System.out.println("This item exists");
		else
			groceryRepository.save(grocery);
		
	}


	@Override
	public boolean existsById(long Id) {
		return groceryRepository.existsById(Id);
	}

}