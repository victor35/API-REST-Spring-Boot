package com.victormarques.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victormarques.cursomc.domain.Estado;
import com.victormarques.cursomc.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAllByOrderByName(){
		return repo.findAllByOrderByNome();
	}
}
