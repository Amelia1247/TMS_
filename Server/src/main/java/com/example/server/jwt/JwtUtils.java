package com.example.server.jwt;

import com.example.server.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is responsible for generating and verifying the token.
 * A util class for JWT.
 */
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long EXPIRATION_TIME;

    /**
     * Generates a token for the user
     * @param userDTO
     * @return
     */
    public String generateToken(UserDTO userDTO) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        Date expirationDate = calendar.getTime();


        Claims claims = Jwts.claims();
        claims.put(Claims.SUBJECT, userDTO.getUsername());
        claims.put("username", userDTO.getUsername());
        claims.put("role", userDTO.getRole());

        return Jwts.builder().setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }
    Key getSignInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    /**
     * Verifies if the token is valid
     * @param token
     * @param userDetails
     * @return
     */
    public boolean verifyToken(String token, UserDetails userDetails) {
        try {
            final String username = getUsernameFromToken(token);
            return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
        } catch (ExpiredJwtException e) {
            return false;
        }
    }
    private boolean isTokenExpired(String token) {
        Claims parsed = parseToken(token);
        return parsed.getExpiration().before(new Date());

    }

    /**
     * Gets the username from the token
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        Claims parsed = parseToken(token);
        return parsed.getSubject();
    }
    private Claims parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();

    }

}
