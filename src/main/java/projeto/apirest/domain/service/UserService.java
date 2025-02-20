package projeto.apirest.domain.service;

import projeto.apirest.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
