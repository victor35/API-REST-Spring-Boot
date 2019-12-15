package com.victormarques.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victormarques.cursomc.domain.Pedido;
import com.victormarques.cursomc.repository.PedidoRepository;
import com.victormarques.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado Id: " + id + ", Tipo : "
				+ Pedido.class.getName()));
	}
}
