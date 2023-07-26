package com.hospital.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.service.entidades.Hospital;
import com.hospital.service.servicio.HospitalService;


@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping
	public ResponseEntity<List<Hospital>> listarHospitales() {
		List<Hospital> hospitales = hospitalService.getAll();
		if (hospitales.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(hospitales);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Hospital> obtenerHospital(@PathVariable("id") int id) {
		Hospital hospital = hospitalService.getHospitalById(id);
		if (hospital == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hospital);
	}

	@PostMapping
	public ResponseEntity<Hospital> guardarHospital(@RequestBody Hospital hospital) {
		Hospital nuevoHospital = hospitalService.save(hospital);
		return ResponseEntity.ok(nuevoHospital);

	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Hospital>> listarHospitalesPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Hospital> hospitales=hospitalService.byUsuarioId(id);
		if (hospitales.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(hospitales);
	}
}