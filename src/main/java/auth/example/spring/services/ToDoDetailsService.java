package auth.example.spring.services;

import auth.example.spring.entities.ToDo;

import java.util.List;

public interface ToDoDetailsService {
    public List<ToDo> getAllTodo();
    public ToDo findById(int id);
    public ToDo save(ToDo todo);
    public void deleteTodo(int id);
    public ToDo updateTodo(int id, ToDo todo);


}
