package com.ejemplo.JWTprueba.controller;

import com.ejemplo.JWTprueba.model.DatosUsuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
public class GenerarControlador {

    SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private long expiration=86400000;
    @PostMapping("login")
    public String login(@RequestBody DatosUsuario datosUsuario){

        String usuario=datosUsuario.getUsuario()+"*"+datosUsuario.getPass();

        final Instant now=Instant.now();

        final String jwt=Jwts.builder()
                .setSubject(usuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();


        return "token: "+jwt;
    }


}
