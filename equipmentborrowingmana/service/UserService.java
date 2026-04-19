package com.Ss10.MiniProject2.equipmentborrowingmana.service;


import com.Ss10.MiniProject2.equipmentborrowingmana.model.dto.UserRequest;
import com.Ss10.MiniProject2.equipmentborrowingmana.model.entity.User;

import java.util.Optional;

public interface UserService {
    void registerUser(UserRequest user);
    User login(String email, String password);
    Optional<User> findUserByEmail(String email);
}
