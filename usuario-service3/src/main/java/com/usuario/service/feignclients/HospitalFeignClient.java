package com.usuario.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.modelos.Hospital;

@FeignClient(name = "hospital-service", url = "http://localhost:8003", path = "/hospital")
public interface HospitalFeignClient {

	@PostMapping()
	public Hospital save(@RequestBody Hospital hospital);
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Hospital> getHospitales(@PathVariable("usuarioId")int usuarioId);
}