package com.jobseekerapprenticeship.spring_api_test.services.auth;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static final String SECRET = "608ebd5299e28f92a7c645f7ade96ed125b4c0e9c8858015eab1274d963ec96262a91951638ba81d44ed0d19f1231d3db26cb5229879d3545f0b6e5e8565d9f3";

    /**
     * Return email apabila token valid, return null apabila token tidak valid
     * @param token JWT Token
     */
    public String getEmail(String token){
        if (isExpired(token))
            return null;
        return getClaim(token, Claims::getSubject);
    }

    private boolean isExpired(final String token){
        final Date expirationDate = getClaim(token, Claims::getExpiration);
        return new Date(System.currentTimeMillis()).after(expirationDate);
    }

    private <T> T getClaim(String token, Function<Claims, T> resolver){
        return resolver.apply(getAllClaims(token));
    }

    private Claims getAllClaims(String token){
        final JwtParser jwtParser = Jwts.parser()
                .verifyWith(getSecretKey())
                .build();

        return jwtParser
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretKey(){
        final byte[] keyBytes = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateJwt(String email){
        final Date currentTime = new Date(System.currentTimeMillis());
        final Date expirationTime = new Date(currentTime.getTime() + 1000 * 3600 * 24 * 7);

        return Jwts
                .builder()
                .subject(email)
                .issuedAt(currentTime)
                .expiration(expirationTime)
                .signWith(getSecretKey())
                .compact();
    }
}
