package com.hospital.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.service.entidades.Hospital;
import com.hospital.service.repositorio.HospitalRepository;


@Service
public class HospitalService {
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> getAll(){
		return hospitalRepository.findAll();
	}
	
	public Hospital getHospitalById(int id){
		return hospitalRepository.findById(id).orElse(null);
	}
	
	public Hospital save(Hospital hospital) {
		Hospital nuevoHospital = hospitalRepository.save(hospital);
		return nuevoHospital;
	}	
	
	public List<Hospital> byUsuarioId(int usuarioId){
		return hospitalRepository.findByUsuarioId(usuarioId);	
	}
	
}