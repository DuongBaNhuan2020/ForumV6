package com.dev2qa.forum.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReplyMessageController {
	@Autowired
	private ReplyMessageService replyMessageService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private UserService userService;
	@RequestMapping("/detailTopic")
	public ModelAndView detailTopic( @RequestParam long top_id) {
		List<ReplyMessage> listReply = replyMessageService.listAll();
		List<ReplyMessage> listReplyShow = new ArrayList<ReplyMessage>();
		ModelAndView mav = new ModelAndView("forum_show_topic");
		for(ReplyMessage r:listReply) {
			if(r.getTopic().getId()==top_id) {
				listReplyShow.add(r);
			}
		}
		
		Topic topic=topicService.get(top_id);
		User author=topic.getUser();
		User user=userService.get(userService.get_User_Id_Current());
		
		mav.addObject("listReply", listReplyShow);
		mav.addObject("author", author);
		mav.addObject("firsttopic", topic);
		mav.addObject("user", user);
		return mav;
		
	}
	@RequestMapping("/newReply")
	public String newReplyForm(Map<String, Object> model, @RequestParam long top_id) {
		ReplyMessage replyTopic = new ReplyMessage();
		Topic topic=topicService.get(top_id);
		User user=userService.get(userService.get_User_Id_Current());
		model.put("replytopic", replyTopic);
		model.put("topic", topic);
		model.put("user",user);
		return "forum_reply_topic_new";
	}
	@RequestMapping(value = "/saveReplyMessage", method = RequestMethod.POST)
	public String saveReplyMessage(@ModelAttribute("replytopic") @Validated ReplyMessage replyMessage, BindingResult result,Map<String, Object> model,@RequestParam long top_id) {
		if (result.hasErrors()) {
			Topic topic=topicService.get(top_id);
			User user=userService.get(userService.get_User_Id_Current());
			model.put("topic", topic);
			model.put("user",user);
			return "forum_reply_topic_new";
		}
		User user1=userService.get(userService.get_User_Id_Current());
		replyMessage.setUser(user1);
		
		Topic topic1=new Topic();
		topic1.setId(top_id);
		replyMessage.setTopic(topic1);
		
		replyMessage.setCreatedTime(Calendar.getInstance());
		replyMessageService.save(replyMessage);
		return "redirect:/detailTopic?top_id="+top_id;
	}
}
