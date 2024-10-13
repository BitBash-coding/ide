package bit_bash.ide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bit_bash.ide.model.User;
import bit_bash.ide.service.UserService;

import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // GET method for fetching all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // POST method for creating a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT method for updating a user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("## updateUser");
        return userService.updateUser(id, user);
    }

    // DELETE method for deleting a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("## deleteUser");
        userService.deleteUser(id);
    }
}
