package org.arpit.java2blog.dao;

import java.util.List;
import org.arpit.java2blog.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDaoImpl implements TodoDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Todo> getAllTodos() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Todo>  todoList = session.createQuery("from Todo").list();
		return todoList;
	}

	public Todo getTodo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Todo todo = (Todo) session.get(Todo.class, id);
		return todo;
	}

	public Todo addTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(todo);
		return todo;
	}

	public void updateTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(todo);
	}

	public void deleteTodo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Todo p = (Todo) session.get(Todo.class, id);
			session.delete(p);		
	} 
	
	
        public void taskStatus(int id, boolean Status) {            
            Session session = this.sessionFactory.getCurrentSession();
            Todo p =  session.get(Todo.class, id);
            p.setStatus(Status);
            session.update(p);                                          
    } 
}
