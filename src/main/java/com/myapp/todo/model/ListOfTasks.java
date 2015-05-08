package com.myapp.todo.model;

import java.util.ArrayList;
import java.util.List;

//????? nie wiem czy potrzebne
public class ListOfTasks {
	private List<Task> thingsToDo;

	public ListOfTasks(){
		thingsToDo = new ArrayList<Task>();
	}
	
	public List<Task> getThingsToDo() {
		return thingsToDo;
	}

	public ListOfTasks addNewTask(Task taskToAdd){
		int temp_id = -1;
		if( thingsToDo.isEmpty() == false ){
			for(Task task: thingsToDo){
				if( temp_id < task.getTaskID()){
					temp_id = task.getTaskID();
				}
			}
		}
		taskToAdd.setTaskID(temp_id + 1);
		thingsToDo.add(taskToAdd);
		return this;
	}
	
	public ListOfTasks removeDone(){
		for(Task task: thingsToDo){
			if (task.isDone() == true){
				thingsToDo.remove(task);
			}
		}
		return this;
	}
	
	public ListOfTasks setTaskAsDone(Task taskDone){
		for(Task task: thingsToDo){
			if (task.getTaskID() == taskDone.getTaskID()){
				task.setDone(true);
				break;
			}
		}
		return this;
	}

	public void markAsDone(Task taskDone){
		for(Task task: thingsToDo){
			if (task.getTaskID() == taskDone.getTaskID()){
				task.setDone(true);
			}
		}
	}
}