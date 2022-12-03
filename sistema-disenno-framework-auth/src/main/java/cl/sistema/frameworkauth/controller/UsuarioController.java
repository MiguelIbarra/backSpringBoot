package cl.sistema.frameworkauth.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import cl.sistema.frameworkauth.service.IUsuarioService;
import cl.sistema.frameworkauth.vo.ResponseSuccessVO;

import cl.sistema.frameworkauth.vo.UsuarioResponseVO;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@CrossOrigin(origins ="http://localhost:4200") 
@RequestMapping("/v1/usuarioauth")
public class UsuarioController {

	@Autowired
	IUsuarioService iUsuarioService;
	
	@GetMapping("/usuario/{usuario}/password/{password}/empresa/{empresa}") 
	public  ResponseEntity<ResponseSuccessVO<UsuarioResponseVO>> login(@PathVariable("usuario") String usuario, 
			@PathVariable("password") String password, @PathVariable("empresa") int empresa)  throws Exception {
		
		
		ResponseSuccessVO<UsuarioResponseVO> response = iUsuarioService.login(usuario, password, empresa);			
		return  ResponseEntity.ok(response);	
		
	}
	
	
}
