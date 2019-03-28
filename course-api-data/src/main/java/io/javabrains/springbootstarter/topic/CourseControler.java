package io.javabrains.springbootstarter.topic;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.external.database.Topic;

@RestController
public class CourseControler {
	
	@Autowired
	private CourseService courseService;

	//GET
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id )
	{
		return courseService.getAllCourses(id);
	}
	@RequestMapping("/topics/{TopicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
	
	
}
