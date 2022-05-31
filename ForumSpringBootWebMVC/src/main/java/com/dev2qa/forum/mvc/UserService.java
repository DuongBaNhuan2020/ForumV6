package com.dev2qa.forum.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
	@Autowired UserRepository repo;
	public long user_id=0;
	public void save(User user) {
		repo.save(user);
	}
	public User get(Long id) {
		return repo.findById(id).get();
	}
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}
	public void set_User_Id_Current(long user_Id_In) {
		this.user_id=user_Id_In;
	}
	public long get_User_Id_Current() {
		return this.user_id;
	}
}
