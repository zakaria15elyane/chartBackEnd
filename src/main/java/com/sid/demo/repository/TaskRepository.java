/**
* TaskRepository.java
 * @author : ZAKARIA EL AYANE
 * @see : zakaria15elyane@gmail.com
 * @creation : 3 fév. 2021
 * @version : 1.0
 * 
 */
package com.sid.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sid.demo.entity.Task;
import com.sid.dto.CountType;

/**
 * @author DELL
 *
 */
public interface TaskRepository extends JpaRepository<Task,Long> {

	@Query(value = "select * from task order by due_date desc",nativeQuery = true)
	public List<Task> getAllTaskDueDateDesc();
	
	
	@Query(value="Select new com.sid.dto.CountType(COUNT(*)/(Select COUNT(*) from Task) *100,type) from Task GROUP BY type")
	public List<CountType> getPercentageGroupByType();
}
