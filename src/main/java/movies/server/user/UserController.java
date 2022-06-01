package movies.server.user;

import movies.server.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static movies.server.util.Tokens.generateNewToken;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        userService.register(user);
        return new ResponseEntity<>(user.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/auth")
    public ResponseEntity<String> login(@RequestBody User user) {
        if(userService.findByUsernameAndPassword(user)) return new ResponseEntity<>("access", HttpStatus.OK);
        return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
    }
}
