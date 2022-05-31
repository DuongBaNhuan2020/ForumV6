package com.dev2qa.forum.mvc;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.plan.spi.JoinDefinedByMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TopicController {
	@Autowired
	private TopicService topicService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/topicList"})
	public ModelAndView home() {
		List<Topic> listTopic = topicService.listAll();
		ModelAndView mav = new ModelAndView("topic_list");
		
		User user=userService.get(userService.get_User_Id_Current());
		mav.addObject("listTopic", listTopic);
		mav.addObject("user", user);
		System.out.println("vao listTopic");
		return mav;
	}
	@RequestMapping("/newTopic")
	public String newTopicForm(Map<String, Object> model) {
		User user=userService.get(userService.get_User_Id_Current());
		Topic topic = new Topic();
		model.put("topic", topic);
		model.put("user",user);
		return "forum_topic_new";
	}
	@RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("topic") @Validated Topic topic,BindingResult result) {
		if (result.hasErrors()) {
			
			return "forum_topic_new";
		}
		User user1=userService.get(userService.get_User_Id_Current());
		topic.setUser(user1);
		topic.setCreatedTime(Calendar.getInstance());
		topicService.save(topic);
		return "redirect:/topicList";
	}
}
