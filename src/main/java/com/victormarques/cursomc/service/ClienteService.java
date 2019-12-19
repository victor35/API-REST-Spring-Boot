package com.victormarques.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victormarques.cursomc.domain.Cliente;
import com.victormarques.cursomc.repository.ClienteRepository;
import com.victormarques.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado Id: " + id + ", Tipo : "
				+ Cliente.class.getName()));
	}
}
