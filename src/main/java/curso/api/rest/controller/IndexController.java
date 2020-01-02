package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController // Arquitetura Rest
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired // se fosse CDI seria @Inject
	private UsuarioRepository usuarioRepository;

	// Consulta por id para gerar um relatorio
	@GetMapping(value = "/{id}/relatoriopdf", produces = "application/pdf")
	public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	// Consulta por id para gerar uma venda
	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/pdf")
	public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id,
			@PathVariable(value = "venda") Long venda) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	// Consulta por id
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	// Consulta todos
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario() {

		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();

		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}

	/*
	 * //Serviço RestFull
	 * 
	 * @GetMapping(value = "/", produces = "application/json") public ResponseEntity
	 * init(@RequestParam (value = "nome",required = true, defaultValue =
	 * "nome não informado") String nome, @RequestParam (value = "salario") Long
	 * salario) { System.out.println("Parametro sendo recebido "+nome); return new
	 * ResponseEntity("Olá Usuário REST Spring Boot seu nome é: "+nome+" salario é:"
	 * +salario, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping(value = "/", produces = "application/json") public
	 * ResponseEntity<Usuario> init(){
	 * 
	 * Usuario usuario = new Usuario(); usuario.setId(50L);
	 * usuario.setLogin("alex.fernando.egidio@gmail.com");
	 * usuario.setSenha("162130"); usuario.setNome("alex fernando egidio");
	 * 
	 * Usuario usuario2 = new Usuario(); usuario2.setId(50L);
	 * usuario2.setLogin("asasasas@gmail.com"); usuario2.setSenha("162130");
	 * usuario2.setNome("asaasasaasao");
	 * 
	 * List<Usuario> usuarios = new ArrayList<Usuario>();
	 * 
	 * //return ResponseEntity.ok(usuario); usuarios.add(usuario);
	 * usuarios.add(usuario2);
	 * 
	 * 
	 * return new ResponseEntity(usuarios,HttpStatus.OK);
	 * 
	 * }
	 */

}
