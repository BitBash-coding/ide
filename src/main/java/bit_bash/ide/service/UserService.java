package bit_bash.ide.service;

import org.springframework.stereotype.Service;

import bit_bash.ide.model.User;
import bit_bash.ide.repository.UserRepository;

import java.util.Optional;  // Correct import
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection for UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        System.out.println("## getAllUsers");
        return userRepository.findAll();
    }

    public User createUser(User user) {
        // user.setId(null);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setEmail(user.getEmail());
            updatedUser.setUsername(user.getUsername());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
