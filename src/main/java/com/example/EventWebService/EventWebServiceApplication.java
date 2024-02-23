package com.example.EventWebService;

import com.example.EventWebService.entity.Event;
import com.example.EventWebService.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventWebServiceApplication.class, args);
	}

	/**
	 * This method is used to populate the database with some sample data when the application starts.
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner run(EventRepository repository) {
		return args -> {
			createEventIfNotPresent(repository, new Event("1", "Tech Conference 2024", "The latest trends in technology", "2024-05-15", "Tech Hub City", "Tech Events Inc.", "Technology"));
			createEventIfNotPresent(repository, new Event("2", "CodeCamp XYZ", "A hands-on coding experience for developers", "2024-06-10", "Coding Center", "CodeCamp Organizers", "Programming"));
			createEventIfNotPresent(repository, new Event("3", "Data Science Summit", "Exploring the world of data science and analytics", "2024-08-20", "Data Innovation Center", "Data Science Society", "Data Science"));
			createEventIfNotPresent(repository, new Event("4", "Web Development Workshop", "Master the art of web development", "2024-09-05", "Web Dev Institute", "Web Dev Experts", "Web Development"));
			createEventIfNotPresent(repository, new Event("5", "AI Innovation Expo", "Showcasing breakthroughs in artificial intelligence", "2024-10-15", "AI Convention Center", "AI Innovation Labs", "Artificial Intelligence"));
			createEventIfNotPresent(repository, new Event("6", "Cybersecurity Summit", "Ensuring a secure digital future", "2024-11-10", "SecureTech Auditorium", "Cybersecurity Alliance", "Cybersecurity"));
			createEventIfNotPresent(repository, new Event("7", "Mobile App Hackathon", "Develop innovative mobile apps in a competitive environment", "2024-02-01", "Mobile Innovation Hub", "App Hackathon Society", "Mobile App Development"));
			createEventIfNotPresent(repository, new Event("8", "Blockchain Symposium", "Exploring the potential of blockchain technology", "2024-03-15", "Blockchain Institute", "Blockchain Experts Group", "Blockchain"));
			createEventIfNotPresent(repository, new Event("9", "DevOps Summit", "Bringing together experts in development and operations", "2024-05-20", "DevOps Convergence Center", "DevOps Community", "DevOps"));
			createEventIfNotPresent(repository, new Event("10", "Open Source Festival", "Celebrating the spirit of open source software", "2024-08-10", "Open Source Park", "Open Source Foundation", "Open Source"));
		};
	}
	private void createEventIfNotPresent (EventRepository repository, Event event){
		if (repository.findByEventName(event.getEventName()) == null) {
			repository.save(event);
		}
	}
}
