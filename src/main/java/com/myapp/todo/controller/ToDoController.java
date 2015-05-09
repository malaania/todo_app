package com.myapp.todo.controller;

import com.myapp.todo.model.Task;
import com.myapp.todo.model.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ToDoController {
	
	@Autowired
    private TaskService taskService;
	

	@RequestMapping(value="/tasks")
    @ResponseBody
    public List<Task> listOfTasks() {
        return taskService.getTasks();
    }
	//@RequestMapping(value="/tasks")
	//@ResponseBody
    //public List<Task> listOfTasks() {   
    //   return taskService.getTasks();
    //}

	
	
	
	/*
	@RequestMapping(value="/tasks")
	@ResponseBody
	public List< Task > findAll(){		
		toDoList = new ListOfTasks();
		return toDoList.getThingsToDo();
	}*/
	
	/*
	 @RequestMapping( method = RequestMethod.POST )
	 public ListOfTasks addTask( @RequestBody Task task ){
		 return toDoList.addNewTask(task);
	 }
	 
	 @RequestMapping( value = "/tasks/done", method = RequestMethod.POST, headers="Accept=application/json" )
	 public ListOfTasks setDone( @RequestBody Task task ){
		 return toDoList.setTaskAsDone(task);
	 }
	 
	 @RequestMapping( value="/tasks/remove", method = RequestMethod.POST, headers="Accept=application/json" )
	 public ListOfTasks removeDone( ){
		 return toDoList.removeDone();
	 }
	
	
	
	/*
	@RequestMapping("/task")
	@ResponseBody 
	public Task getTaskInJSON() {
		Task task = new Task("pranie","we wtorek po poludniu");
		return task; 
	}*/
	

}
