package com.cbns.adea.usuario.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tbl_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioEntity {
	
	@Id
	@Column(name = "LOGIN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String 	login;

	@Column(name = "PASSWORD")
	private String 	password;

	@Column(name = "NOMBRE")
	private String 	nombre;

	@Column(name = "CLIENTE")
	private Double 	cliente;

	@Column(name = "EMAIL")
	private String 	email;

	@Column(name = "FECHAALTA")
	private Date	fechaAlta;

	@Column(name = "FECHABAJA")
	private Date	fechaBaja;

	@Column(name = "STATUS")
	private char	status;

	@Column(name = "INTENTOS")
	private Double	intentos;

	@Column(name = "FECHAREVOCADO")
	private Date	fechaRevocado;

	@Column(name = "FECHA_VIGENCIA")
	private Date	fechaVigencia;

	@Column(name = "NO_ACCESO")
	private Integer noAcceso;

	@Column(name = "APELLIDO_PATERNO")
	private String	apellidoPaterno;

	@Column(name = "APELLIDO_MATERNO")
	private String	apellidoMaterno;

	@Column(name = "AREA")
	private int		area;

	@Column(name = "FECHAMODIFICACION")
	private Date	fechaModificacion;
	
}