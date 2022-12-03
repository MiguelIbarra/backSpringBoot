package cl.sistema.framework.repository;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class FrameworkRepository {
	
	
	
	@Autowired
	DataSource datasource;
	
	
	
	public Map<String, Object> obtenerPermisosUsuRepo(String usuario, int empresa) throws Exception  {
		
		Map<String, Object> result = null;
		try {
			SimpleJdbcCall getSqlCall = new SimpleJdbcCall(datasource).withSchemaName("dbo").withProcedureName("PermisosUsuario")
					.declareParameters(new SqlParameter("Usuario", Types.VARCHAR,"Usuario"),		
							new SqlParameter("IdEmpresa", Types.INTEGER,"IdEmpresa"));

			result = getSqlCall.execute(usuario, empresa); 
			
			System.out.println("Resultado: "+result);
			
		}catch (Exception e) {
			throw e;
		}
		
		
	
		return result;
	}
	
	

}
