package qna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qna.repository.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
