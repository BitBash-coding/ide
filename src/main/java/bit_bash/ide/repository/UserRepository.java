package bit_bash.ide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit_bash.ide.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Write extra queries here.
}
