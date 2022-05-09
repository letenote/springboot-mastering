package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase;

import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class UserNoDataBaseController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/v1/users")
	public List<UserNoDataBase> retrieveAllUsers(){
		return userDaoService.findAll();
	}

	@GetMapping("/v1/users/{id}")
	public UserNoDataBase retrieveUser(@PathVariable int id){
		UserNoDataBase user = userDaoService.fondOne(id);
		if( user == null){
			throw new UserNotFoundException("id:" +id);
		}
		return user;
	}

	@PostMapping("/v1/users")
	public ResponseEntity<Object> createUser(@RequestBody UserNoDataBase userRequest){
		UserNoDataBase savedUser = userDaoService.save(userRequest);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();


		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/v1/users/{id}")
	public void deleteUser(@PathVariable int id){
		UserNoDataBase user = userDaoService.deleteById(id);
		if( user == null){
			throw new UserNotFoundException("id:" +id);
		}
	}
}
