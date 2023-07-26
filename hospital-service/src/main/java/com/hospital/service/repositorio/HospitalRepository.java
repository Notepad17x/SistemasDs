package com.hospital.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.service.entidades.Hospital;



@Repository
public interface HospitalRepository  extends JpaRepository<Hospital, Integer>{

	List<Hospital> findByUsuarioId(int usuarioId);
}