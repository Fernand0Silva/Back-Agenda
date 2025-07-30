package com.Projeto_Agenda.Agenda_Simples.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Projeto_Agenda.Agenda_Simples.model.Agenda_dao;
@Repository
public interface Agenda_Repository extends CrudRepository<Agenda_dao,Integer> {

}
