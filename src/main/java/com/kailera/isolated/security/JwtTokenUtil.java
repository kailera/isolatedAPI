package com.kailera.isolated.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component // visivel para di, autodeteccao para beans anotados
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -231293128938192L;
    public static final long JWT_TOKEN_VALIDITY = 4 * 60 * 80 ;

    @Value("${jwt.secret}")
    private  String secret;

    //username token jwt
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    //expiration date token jwt
    public Date getExpirationFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // public method, only get the necessary info and don't has direct access to jwt token
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver ){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // all token information
    // note that method is private, so only the class has access to token info
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }

    // check if the token has expired
    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    // generate user token - userside
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    //generate token - systemside
    private String doGenerateToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() - JWT_TOKEN_VALIDITY * 1000))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.RS256)
                .compact(); // HOLYSHIT
    }

    //token validator

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
}
