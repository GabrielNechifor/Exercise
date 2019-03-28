package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	

	public List<Course> getAllCourses(String topicId)
	{
		
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id)
	{
       return courseRepository.findById(id);
	}
	
	public void addCourse(Course course) {
		
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		
		courseRepository.save(course);
			
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	
}