package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase;

import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.models.UserNoDataBase;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
	private static final List<UserNoDataBase> users = new ArrayList<>();
	private static int usersCount = 3;
	static {
		users.add(new UserNoDataBase(1, "Loki", new Date()));
		users.add(new UserNoDataBase(2, "Baldur", new Date()));
		users.add(new UserNoDataBase(3, "Freya", new Date()));
	}

	public List<UserNoDataBase> findAll(){
		return users;
	}

	public UserNoDataBase fondOne(int id){
		for(UserNoDataBase user : users){
			if( user.getId() == id){
				return user;
			}
		}
		return null;
	}

	public UserNoDataBase save(UserNoDataBase userRequest) throws ConstraintViolationException {
		if (userRequest.getId() == null) {
			userRequest.setId(++usersCount);
		}
		users.add(userRequest);
		return userRequest;
	}

	public UserNoDataBase deleteById(int id){
		Iterator<UserNoDataBase> iterator = users.iterator();
		while( iterator.hasNext() ){
			UserNoDataBase user = iterator.next();
			if( user.getId() == id ){
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
