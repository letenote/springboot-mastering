package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.UserDaoService;
import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.dto.ResponseDtoGenerator;
import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.exception.UserNotFoundException;
import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.models.UserNoDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Affordance;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController()
@RequestMapping()
public class UserNoDataBaseController {
	public Map<String, Object> bodyResponse;

	@Autowired
	private UserDaoService userDaoService;

	public UserNoDataBaseController() {
		this.bodyResponse = new HashMap<>();
	}

	@GetMapping("/v1/users")
	public ResponseEntity<Object> retrieveAllUsers(){
		List<UserNoDataBase> users = userDaoService.findAll();
		bodyResponse.put("data", users);
		var getBody = new ResponseDtoGenerator().isSuccess("Users Found", bodyResponse);
		return ResponseEntity.ok().body(getBody);
	}

//	@GetMapping("/v1/users/{id}")
//	public ResponseEntity<Object> retrieveUser(@PathVariable int id){
//		UserNoDataBase user = userDaoService.fondOne(id);
//		if( user == null){
//			throw new UserNotFoundException("id:" +id);
//		}
//
//		bodyResponse.put("data", user);
//		var getBody = new ResponseDtoGenerator().isSuccess("User Found", bodyResponse);
//		return ResponseEntity.ok().body(getBody);
//	}

	/**
	 * method on, with hateoas implement
	 * @param id int
	 * @return ResponseEntity<Object>
	 */
	@GetMapping("/v1/users/{id}")
	public ResponseEntity<Object> retrieveUser(@PathVariable int id){
		UserNoDataBase user = userDaoService.fondOne(id);
		if( user == null){
			throw new UserNotFoundException("id:" +id);
		}
		// 1. hateoas implement
		WebMvcLinkBuilder linkToSelf = linkTo(methodOn(this.getClass()).deleteUser(id));
		user.add(linkToSelf.withSelfRel());
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		user.add(linkToUsers.withRel("all-users"));

//		//2. hateoas implement
//		EntityModel<UserNoDataBase> model = EntityModel.of(user);
//		WebMvcLinkBuilder selfLink = linkTo(methodOn(this.getClass()).retrieveUser(id));
//		Affordance update = afford(methodOn(this.getClass()).deleteUser(id));
//		WebMvcLinkBuilder aggregateRoot = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//		model.add(selfLink.withSelfRel());
//		model.add(aggregateRoot.withRel("root"));
		bodyResponse.put("data", user);
		var getBody = new ResponseDtoGenerator().isSuccess("User Found", bodyResponse);
		return ResponseEntity.ok().body(getBody);
	}

	@PostMapping("/v1/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserNoDataBase userRequest){
		UserNoDataBase savedUser = userDaoService.save(userRequest);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		bodyResponse.put("data", savedUser);
		var getBody = new ResponseDtoGenerator().isCreated("User Created", bodyResponse);
		return ResponseEntity.created(location).body(getBody);
	}

	@DeleteMapping("/v1/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		UserNoDataBase user = userDaoService.deleteById(id);
		if( user == null){
			throw new UserNotFoundException(String.format("user with id: '%s' is not found", id));
		}

		bodyResponse.put("data", user);
		var getBody = new ResponseDtoGenerator().isAccepted(String.format("user with id: '%s' is deleted", id), bodyResponse);
		return ResponseEntity.accepted().body(getBody);
	}
}
