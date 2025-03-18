package projeto.apirest.domain.service.impl;

import org.springframework.stereotype.Service;
import projeto.apirest.domain.model.User;
import projeto.apirest.domain.repository.UserRepository;
import projeto.apirest.domain.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user, User userUpdated) {
        if (userUpdated.getName() != null) {
            user.setName(userUpdated.getName());
        }
        if (userUpdated.getAccount() != null) {
            user.setAccount(userUpdated.getAccount());
        }
        if (userUpdated.getFeatures() != null) {
            user.setFeatures(userUpdated.getFeatures());
        }
        if (userUpdated.getNews() != null) {
            user.setNews(userUpdated.getNews());
        }
        if (userUpdated.getCard() != null) {
            user.setCard(userUpdated.getCard());
        }
        userRepository.save(user);
    }


}
