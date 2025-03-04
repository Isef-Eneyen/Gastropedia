package com.IsefEneyen.Gastropedia.Repositories;

import com.IsefEneyen.Gastropedia.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
