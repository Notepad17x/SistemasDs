package com.clinica.service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.service.entidades.Clinica;
import com.clinica.service.servicio.ClinicaService;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {

	@Autowired
	private ClinicaService clinicaService;
	
	@GetMapping
	public ResponseEntity<List<Clinica>> listarClinicas() {
		List<Clinica> clinicas = clinicaService.getAll();
		if (clinicas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(clinicas);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Clinica> obtenerClinica(@PathVariable("id") int id) {
		Clinica clinica = clinicaService.getClinicaById(id);
		if (clinica == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clinica);
	}

	@PostMapping
	public ResponseEntity<Clinica> guardarDepartamento(@RequestBody Clinica clinica) {
		Clinica nuevaClinica = clinicaService.save(clinica);
		return ResponseEntity.ok(nuevaClinica);

	}
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Clinica>> listarClinicasPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Clinica> clinicas=clinicaService.byUsuarioId(id);
		if (clinicas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(clinicas);
	}
}


