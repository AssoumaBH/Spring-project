package auth.example.spring.services;

import auth.example.spring.entities.ToDo;
import auth.example.spring.repositories.ToDoRepository;
import auth.example.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService implements ToDoDetailsService {

    private final ToDoRepository todoRepository;


    @Autowired
    public ToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    // get all
    @Override
    public List<ToDo> getAllTodo() {
        return todoRepository.findAll();
    }

    // get by id
    @Override
    public ToDo findById(int id) {
        return todoRepository.findById(id);

    }

    // post ==> create new todo
    @Override
    public ToDo save(ToDo todo) {
        return todoRepository.save(todo);
    }


    // delete a todo by id
    @Override
    public void deleteTodo(int id) {
        ToDo todo = todoRepository.findById(id);
        todoRepository.delete(todo);
    }


    // put ==> update todo by  id
    @Override
    public ToDo updateTodo(int id, ToDo todo) {
        ToDo updateTodo = todoRepository.findById(id);
        updateTodo.setName(todo.getName());
        updateTodo.setDescription(todo.getDescription());

        // save in database
        return todoRepository.save(updateTodo);
    }

}


