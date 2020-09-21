package auth.example.spring.repositories;


import auth.example.spring.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, String> {

    ToDo findById(int id);

}
