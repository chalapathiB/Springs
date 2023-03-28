package com.example.demo2.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController 
{
	
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicservice.getAllTopics();	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/topics/{id}")
	
	public Topic getTopic(@PathVariable Integer id)
	{
		return topicservice.getTopic(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicservice.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@PathVariable Integer id,@RequestBody Topic topic)
	{
		topicservice.updateTopic(id,topic);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable Integer id)
	{
		topicservice.deleteTopic(id);
	}
	
	

}
