package cl.sistema.frameworkauth.service;

import cl.sistema.frameworkauth.vo.ResponseSuccessVO;
import cl.sistema.frameworkauth.vo.UsuarioResponseVO;

public interface IUsuarioService {

	public ResponseSuccessVO<UsuarioResponseVO> login ( String usuario, String password, int empresa)  throws Exception ;
}
