package com.alvaro.TodoManager.controllers;

import java.util.List;

public interface TodoRepository {
	public Todo findById(int id);
	
	public List<Todo> getAll();
	
	public void addTodo(Todo todo);
	
	public void removeTodo(Todo todo);
}
