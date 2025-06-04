package com.cbns.adea.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbns.adea.usuario.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>{
	Optional<UsuarioEntity> findByLogin(String login);
}