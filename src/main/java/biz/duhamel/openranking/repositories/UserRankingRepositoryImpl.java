package biz.duhamel.openranking.repositories;

import biz.duhamel.openranking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserRankingRepositoryImpl {
    //@Override
    @Query("SELECT u.firstName, u.lastName, u.eloScore FROM users u WHERE u.eloScore>0")
    public List<User> getRanking() {
        return null;
    }
}
