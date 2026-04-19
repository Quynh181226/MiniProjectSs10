package com.Ss10.MiniProject2.equipmentborrowingmana.service;

import com.Ss10.MiniProject2.equipmentborrowingmana.customException.EmailException;
import com.Ss10.MiniProject2.equipmentborrowingmana.customException.InvalidCredentialsException;
import com.Ss10.MiniProject2.equipmentborrowingmana.model.dto.UserRequest;
import com.Ss10.MiniProject2.equipmentborrowingmana.model.entity.Role;
import com.Ss10.MiniProject2.equipmentborrowingmana.model.entity.User;
import com.Ss10.MiniProject2.equipmentborrowingmana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(UserRequest user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailException("Email đã tồn tại");
        }
        User newUser = new User(
            1,
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                Role.STUDENT
        );
        userRepository.save(newUser);
    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        // check user tồn tại
        if (user == null) {
            throw new InvalidCredentialsException("Email hoặc mật khẩu không đúng");
        }

        // check password
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Email hoặc mật khẩu không đúng");
        }

        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
}
