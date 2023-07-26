package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.usuario.service.modelos.Clinica;

@FeignClient(name = "clinica-service", url = "http://localhost:8002", path = "/clinica")
public interface ClinicaFeignClient {

	@PostMapping()
	public Clinica save(@RequestBody Clinica clinica);
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Clinica> getClinicas(@PathVariable("usuarioId")int usuarioId);
	
}
