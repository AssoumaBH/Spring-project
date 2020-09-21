package auth.example.spring.controllers;
import auth.example.spring.entities.ToDo;
import auth.example.spring.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ToDo")
public class ToDoController {

    @Autowired
    private ToDoService todoService;

    @GetMapping(value = "/")
    public ResponseEntity<List<ToDo>> getAllTodo() {
        List<ToDo> todos = todoService.getAllTodo();
        return new ResponseEntity<List<ToDo>>(todos, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo todo) {
        try {
            ToDo createTodo = todoService.save(todo);
            return new ResponseEntity<ToDo>(createTodo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
////

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getTodo(@PathVariable("id") int id) {
        ToDo todo = todoService.findById(id);
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    ////
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable("id") int id, @RequestBody ToDo todo) {
        ToDo updateTodo = todoService.updateTodo(id, todo);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }




    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK); //"student has been deleted successfully";
    }/**/

}
