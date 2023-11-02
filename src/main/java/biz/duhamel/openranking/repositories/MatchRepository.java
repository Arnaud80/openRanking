package biz.duhamel.openranking.repositories;

import biz.duhamel.openranking.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
