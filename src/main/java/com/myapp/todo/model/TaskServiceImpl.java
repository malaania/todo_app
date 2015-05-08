package com.myapp.todo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
    private TasksDAO taskDAO;

	public List<Task> getTasks() {
		return taskDAO.getTasks();
	}

	public void addTask(Task task) {
		taskDAO.addTask(task);		
	}

	public Task findTask(int id) {
		return taskDAO.findTask(id);
	}

	public void markAsDone(Task task) {
		taskDAO.markAsDone(task);
	}


	public void deleteDone() {
		taskDAO.deleteDone();
	}
}
