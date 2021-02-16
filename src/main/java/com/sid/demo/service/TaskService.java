/**
* TaskService.java
 * @author : ZAKARIA EL AYANE
 * @see : zakaria15elyane@gmail.com
 * @creation : 3 fév. 2021
 * @version : 1.0
 * 
 */
package com.sid.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.demo.entity.Task;
import com.sid.demo.repository.TaskRepository;
import com.sid.dto.CountType;

/**
 * @author DELL
 *
 */
@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	@Transactional(readOnly = true)
	public List<Task> getTasks(){
		return taskRepository.getAllTaskDueDateDesc();
	}
	public Task save(Task task) {
		return taskRepository.saveAndFlush(task);
	}
	@Transactional(readOnly = true)
	public boolean existById(Long id) {
		return taskRepository.existsById(id);
	}
	/**
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<Task> getTaskById(Long id) {
		
		return taskRepository.findById(id);
	}
	/**
	 * @param id
	 */
	public void delete(Long id) {
		taskRepository.deleteById(id);
		
	}
	public List<CountType> getPercentageGroupByType() {
		return taskRepository.getPercentageGroupByType();
		
	}
	
}
