package com.alvaro.TodoManager.controllers;

import java.util.LinkedList;
import java.util.List;

public class TodoMapper {
	
	public static TodoTitleResponse map(Todo todo) {
		TodoTitleResponse tr = new TodoTitleResponse();
		tr.setTitle(todo.getTitle());
		return tr;
	}
	
	public static List<TodoTitleResponse> map(List<Todo> todos){
		List<TodoTitleResponse> todosResponse = new LinkedList();
		for(Todo t : todos) {
			TodoTitleResponse response = map(t);
			todosResponse.add(response);
		}
		
		return todosResponse;
	}

}
