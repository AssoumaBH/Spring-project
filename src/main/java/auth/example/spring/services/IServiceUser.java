package auth.example.spring.services;

import java.util.List;

import auth.example.spring.entities.User;

public interface IServiceUser {

	public void register(User u);
	public List<User> getAll();
	public User findById(int id);
	public User save(User user);
	public void deleteUser(int id);
	public User updateUser(int id, User user);
	//public void delete(int id);
    public User finByUsername(String username);
}
