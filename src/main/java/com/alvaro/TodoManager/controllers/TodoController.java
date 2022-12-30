package com.alvaro.TodoManager.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.TodoManager.persistence.InMemoryTodoRepository;

@RestController
@RequestMapping("/api")
public class TodoController {
	private TodoRepository repo;

	public TodoController() {
		repo = new InMemoryTodoRepository();
	}

	@GetMapping("/todo")
	public ResponseEntity<Todo> getSampleTodo() {
		var todo = new Todo();
		todo.setTitle("Titulo 1");
		todo.setDescription("Descripcion 1");
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@GetMapping("/todos/list")
	public ResponseEntity<List<TodoTitleResponse>> getAll() {
		var todos = repo.getAll();
		var todosWithTitle = TodoMapper.map(todos);
		
		var r = new ResponseEntity<List<TodoTitleResponse>>(todosWithTitle, HttpStatus.OK);

		return r;
	}

	@PostMapping("/todos")
	public ResponseEntity addTodo(@RequestBody CreateTodoRequest todo) {
		Todo todoToAdd = new Todo();
		todoToAdd.setId(0);
		todoToAdd.setTitle(todo.getTitle());
		todoToAdd.setDescription(todo.getDescription());

		repo.addTodo(todoToAdd);
		return ResponseEntity.ok("todo bien");
	}

	@DeleteMapping("/todos")
	public ResponseEntity deleteTodo(@RequestBody Todo todo) {
		repo.removeTodo(todo);
		return ResponseEntity.ok("todo bien");
	}

	@GetMapping("/todos")
	public ResponseEntity<Todo> findById(@RequestParam(name = "id") int id) {
		var todo = repo.findById(id);
		if (todo == null) {
			return new ResponseEntity<Todo>(new Todo(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

}
