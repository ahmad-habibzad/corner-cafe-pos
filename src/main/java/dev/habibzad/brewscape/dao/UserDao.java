package dev.habibzad.brewscape.dao;

import dev.habibzad.brewscape.security.dto.RegisterUserDto;
import dev.habibzad.brewscape.security.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
