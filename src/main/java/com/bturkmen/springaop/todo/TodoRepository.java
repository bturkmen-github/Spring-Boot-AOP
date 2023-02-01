package com.bturkmen.springaop.todo;

import com.bturkmen.springaop.aspects.Timed;
import com.bturkmen.springaop.todo.domain.Todo;
import com.bturkmen.springaop.todo.domain.TodoList;
import com.bturkmen.springaop.todo.utils.ErrorResult;
import com.bturkmen.springaop.todo.utils.Result;
import com.bturkmen.springaop.todo.utils.SuccessResult;

import org.springframework.stereotype.Repository;

import java.util.*;

import static java.lang.String.format;

@Repository
public class TodoRepository {
    private Map<UUID, List<TodoList>> db = new HashMap<>();

    @Timed
    public void add(final UUID userId, final TodoList list) {
        if (get(userId, list.getName()).isPresent()) {
            throw new IllegalArgumentException(format("List with name %s already exists", list.getName()));
        }
        if (list.getTodos() == null) {
            list.setTodos(new ArrayList<>());
        }
        get(userId).add(list);
    }

    @Timed
    public List<TodoList> get(final UUID userId) {
        return db.computeIfAbsent(userId, u -> new ArrayList<>());
    }

    @Timed
    public Optional<TodoList> get(final UUID userId, final String todoList) {    	
        return get(userId).stream().filter(l -> l.getName().equalsIgnoreCase(todoList)).findAny();
    }

    @Timed
    public Result delete(final UUID userId) {
    	try {
    		db.remove(userId);
    		return new SuccessResult("Deleted");
    	}catch(Exception ex) {
    		return new ErrorResult(ex.getMessage());
    	}
        
    }

    @Timed
    public Result delete(final UUID userId, final String todoList) {
    	try {
    		List<TodoList> list = get(userId);
            list.removeIf(l -> l.getName().equals(todoList));
            return new SuccessResult("List deleted");
    	}catch(Exception ex) {
    		return new ErrorResult(ex.getMessage());
    	}
        
    }

    @Timed
    public Result deleteAll() {
    	try {
    		db.clear();
    		return new SuccessResult("Deleted");
    	}catch(Exception ex) {
    		return new ErrorResult(ex.getMessage());
    	}        
    }
    
    @Timed
    public Result addTodo(final UUID userId, final String todoList,Todo todo) {
    	Optional<TodoList> list = get(userId,todoList);
    	if(list.isPresent()) {
    		list.get().getTodos().add(todo);    
    		return new SuccessResult("Added to List");
    	}else {
    		return new ErrorResult("List Not Found");
    	}
    }
    
}
