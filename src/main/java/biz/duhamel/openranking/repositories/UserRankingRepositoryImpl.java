package biz.duhamel.openranking.repositories;

import biz.duhamel.openranking.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRankingRepositoryImpl {
    //@Override
    @Query("SELECT u.firstName, u.lastName, u.eloScore FROM users u WHERE u.eloScore>0")
    public List<User> getRanking() {
        return null;
    }
}
