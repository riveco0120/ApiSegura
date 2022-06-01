package com.DEMOJWT.demo.controller;

import com.DEMOJWT.demo.dto.User;
import com.DEMOJWT.demo.repository.RepositoryUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserController Controller
 *
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class UserController {

    @Autowired
    RepositoryUser repositoryUser;

    /**
     * Save a new user
     *
     * @param user DTO
     * @return User
     */
    @PostMapping("user")
    public User login(@RequestBody User user) {

        String token = getJWTToken(user);
        User newUser = new User();
        newUser.setUser(user.getUser());
        newUser.setToken(token);
        return repositoryUser.save(newUser);
    }

    /**
     * Generate a new JWT
     *
     * @param user DTO
     * @return Token
     */
    private String getJWTToken(User user) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        var token = Jwts
                .builder()
                .setId(user.id())
                .setSubject(user.getUser())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Valido " + token;
    }
}
