package cl.sistema.frameworkauth.repository;



import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

	 
	@Autowired
	DataSource datasource;
	
	
	
	public Map<String, Object> login(String usuario, String password, int empresa) throws Exception  {
		
		Map<String, Object> result = null;
		try {
			SimpleJdbcCall getSqlCall = new SimpleJdbcCall(datasource).withSchemaName("dbo").withProcedureName("AutenticaUsuario")
					.declareParameters(new SqlParameter("Usuario", Types.VARCHAR,"Usuario"),	
							new SqlParameter("Password", Types.VARCHAR,"Password"),
							new SqlParameter("IdEmpresa", Types.INTEGER,"IdEmpresa"),
							new SqlOutParameter ("CodSalida", Types.INTEGER, "CodSalida"),
							new SqlOutParameter ("MsnSalida", Types.VARCHAR, "MsnSalida"),
							new SqlOutParameter ("Empresa", Types.VARCHAR, "Empresa")
							);

			result = getSqlCall.execute(usuario, password, empresa,0, "", ""); 
			
			System.out.println("Resultado Autenticar: "+result);
			
		}catch (Exception e) {
			throw e;
		}
		
		
	
		return result;
	}
}
