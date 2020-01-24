package com.victormarques.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victormarques.cursomc.domain.Cidade;
import com.victormarques.cursomc.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findByEstado(Integer id){
		return repo.findCidades(id);
	}
}
