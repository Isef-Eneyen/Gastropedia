package com.IsefEneyen.Gastropedia.Services;

import com.IsefEneyen.Gastropedia.Models.User;
import com.IsefEneyen.Gastropedia.Repositories.UserRespository;

import java.util.List;

public class UserService {
    private UserRespository userRepository;

    public List<User> GetUsers() {return userRepository.findAll();}
    public User GetUserById(Long id) {return userRepository.findById(id).orElse(null);}
    public User GetUserByEmail(String email) {return userRepository.findByEmail(email);}
    public void DeleteUser(User user) {userRepository.delete(user);}
}
