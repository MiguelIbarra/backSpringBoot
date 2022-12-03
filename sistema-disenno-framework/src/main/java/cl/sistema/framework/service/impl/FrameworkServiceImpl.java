package cl.sistema.framework.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sistema.framework.repository.FrameworkRepository;
import cl.sistema.framework.service.IFrameworkService;
import cl.sistema.framework.vo.MenuVO;
import cl.sistema.framework.vo.ModuloVO;
import cl.sistema.framework.vo.ResponsePremisosVO;
import cl.sistema.framework.vo.ResponseSuccessVO;
import cl.sistema.framework.vo.SubMenuVO;

@Service
public class FrameworkServiceImpl implements IFrameworkService {

	
	@Autowired
	FrameworkRepository frameworkRepository;
	
	@Override
	public ResponseSuccessVO<ResponsePremisosVO> obtenerPermisosUsu(String usuario, int empresa) throws Exception {
		 
		
		ResponseSuccessVO<ResponsePremisosVO> response = new ResponseSuccessVO<ResponsePremisosVO>();
		Map<String, Object> result = frameworkRepository.obtenerPermisosUsuRepo(usuario, empresa);					
		ArrayList arrayPermisos = (ArrayList) result.get("#result-set-1");

		System.out.println("lista Completa: "+ arrayPermisos.size());		
		ResponsePremisosVO repsponPremisoVO = new ResponsePremisosVO();
		
			if ( arrayPermisos.size() > 0 ) {	
			
				List<ModuloVO> listaModulo = new ArrayList<ModuloVO>();
				
				int auxModulo = 0;
				int auxMenu = 0;
				int auxSubMenu = 0;
				
				for(int i = 0; i < arrayPermisos.size(); i++) {				
					Map<String, Object>  permiso = (Map<String, Object>) arrayPermisos.get(i);		
					
					repsponPremisoVO.setIdUsuario(permiso.get("id_usuario").toString());
					repsponPremisoVO.setNombreRol(permiso.get("nombre_rol").toString()); 
					repsponPremisoVO.setIdRol((int) permiso.get("id_rol"));
					repsponPremisoVO.setNombreEmpresa(permiso.get("nombre_empresa").toString());
					repsponPremisoVO.setIdEmpresa((int) permiso.get("id_empresa"));
					
					if(auxModulo != ((int)permiso.get("id_modulo")))
					{
						auxModulo = (int) permiso.get("id_modulo");
						ModuloVO modulo = new ModuloVO();
						modulo.setIdModulo((int) permiso.get("id_modulo"));
						modulo.setNombreModulo(permiso.get("nombre_modulo").toString());						
						
						List<MenuVO> listaMenu = new ArrayList<MenuVO>();
						for(int j = 0; j < arrayPermisos.size(); j++) {								
							Map<String, Object>  permisoMenu = (Map<String, Object>) arrayPermisos.get(j);						
							if(auxMenu != (int)permisoMenu.get("id_menu") && (int)permisoMenu.get("id_modulo") == (int)permiso.get("id_modulo"))
							{						
								auxMenu = (int) permisoMenu.get("id_menu");
								MenuVO menu = new MenuVO();					
								menu.setIdMenu((int) permisoMenu.get("id_menu"));
								menu.setNombreMenu(permisoMenu.get("nombre_menu").toString());	
								menu.setRecursoMenu(permisoMenu.get("recurso_menu").toString());	
								List<SubMenuVO> listaSubMenu = new ArrayList<SubMenuVO>();
								for(int l = 0; l < arrayPermisos.size(); l++) {								
									Map<String, Object>  permisoSubMenu = (Map<String, Object>) arrayPermisos.get(l);	
									
									if(auxSubMenu != (int)permisoSubMenu.get("id_submenu") && (int)permisoSubMenu.get("id_menu") == (int)permisoMenu.get("id_menu") )
									{						
										auxSubMenu = (int) permisoSubMenu.get("id_submenu");
										SubMenuVO subMenu = new SubMenuVO();					
										subMenu.setIdSubMenu((int) permisoSubMenu.get("id_submenu"));
										subMenu.setNombreSubMenu(permisoSubMenu.get("nombre_submenu").toString());	
										subMenu.setRecursoSubMenu(permisoSubMenu.get("recurso_submenu").toString());
										listaSubMenu.add(subMenu);						
										menu.setSubMenu(listaSubMenu);
									}							
								}						
								
								listaMenu.add(menu);						
								modulo.setMenu(listaMenu);
							}					
						}						
						listaModulo.add(modulo);
					}				
				}
				
				System.out.println("Lista modulo: "+ listaModulo);	
				repsponPremisoVO.setModulo(listaModulo);
				
				response.setCodigoRetorno(0);
				response.setGlosaRetorno("OK");
				response.setResultado(repsponPremisoVO);
		}else {
			response.setCodigoRetorno(1);
			response.setGlosaRetorno("Usuario sin permisos");
			response.setResultado(null);
		}
		return response;
	}

}
