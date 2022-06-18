package biz.duhamel.openranking.controlers;

import biz.duhamel.openranking.models.User;
import biz.duhamel.openranking.repositories.UserRankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rank")
public class RankController {
    @Autowired
    private UserRankingRepository userRankingRepository;

    @GetMapping
    public List<User> list() {
        return userRankingRepository.getRanking();
    }
}
