package com.Projeto_Agenda.Agenda_Simples.controller;

import java.util.List;
import java.util.Optional;

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

import com.Projeto_Agenda.Agenda_Simples.model.Agenda_dao;
import com.Projeto_Agenda.Agenda_Simples.repository.Agenda_Repository;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // ✅ Correto
@RequestMapping("/agenda")
public class Agenda_Controller {
	
	@Autowired
	private Agenda_Repository agenda_repository;
	
	@GetMapping(value = "/teste")
	public String teste() {
		return "Servidor Rodandado !!!";
	}
	@GetMapping(value = "/listaContatos")
	public List<Agenda_dao>listaContatos(){
		return(List<Agenda_dao>)agenda_repository.findAll();
	}
	@PostMapping
	public Agenda_dao inserirContatos(@RequestBody Agenda_dao agenda_dao) {
		Agenda_dao novoContato = agenda_repository.save(agenda_dao);
		return novoContato;
	}
	@PutMapping
	public Agenda_dao atualizarContatos(@RequestBody Agenda_dao agenda_dao) {
		Agenda_dao atualizarContato = agenda_repository.save(agenda_dao);
		return atualizarContato;
	}
	@DeleteMapping("/{id}")
	public String deletarContatos(@PathVariable Integer id) {
		Optional<Agenda_dao>agenda_dao = agenda_repository.findById(id);
		if(agenda_dao.isPresent()) {
			agenda_repository.deleteById(id);
			return "Contato com  ID " + id + " deletado foi sucesso!!!";
		}
		else {
			return "Contato com  ID " + id + " não encontrado";
		}
	}
	
	
	

}
