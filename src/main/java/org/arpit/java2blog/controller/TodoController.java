package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.model.Todo;
import org.arpit.java2blog.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Todo> getAllTodos(Model model) {

		List<Todo> listOfTodos = todoService.getAllTodos();
		return listOfTodos;
	}
	
	@RequestMapping(value = "/getTodo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public void getTodoById(@PathVariable int id) {
	        todoService.getTodo(id);
	    }

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/tasks";
	}

	@RequestMapping(value = "/task/CREATE", method = RequestMethod.POST, headers = "Accept=application/json")
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);

	}

	@RequestMapping(value = "/task/UPDATE", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo);

	}

	@RequestMapping(value = "/task/DELETE/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteTodo(@PathVariable("id") int id) {
		todoService.deleteTodo(id);

	}
	
	@RequestMapping(value = "/taskStatus/{id}/{Status}", method = RequestMethod.PUT)
        public void taskStatus(@PathVariable("id") int id, @PathVariable("Status") boolean Status) {	    
         todoService.taskStatus(id, Status);

        }
}
