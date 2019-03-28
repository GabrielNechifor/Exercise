package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.springbootstarter.external.database.Topic;

@Entity
public class Course {
 
	@Id
	private String id;
	private String name;
	private String desciption;
	@ManyToOne
	private Topic topic;
	
	public Course()
	{
		
	}
	
	public Course(String id, String name, String desciption,String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.topic=new Topic(topicId,"","");
		this.desciption = desciption;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
