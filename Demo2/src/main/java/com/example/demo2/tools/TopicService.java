package com.example.demo2.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TopicService 
{
	@Autowired
	private TopicRepository topicrepository;
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic(1,"Java","Javadescription"),
			new Topic(2,"Spring","SpringBootdescription"),
			new Topic(3,"html","htmldescription"),
			new Topic(4,"sql","sqldescription")
			));
	
	
	public List<Topic> getAllTopics() 
	{
		List<Topic> topicss=new ArrayList<>();
		topicrepository.findAll()
		.forEach(topicss::add);
		return topicss;
				
	}
	public Topic getTopic(Integer id) 
	{
		return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	}
	public void addTopic(Topic topic) 
	{
		topics.add(topic);
	}
	public void updateTopic(Integer id, Topic topic) 
	{
		for(int i=0;i<topics.size();i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
			}
		}
	}
	public void deleteTopic(Integer id) 
	{
		topics.removeIf(t->t.getId().equals(id));
		System.out.println("Deleted Successfully");
		
	}
	

}
