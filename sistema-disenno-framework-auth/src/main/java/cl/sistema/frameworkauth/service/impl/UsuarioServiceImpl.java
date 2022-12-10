package cl.sistema.frameworkauth.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import cl.sistema.frameworkauth.repository.UsuarioRepository;
import cl.sistema.frameworkauth.service.IUsuarioService;
import cl.sistema.frameworkauth.vo.ResponseSuccessVO;
import cl.sistema.frameworkauth.vo.UsuarioResponseVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired 
	UsuarioRepository usuarioRepository;
	
	@Override
	public ResponseSuccessVO<UsuarioResponseVO> login(String usuario, String password, int empresa) throws Exception {
		
		ResponseSuccessVO<UsuarioResponseVO> response= new  ResponseSuccessVO<UsuarioResponseVO>();
		
		UsuarioResponseVO usuResponse = new UsuarioResponseVO();
		
		Map<String, Object> result = usuarioRepository.login(usuario, password, empresa);
		int codSalida = (int) result.get("CodSalida");
		String mnsSalida  = result.get("MsnSalida").toString();
		
		
		System.out.println("Salida  Imple: "+codSalida + " " +mnsSalida);
		response.setCodigoRetorno(codSalida);
		response.setGlosaRetorno(mnsSalida);
		Map<String, Object> clain = new HashMap<>();
		
		if(response.getCodigoRetorno() == 0) {			
			usuResponse.setIdEmpresa(empresa);
			usuResponse.setUsuario(usuario);
			usuResponse.setNombreEmpresa(result.get("Empresa").toString());
			clain.put("idUsuario", usuario);
			clain.put("idempresa", empresa);
			clain.put("nobreEmpresa", result.get("Empresa").toString());
			usuResponse.setToken(getJWTToken(clain));		
			response.setResultado(usuResponse);
		}else {
			response.setResultado(null);
		}		
	
		
		return response;
	}

	
	
	private String getJWTToken(Map<String, Object> clain ) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT").setClaims(clain)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
