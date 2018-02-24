package com.tienda.online.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name="nro_documento")
	private String nroDocumento;
	
	private Date fecha;
	private BigDecimal precio;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	

	public Compra() {
		
	}

	

	public Compra(Integer id, String nroDocumento, Date fecha, BigDecimal precio, BigDecimal subtotal, BigDecimal iva,
			BigDecimal total, Usuario usuario) {
		super();
		Id = id;
		this.nroDocumento = nroDocumento;
		this.fecha = fecha;
		this.precio = precio;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.usuario = usuario;
	}

    @OneToMany(mappedBy="compra", cascade=CascadeType.ALL)
	private List<DetalleCompra> listaDetalleCompra;

    
    
	public List<DetalleCompra> getListaDetalleCompra() {
		return listaDetalleCompra;
	}



	public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
		this.listaDetalleCompra = listaDetalleCompra;
	}



	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public BigDecimal getIva() {
		return iva;
	}


	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}


	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
