package com.tienda.online.services;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.models.Compra;
import com.tienda.online.repositories.CompraRepository;



@Service
public class CompraService {

	private CompraRepository compraRepository;

	public CompraService() {

	}
@Autowired
	public CompraService(CompraRepository compraRepository) {
		super();
		this.compraRepository = compraRepository;
	}
	

	public Compra guardar(Compra compra) {
		compra.setFecha(new Date());
		compra.setNroDocumento("000000000"+compraRepository.count()+1);
		compra.getListaDetalleCompra().forEach(detalle-> {detalle.setCompra(compra);
			
		});
		
		return compraRepository.save(compra);
	}

	public List<Compra> obtenerTodos() {
		return (List<Compra>) compraRepository.findAll();
	}

	public long total() {
		return compraRepository.count();
	}

	public void eliminar(Integer id) {
		compraRepository.delete(id);
	}

}
