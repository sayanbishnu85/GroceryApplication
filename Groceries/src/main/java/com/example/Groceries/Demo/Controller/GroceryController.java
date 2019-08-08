package com.example.Groceries.Demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Groceries.Demo.Repository.GroceryRepository;
import com.example.Groceries.Demo.model.Grocery;

@Controller

public class GroceryController {

	@Autowired
	private GroceryRepository groceryRepository;
	
 
	@RequestMapping("/groceries")									// This gives list of all groceries
	public String retrieveAllGroceries(Model model) {
		
		List<Grocery> groceryList=(List<Grocery>) this.groceryRepository.findAll();
		model.addAttribute("groceries", groceryList);
		return "listGroceries";
	}
	@GetMapping("/addGrocerypage")  						// This is to direct the page to add grocery
	public String addGroceryPage() {
		return "addGrocery";
	}

	@PostMapping(path="/addGrocery",consumes = "application/x-www-form-urlencoded")
   
	public String addGrocery(@RequestBody Grocery grocery) {
		groceryRepository.save(grocery);
		return "redirect:/groceries";
	}
	@RequestMapping(value = "/updateGrocery/{id}", method = RequestMethod.GET)				// This lets to populate the edit grocery
	public String updatePlayer(@PathVariable String id, Model model) {	
		
		Grocery grocery = groceryRepository.findById(Long.parseLong(id))
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("updateGrocery",grocery);	    
	   
	    return "update"; 
	}

	@PostMapping("/saveGrocery/{id}")									// This is to save the updated grocery
	public String savePlayer(@PathVariable String id, @Valid Grocery grocery , Model model) {

		groceryRepository.save(grocery);
	    
	    return "redirect:/groceries";
	}
	
	@RequestMapping(value = "/deleteGrocery/{id}", method = RequestMethod.GET)				// This is to delete player
	public String deletePlayer(@PathVariable String id) {	
		
	    groceryRepository.deleteById(Long.parseLong(id));
	   
	    return "redirect:/groceries";
	}
	
}
