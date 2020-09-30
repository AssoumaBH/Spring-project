package auth.example.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import auth.example.spring.entities.User;
import auth.example.spring.services.IServiceUser;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
    private IServiceUser userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/users")
    public List<User> listUser(){
        return userService.getAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('ADMIN')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping( "/users/{id}")
    public User getOne(@PathVariable(value = "id") int id){
        return userService.findById(id);
    }


    // get all  user
//    @GetMapping(value="/users")
//    public List<User> listUser(){
//        return userService.getAll();
//    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.save(user);
            return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
//        User user = userService.findById(id);
//        return new ResponseEntity(user, HttpStatus.OK);
//    }

    ////
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }




    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        System.out.println(id);
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK); //"student has been deleted successfully";
    }


}
