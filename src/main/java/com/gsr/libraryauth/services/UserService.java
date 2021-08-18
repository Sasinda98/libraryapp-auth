package com.gsr.libraryauth.services;


import com.gsr.libraryauth.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByID(Long userID);
    List<User> getUsers();
}
