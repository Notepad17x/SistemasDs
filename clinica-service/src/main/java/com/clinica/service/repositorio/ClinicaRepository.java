package com.clinica.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.service.entidades.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer>{

	List<Clinica> findByUsuarioId(int usuarioId);

	
}