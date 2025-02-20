package projeto.apirest.domain.service;

import projeto.apirest.domain.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
    List<User> findAll();
    void deleteById(Long id);
}
