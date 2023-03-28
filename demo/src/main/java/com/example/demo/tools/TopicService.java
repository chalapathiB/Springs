package com.example.demo.tools;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService 
{
	private List<Topic> topics=
	 Arrays.asList(
			new Topic(1,"Spring","This is springboot description"),
			new Topic(2,"Java","This is description for java"),
			new Topic(),
			new Topic(3,"HTML","This is description for HTML")
			);
	
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}

}
