package com.myapp.todo.model;

import java.util.List;

public interface TaskService {
	
	public List<Task> getTasks();
	public void addTask(Task task);
    public Task findTask(int id);
    public void markAsDone(Task task);
    public void deleteDone();  

}
