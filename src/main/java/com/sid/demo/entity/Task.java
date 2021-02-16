/**
* Task.java
 * @author : ZAKARIA EL AYANE
 * @see : zakaria15elyane@gmail.com
 * @creation : 3 fév. 2021
 * @version : 1.0
 * 
 */
package com.sid.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DELL
 *
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Task {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String type;
	private Date dueDate;
	private String description;
}
