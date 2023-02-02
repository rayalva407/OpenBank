package com.openbank.openbank.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUser(Long id) {
        
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User editUser(User user, Long id) {
        Optional<User> userToEdit = userRepository.findById(id);
        if (userToEdit.isPresent()) {
            userToEdit.get().setFirstName(user.getFirstName());
            userToEdit.get().setLastName(user.getLastName());
            return userRepository.save(userToEdit.get());
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

    public User deleteUser(@PathVariable Long id) {
        Optional<User> userToDelete = userRepository.findById(id);
        if(userToDelete.isPresent()) {
            userRepository.deleteById(id);
            return userToDelete.get();
        }
        else {
            throw new UserNotFoundException(id);
        }
    }
}
