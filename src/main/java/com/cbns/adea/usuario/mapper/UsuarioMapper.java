package com.cbns.adea.usuario.mapper;

import com.cbns.adea.usuario.dto.UsuarioResponse;
import com.cbns.adea.usuario.entity.UsuarioEntity;

public class UsuarioMapper {
	
	public static UsuarioResponse toDTO(UsuarioEntity entity) {
        if (entity == null) return null;

        return new UsuarioResponse(
                entity.getLogin(),
                entity.getNombre(),
                entity.getCliente(),
                entity.getEmail(),
                entity.getFechaAlta(),
                entity.getFechaBaja(),
                entity.getStatus(),
                entity.getIntentos(),
                entity.getFechaRevocado(),
                entity.getFechaVigencia(),
                entity.getNoAcceso(),
                entity.getApellidoPaterno(),
                entity.getApellidoMaterno(),
                entity.getArea(),
                entity.getFechaModificacion()
            );
    }
	
	 public static UsuarioEntity fromDTO(UsuarioResponse dto) {
	        if (dto == null) return null;

	        UsuarioEntity entity = new UsuarioEntity();

	        entity.setLogin				(dto.getLogin());
	        entity.setNombre			(dto.getNombre());
	        entity.setCliente			(dto.getCliente());
	        entity.setEmail				(dto.getEmail());
	        entity.setFechaAlta			(dto.getFechaAlta());
	        entity.setFechaBaja			(dto.getFechaBaja());
	        entity.setStatus			(dto.getStatus());
	        entity.setIntentos			(dto.getIntentos());
	        entity.setFechaRevocado		(dto.getFechaRevocado());
	        entity.setFechaVigencia		(dto.getFechaVigencia());
	        entity.setNoAcceso			(dto.getNoAcceso());
	        entity.setApellidoPaterno	(dto.getApellidoPaterno());
	        entity.setApellidoMaterno	(dto.getApellidoMaterno());
	        entity.setArea				(dto.getArea());
	        entity.setFechaModificacion	(dto.getFechaModificacion());

	        return entity;
	    }
}
