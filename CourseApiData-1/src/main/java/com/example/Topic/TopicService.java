package com.example.Topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TopicService 
{
	@Autowired
	private TopicRepository topicrepository;
	
	/*private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("one","Java","Javadescription"),
			new Topic("two","Spring","SpringBootdescription"),
			new Topic("three","html","htmldescription"),
			new Topic("four","sql","sqldescription")
			));
	
	*/
	public List<Topic> getAllTopics() 
	{
		List<Topic> topics=new ArrayList<>();
		topicrepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	public Optional<Topic> getTopic(String id) 
	{
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		return topicrepository.findById(id);
		
	}
	public void addTopic(Topic topic) 
	{
		topicrepository.save(topic);
	}
	public void updateTopic(String id, Topic topic) 
	{
	    topicrepository.findAll()
	    .forEach(d->{
	    	if(d.getId().equals(id)) {
	    		d.setName(topic.getName());
	    		d.setDescription(topic.getDescription());
	    		topicrepository.save(d);
	    		System.out.print("topic updated");
	    		return;
	    	}
	    }
	    		); 
	    topicrepository.save(topic);	
	}
	public void deleteTopic(String id) 
	{
		/*topics.removeIf(t->t.getId().equals(id));
		System.out.println("Deleted Successfully");
		*/
		topicrepository.deleteById(id);
		
	}
	

}
