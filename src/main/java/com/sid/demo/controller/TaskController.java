/**
* TaskController.java
 * @author : ZAKARIA EL AYANE
 * @see : zakaria15elyane@gmail.com
 * @creation : 3 fév. 2021
 * @version : 1.0
 * 
 */
package com.sid.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.demo.entity.Task;
import com.sid.demo.service.TaskService;
import com.sid.dto.CountType;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task/vData/percentcountType")
	public List<CountType> getPercentageGroupByType(){
		return taskService.getPercentageGroupByType();
	}
	@GetMapping("/task")
	public List<Task> getTask(){
		return taskService.getTasks();
	}
	
	@GetMapping("/task/{id}")
	public Task getById(@PathVariable Long id){
		return taskService.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Requested not found"));
	}
	@PostMapping("/task")
	public Task addTask(@RequestBody Task task) {
		return taskService.save(task);
	}
	@PutMapping("/task/{id}")
	public ResponseEntity<?> addTask(@RequestBody Task taskPara,@PathVariable Long id) {
		if (taskService.existById(id)) {
			Task task=taskService.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Requested not found"));
			task.setTitle(taskPara.getTitle());
			task.setDescription(taskPara.getDescription());
			task.setDueDate(taskPara.getDueDate());
			task.setType(taskPara.getType());
			taskService.save(task);
			return ResponseEntity.ok().body(task);
			
		}else {
			HashMap<String,String>message=new HashMap<>();
			message.put("message",id+"task not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	@DeleteMapping("/task/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id) {
		if (taskService.existById(id)) {
			taskService.delete(id);
			HashMap<String,String>message=new HashMap<>();
			message.put("message",id +" is deleted");
			return ResponseEntity.ok().body(message);
			
		}else {
			HashMap<String,String>message=new HashMap<>();
			message.put("message",id+"task not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
}
}