package com.dev2qa.forum.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
//	@RequestMapping(value={"/"})
//	public ModelAndView home() {
//		ModelAndView mav = new ModelAndView("forum_login");
//		System.out.println("co vao day");
//		return mav;
//	}
	@RequestMapping(value={"/new", "/"})
	public String newUserForm(Map<String, Object> model) {
		User user=new User();
		model.put("user", user);
		System.out.println("co vao day /new");
		return "forum_login";
	}
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Validated User user,BindingResult result,Map<String, Object> model,HttpSession session) {
		if (result.hasErrors()) {
			return "forum_login";
		}
		List<String> listUserName=new ArrayList<String>();  
		listUserName.add("harry");  
		 listUserName.add("martin");  
		 listUserName.add("thuong");  
		 listUserName.add("than");  
		 listUserName.add("jenny");  
		 	
		 if(!listUserName.contains(user.getUserName())) {
			 model.put("error", "Invalid user");
				return "forum_login";
		 }
	
		user.setJoinDate(Calendar.getInstance());
		userService.save(user);
		User user1=new User();
		for(User u:userService.listAll()) {
			if(u.getUserName().equals(user.getUserName())) {
				user1.setId(u.getId());;
			}
		}
		
		session.setAttribute("username", userService.get(user1.getId()).getUserName());
		long user_id=user1.getId();
		userService.set_User_Id_Current(user_id);
		return "redirect:/topicList";
	}
	@RequestMapping(value={ "/logout"})
	public String logout(HttpSession session) {
		 session.removeAttribute("username");
		 userService.set_User_Id_Current(0);
		return "redirect:/";
	}
}
