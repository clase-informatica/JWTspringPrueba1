package com.ejemplo.JWTprueba.controller;

import com.ejemplo.JWTprueba.model.DatosUsuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@RestController
public class GenerarControlador {

    @Value("${mi.claveSecreta}")
    private String claveSecreta;
    private long expiration=86400000;
    @PostMapping("login")
    public String login(@RequestBody DatosUsuario datosUsuario){

        String usuario=datosUsuario.getUsuario()+"*"+datosUsuario.getPass();

        final Instant now=Instant.now();
        //String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());

       final String jwt=Jwts.builder()
                .setSubject(usuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, claveSecreta)
                .compact();


        return "token: "+jwt;
    }

    @PostMapping("restringido")
    public String acceso(){
        return "Acceso concedido";
    }


}
