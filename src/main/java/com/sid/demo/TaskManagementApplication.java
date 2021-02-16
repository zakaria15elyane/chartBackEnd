package com.sid.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sid.demo.entity.Task;
import com.sid.demo.repository.TaskRepository;
import com.sid.demo.service.TaskService;
@EntityScan("com.sid")
@ComponentScan("com.sid")
@EnableJpaRepositories("com.sid")
@SpringBootApplication
public class TaskManagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@Autowired
	private TaskRepository taskService;
	@Override
	public void run(String... args) throws Exception {
	
		taskService.save(new Task(null,"java","jee",new Date(),"formation java"));
		taskService.findAll().forEach(t->{
			System.out.println(t.toString());
		});
		
	}

}
