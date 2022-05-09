package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserNoDataBaseController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<UserNoDataBase> retrieveAllUsers(){
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public UserNoDataBase retrieveUser(@PathVariable int id){
		return userDaoService.fondOne(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody UserNoDataBase userRequest){
		UserNoDataBase savedUser = userDaoService.save(userRequest);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();


		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		userDaoService.deleteById(id);
	}
}
