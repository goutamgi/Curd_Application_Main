package com.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.entity.User;
import com.crudapp.service.UserService;

@RestController
@RequestMapping("/ap1")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/home")
	private User create(@RequestBody User user) {
		
		return userService.saveData(user);
		
	}
	
	@GetMapping("/home")
	private List<User>getAllData(){
		
		return userService.getData();	
	}
	
	@GetMapping("/home/{id}")
	private int getBy(@PathVariable ("id")int id) {
		
		return userService.getDataByid(id);
		
	}
	
	@DeleteMapping("/home/{id}")
	private void delete(@PathVariable ("id")int id) {
		
		userService.deleteData(id);
			
	}
	
	@PutMapping("/home/{id}")
	private User update(@RequestBody User user, @PathVariable ("id")int id)
	{
		return userService.updateData(user,id);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
