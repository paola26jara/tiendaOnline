package com.tienda.online.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.tienda.online.models.Usuario;

import com.tienda.online.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseController  {

	UsuarioService usuarioService;
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class); // logs

	public UsuarioController() {

	}

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	/*
	 * hola pao
	 */
	
	

	@PostMapping(produces = "application/json")
	public Usuario guardarUsuario(@RequestBody @Validated Usuario usuario) {
		try {
			Usuario nuevoUsuario= usuarioService.guardar(usuario);
			if(nuevoUsuario==null)
			{
				throw new DataIntegrityViolationException("Ya existe un usuario con el emali:"+usuario.getEmail());
				
			}
			return nuevoUsuario;
			
		} catch (NoSuchElementException e) {
			logger.info("Error en el consumo de servicio guardar Usuario:"+e.getMessage());
				throw new DataIntegrityViolationException("Error en el consumo del servicio: ");
		}
	}

	@GetMapping(produces = "application/json")
	public List<Usuario> obtenerTodos() {
		try {
			return usuarioService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del UsuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public Usuario actualizarUsuario(@RequestBody @Validated Usuario usuario) {
		try {
			return usuarioService.guardar(usuario);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del UsuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			usuarioService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del usuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}


}
