package com.prueba.cliente.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.cliente.model.Estado;
import com.prueba.cliente.model.MetodoPago;
import com.prueba.cliente.repository.MetodoPagoRepository;


@Service
public class MetodoPagoService {

	
	@Autowired
	private MetodoPagoRepository metodoPagoRepository;

	
	//LISTAR TODOS LOS METODOS DE PAGO
	public List<MetodoPago> findAll() {
		return metodoPagoRepository.findAll();
	}
		
	
	//ELIMINAR METODO POR ID
	public void deleteById(Integer id) {
		if (metodoPagoRepository.existsById(id)) {
			metodoPagoRepository.deleteById(id);
		}else {
			throw new MetodoPagoNoEncontradoException("El Metodo de Pago no fue encontrado");
		}
			
	}
	
	
	//GUARDAR ESTADO
		public <S extends MetodoPago> S saveMetodo(S metodo) {

	    
			// GUARDA EL PRESTAMO EN LA BASE DE DATOS
			return metodoPagoRepository.save(metodo);
					    
		}

		
	
	
	@SuppressWarnings("serial")
	public class MetodoPagoNoEncontradoException extends RuntimeException {
	    public MetodoPagoNoEncontradoException(String mensaje) {
	        super(mensaje);
	    }
	}
	


}
