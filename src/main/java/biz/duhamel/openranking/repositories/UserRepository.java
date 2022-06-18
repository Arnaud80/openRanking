package biz.duhamel.openranking.repositories;

import biz.duhamel.openranking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query("SELECT new users(u.userId, u.firstName, u.lastName, u.eloScore) FROM users u WHERE u.eloScore>0")
    List<User> getRanking();
}
