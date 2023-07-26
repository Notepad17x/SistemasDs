package com.clinica.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.service.entidades.Clinica;
import com.clinica.service.repositorio.ClinicaRepository;

@Service
public class ClinicaService {
		@Autowired
		private ClinicaRepository clinicaRepository;
		
		public List<Clinica> getAll(){
			return clinicaRepository.findAll();
		}
		
		public Clinica getClinicaById(int id){
			return clinicaRepository.findById(id).orElse(null);
		}
		
		public Clinica save(Clinica clinica) {
			Clinica nuevaClinica = clinicaRepository.save(clinica);
			return nuevaClinica;
		}	
		
		public List<Clinica> byUsuarioId(int usuarioId){
			return clinicaRepository.findByUsuarioId(usuarioId);	
		}
		
	}
	

