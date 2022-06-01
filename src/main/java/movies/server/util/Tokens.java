package movies.server.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.security.SecureRandom;
import java.util.Base64;

public class Tokens {

    public static String generateNewToken(String user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer(user)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            return "";
        }
    }
}
