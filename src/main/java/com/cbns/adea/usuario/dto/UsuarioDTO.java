package com.cbns.adea.usuario.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDTO {
	
	private String 	login;
    private String 	nombre;
    private Double 	cliente;
    private String 	email;
    private Date 	fechaAlta;
    private Date 	fechaBaja;
    private char 	status;
    private Double 	intentos;
    private Date 	fechaRevocado;
    private Date 	fechaVigencia;
    private Integer noAcceso;
    private String 	apellidoPaterno;
    private String 	apellidoMaterno;
    private int 	area;
    private Date 	fechaModificacion;
    
}