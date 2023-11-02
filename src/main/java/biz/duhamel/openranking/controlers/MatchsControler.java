package biz.duhamel.openranking.controlers;

import biz.duhamel.openranking.exceptions.ControlerExceptionNotFound;
import biz.duhamel.openranking.entities.Match;
import biz.duhamel.openranking.repositories.MatchRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/matchs")
public class MatchsControler {
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    private List<Match> list() {
        return matchRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    private Optional<Match> getById(@PathVariable Long id) {
        Optional<Match> match = matchRepository.findById(id);

        if(match.isEmpty()) {
            throw new ControlerExceptionNotFound("GET with id " + id + " not found");
        }

        return match;
    }

    @PostMapping
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Match create(@RequestBody final Match match) {
        return matchRepository.saveAndFlush(match);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        try {
            matchRepository.deleteById(id);
        } catch (EmptyResultDataAccessException notFound) {
            throw new ControlerExceptionNotFound("DELETE - with id " + id + " not found");
        }
    }
}
