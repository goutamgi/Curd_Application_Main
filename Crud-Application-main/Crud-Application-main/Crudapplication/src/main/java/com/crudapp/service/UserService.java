package com.crudapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.entity.User;
import com.crudapp.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public User saveData(User user) {
		
		return userRepo.save(user);
		
	}

	public List<User> getData() {
		List<User>li=new ArrayList<User>();
		userRepo.findAll().forEach(e->li.add(e));
		return li;
	}

	public int getDataByid(int id) {
		 userRepo.findById(id);
		 return id;
	}

	public void deleteData(int id) {
		
	  userRepo.deleteById(id);
		
		
		
		
	}

	public User updateData(User user, int id) {
		
		Optional<User>us=userRepo.findById(id);
		if(us.isEmpty()) {
			
			User usst=us.get();
			usst.setAddress(user.getAddress());
			usst.setMobile(user.getMobile());
			usst.setName(user.getName());
			
			userRepo.save(usst);
			return usst;
			
		}
		
		
		return null;
	}
	
	

}
