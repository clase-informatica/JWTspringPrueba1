package com.ejemplo.JWTprueba.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class DatosUsuario {

    @Getter
    @Setter
    public String usuario;

    @Setter
    @Getter
    public String pass;
}
