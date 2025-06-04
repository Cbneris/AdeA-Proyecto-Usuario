package com.cbns.adea.usuario.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.cbns.adea.usuario.service.EncriptacionShaBase64;

public class EncriptacionShaBase64Impl implements EncriptacionShaBase64 {

	@Override
	public String hashSha256Base64(String input) {
		try {
            // Crear instancia del algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Codificar en Base64
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al crear el hash SHA-256", e);
        }
	}

}
