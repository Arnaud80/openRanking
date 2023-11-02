package biz.duhamel.openranking.controlers;

import biz.duhamel.openranking.exceptions.ControlerExceptionNotFound;
import biz.duhamel.openranking.entities.User;
import biz.duhamel.openranking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UsersControler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<User> getById(@PathVariable Long id) {
        Optional<User> player = userRepository.findById(id);

        if(player.isEmpty()) {
            throw new ControlerExceptionNotFound("GET with id " + id + " not found");
        }

        return player;
    }

    @PostMapping
    public User create(@RequestBody final User user) {
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException notFound) {
            throw new ControlerExceptionNotFound("DELETE - with id " + id + " not found");
        }
    }

    @GetMapping("user-ranking")
    public @ResponseBody List<User> getRanking() {
        return userRepository.getRanking();
    }
}
