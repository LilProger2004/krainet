package com.krainet.timetrack.config.security.authjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;


/**
 *
 *Класс сервис для операций с JWT токеном
 */
@Service
public class JwtService {
    private final SecretKey jwtSecretKey = Jwts.SIG.HS256.key().build();

     //Извлечение имени пользователя из токена
    public String extractUserName(String token) {
        return getPayloadFromToken(token).get("name").toString();
    }

    //проверка токена
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);//сравниваем имя текущего пользователя и имя зашифрованное в токене
        return (userName.equals(userDetails.getUsername()));
    }


   //создание токена
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .claim("name", userDetails.getUsername()) //добавляем параметр name со значением логина нашего пользователя в payload
                .issuedAt(new Date(System.currentTimeMillis()))//устанавливаем время жизни токена
                .expiration(new Date(System.currentTimeMillis() + 100000 * 60 * 24))
                .signWith(jwtSecretKey, SignatureAlgorithm.HS256)//подписываем токен
                .compact();
    }

    //извлекаем данные из части payload
    private Claims getPayloadFromToken(String token) {
        return Jwts.parser()
                .verifyWith(jwtSecretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
