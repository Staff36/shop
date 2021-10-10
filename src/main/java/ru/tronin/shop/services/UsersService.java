package ru.tronin.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tronin.shop.handlers.IdentityMapUserHandler;
import ru.tronin.shop.models.User;
import ru.tronin.shop.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Component
public class UsersService {
    @Autowired
    UserRepository repository;
    @Autowired
    IdentityMapUserHandler identityMapUserHandler;

    public User getUserById(Long id){
        User userById = identityMapUserHandler.getUserFromRamById(id);

        if (userById == null){
            userById = repository.getUserById(id);
            if (userById == null) {
                throw new EntityNotFoundException("User not found");
            } else {
                identityMapUserHandler.addUserToRam(userById);
            }
        }
            return userById;

    }

    public void saveNewUser(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        repository.saveNewUser(user);
        identityMapUserHandler.addUserToRam(user);
    }


}
