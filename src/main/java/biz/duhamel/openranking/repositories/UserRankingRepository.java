package biz.duhamel.openranking.repositories;

import biz.duhamel.openranking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRankingRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.firstName, u.lastName, u.eloScore FROM users u WHERE u.eloScore>0")
    List<User> getRanking();
}
