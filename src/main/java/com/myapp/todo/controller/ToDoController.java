package com.myapp.todo.controller;

import java.util.List;

import com.myapp.todo.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToDoController {
	
	@Autowired
    private TaskService taskService;
	

	@RequestMapping(value="/tasks")
    public ModelAndView listOfTasks() {
        ModelAndView modelAndView = new ModelAndView("list-of-tasks");
         
        List<Task> tasks = taskService.getTasks();
        modelAndView.addObject("tasks", tasks);
        for(Task task: tasks){
        	System.out.println(task.getName());
        }
        return modelAndView;
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
