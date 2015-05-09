package com.myapp.todo.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class TasksDAOImpl implements TasksDAO {

	@PersistenceContext
    private EntityManager em;
     
    public void addTask(Task task) {
        em.persist(task);
    }


	public List<Task> getTasks() {
		return em.createQuery("select t from Task t",Task.class).getResultList();
	}


	public Task findTask(int id) {
        return em.find(Task.class, id);
    }

	public void markAsDone(Task task) {
		Task taskCompleted = findTask(task.getTaskID());
		taskCompleted.setDone(true);
	}

	public void deleteDone() {
		List<Task> listOfTasks = getTasks();
		for(Task task: listOfTasks){
			if(task.isDone() == true){
				em.remove(task);
			}
		}
	}

}