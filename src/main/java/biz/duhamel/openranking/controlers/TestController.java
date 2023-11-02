package biz.duhamel.openranking.controlers;

import biz.duhamel.openranking.entities.User;
import biz.duhamel.openranking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        User user=userRepository.getById(1L);
        return "User Content." + user.getEmail();
    }
    @GetMapping("/mod")
    public String moderatorAccess() {
        return "Moderator Board.";
    }
    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Board.";
    }
}
