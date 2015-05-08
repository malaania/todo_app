package com.myapp.todo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TasksDAOImpl implements TasksDAO {

	@Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void addTask(Task task) {
        getCurrentSession().save(task);
    }


	@SuppressWarnings("unchecked") 
	public List<Task> getTasks() {		
		return getCurrentSession().createQuery("from Task").list();
	}


	public Task findTask(int id) {
		Task task = (Task) getCurrentSession().get(Task.class, id);
        return task;
	}

	public void markAsDone(Task task) {
		Task taskCompleted = findTask(task.getTaskID());
		taskCompleted.setDone(true);
		getCurrentSession().update(taskCompleted);
	}

	public void deleteDone() {
		List<Task> listOfTasks = getTasks();
		for(Task task: listOfTasks){
			if(task.isDone() == true){
				getCurrentSession().delete(task);
			}
		}
	}

}