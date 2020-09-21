package auth.example.spring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "to_do")
public class ToDo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;


/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;*/

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    //
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) { this.description = description;}



}
