package com.victormarques.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victormarques.cursomc.domain.Cidade;
import com.victormarques.cursomc.domain.Estado;
import com.victormarques.cursomc.dto.CidadeDTO;
import com.victormarques.cursomc.dto.EstadoDTO;
import com.victormarques.cursomc.service.CidadeService;
import com.victormarques.cursomc.service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAllByOrderByNome(){
		List<Estado> list = service.findAllByOrderByName();
		List<EstadoDTO> listDto = list.stream()
				.map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer id){
		List<Cidade> list = cidadeService.findByEstado(id);
		List<CidadeDTO> listDto = list.stream()
				.map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
