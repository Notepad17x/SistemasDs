package com.usuario.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Clinica;
import com.usuario.service.modelos.Hospital;
import com.usuario.service.servicio.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = usuarioService.getAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = usuarioService.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);

	}
	@PostMapping("/clinica/{usuarioId}")
	public ResponseEntity<Clinica> guardarClinica(@PathVariable("usuarioId") int usuarioId,@RequestBody Clinica clinica) {
		Clinica nuevaClinica = usuarioService.saveClinica(usuarioId, clinica);
		return ResponseEntity.ok(nuevaClinica);
	}
	
	@PostMapping("/hospital/{usuarioId}")
	public ResponseEntity<Hospital> guardarHospital(@PathVariable("usuarioId") int usuarioId,@RequestBody Hospital hospital) {
		Hospital nuevoHospital = usuarioService.saveHospital(usuarioId, hospital);
		return ResponseEntity.ok(nuevoHospital);
	}
	
	@GetMapping ("/todos/{animalId}")
	public ResponseEntity<Map<String, Object>> listarTodasLasMovilidades (@PathVariable("animalId") int animalId){
		Map<String, Object> resultado = usuarioService.getUsuarioAndSalud(animalId);
		return ResponseEntity.ok(resultado);
	}
	
}
