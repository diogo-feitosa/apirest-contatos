package com.contatos.apirest.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.apirest.models.Contatos;
import com.contatos.apirest.repository.ContatosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Contatos")
public class ContatoController {
	
	@Autowired
	ContatosRepository contatoRepository;
	@CrossOrigin
	@ApiOperation(value="Retorna uma lista de contatos")
	@GetMapping("/contatos")
	
	public List<Contatos> listaCursos(){
		return contatoRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um contato unico")
	@GetMapping("/contato/{id}")
	public Contatos listaContatoUnico(@PathVariable(value="id") long id){
		return contatoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um contato")
	@PostMapping("/contato")
	public Contatos salvaContato(@RequestBody  Contatos contato) {
		return contatoRepository.save(contato);
	}
	
	@ApiOperation(value="Deleta um contato")
	@DeleteMapping("/contato/{id}")
	public void deletaContato(@PathVariable(value="id") long id) {
		contatoRepository.deleteById(id);
	}
	
	@ApiOperation(value="Atualiza um curso")
	@PutMapping("/contato/{id}")
	public Contatos atualizaContato(@RequestBody  Contatos contato, @PathVariable(value="id") long id ) {
		return contatoRepository.save(contato);
	}
	 

}