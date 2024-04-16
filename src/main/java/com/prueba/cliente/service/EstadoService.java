package com.prueba.cliente.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.cliente.model.Cliente;
import com.prueba.cliente.model.Estado;
import com.prueba.cliente.model.Prestamo;
import com.prueba.cliente.repository.EstadoRepository;
import com.prueba.cliente.service.PrestamoService.PrestamoNoEncontradoException;
@Service
public class EstadoService {

	
	@Autowired
	private EstadoRepository estadoRepository;

	//LISTAR TODOS LOS ESTADOS DE PRESTAMO 
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}
		
	
	//ELIMINAR ESTADO DE PRESTAMO
	public void deleteById(Integer id) {
		
		if (estadoRepository.existsById(id)) {
			estadoRepository.deleteById(id);
		}else {
			throw new EstadoNoEncontradoException("El Estado  no fue encontrado");
		}
	
	}
	
	
	
	//GUARDAR ESTADO
		public <S extends Estado> S saveEstado(S estado) {

	    
			// GUARDA EL PRESTAMO EN LA BASE DE DATOS
			return estadoRepository.save(estado);
					    
			   

		}

		
	
	@SuppressWarnings("serial")
	public class EstadoNoEncontradoException extends RuntimeException {
	    public EstadoNoEncontradoException(String mensaje) {
	        super(mensaje);
	    }
	}
	
	
	
	
	
	
}
