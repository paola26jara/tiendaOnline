package com.tienda.online.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.models.Usuario;
import com.tienda.online.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService() {

	}
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	
	public Usuario guardar(Usuario usuario) {
		usuario.setFecha(new Date());
		Usuario usuarioexiste= usuarioRepository.findByEmail(usuario.getEmail());
		if(usuarioexiste==null){
		return usuarioRepository.save(usuario);
		}
		return null;
		
	}

	public List<Usuario> obtenerTodos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public long total() {
		return usuarioRepository.count();
	}

	public void eliminar(Integer id) {
		usuarioRepository.delete(id);
	}

}
