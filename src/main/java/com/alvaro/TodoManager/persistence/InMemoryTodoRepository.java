package com.alvaro.TodoManager.persistence;

import java.util.LinkedList;
import java.util.List;

import com.alvaro.TodoManager.controllers.Todo;
import com.alvaro.TodoManager.controllers.TodoRepository;

public class InMemoryTodoRepository implements TodoRepository{
	private List<Todo> todos;
	
	public InMemoryTodoRepository() {
		todos = new LinkedList<Todo>();
		var todo1 = new Todo();
		todo1.setId(1);
		todo1.setTitle("Titulo 1");
		todo1.setDescription("Descripcion 1");

		var todo2 = new Todo();
		todo2.setId(2);
		todo2.setTitle("Titulo 2");
		todo2.setDescription("Descripcion 2");

		var todo3 = new Todo();
		todo3.setId(3);
		todo3.setTitle("Titulo 3");
		todo3.setDescription("Descripcion 3");

		todos.add(todo1);
		todos.add(todo2);
		todos.add(todo3);
	}
	
	public Todo findById(int id) {
		for(Todo t : todos) {
			if(t.getId() == id)
				return t;
		}
		return null;
	}
	
	public List<Todo> getAll(){
		return todos;
	}
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	public void removeTodo(Todo todo) {
		todos.remove(todo);
	}
}
