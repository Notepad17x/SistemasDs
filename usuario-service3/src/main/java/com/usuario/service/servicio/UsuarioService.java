package com.usuario.service.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.feignclients.ClinicaFeignClient;
import com.usuario.service.feignclients.HospitalFeignClient;
import com.usuario.service.modelos.Clinica;
import com.usuario.service.modelos.Hospital;
import com.usuario.service.repositorio.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ClinicaFeignClient clinicaFeignClient;
	@Autowired
	private HospitalFeignClient hospitalFeignClient;
	
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(int id){
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		return nuevoUsuario;
	}	
	
	public Clinica saveClinica(int usuarioId,Clinica clinica) {
		clinica.setUsuarioId(usuarioId);
		Clinica nuevaClinica = clinicaFeignClient.save(clinica);
		return nuevaClinica;	
	}
	
	public Hospital saveHospital(int usuarioId, Hospital hospital) {
		hospital.setUsuarioId(usuarioId);
		Hospital nuevHospital = hospitalFeignClient.save(hospital);
		return nuevHospital;
	}

	public Map<String, Object> getUsuarioAndSalud(int usuarioId) {
		Map<String, Object> resultado = new HashMap<>();
		Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

		if (usuario == null) {
			resultado.put("Mensaje", "El mensaje no existe");
			return resultado;
		}
		resultado.put("Hospital", usuarioId);
		List<Hospital> hospital = hospitalFeignClient.getHospitales(usuarioId);
		if (hospital.isEmpty()) {
			resultado.put("Hospital", "El Usuario no tiene Hospital");
		} else {
			resultado.put("Hospital", hospital);
		}

		List<Clinica> clinica = clinicaFeignClient.getClinicas(usuarioId);
		if (clinica.isEmpty()) {
			resultado.put("Clinica", "El Usuario no tiene Clinica");
		} else {
			resultado.put("Clinica", clinica);
		}
		return resultado;
	}
}

	

