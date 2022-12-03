package cl.sistema.frameworkauth.vo;

public class UsuarioResponseVO {
	
	private String usuario;	
	private int idEmpresa;
	private String nombreEmpresa;
	private String token;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "UsuarioResponseVO [usuario=" + usuario + ", idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa
				+ ", token=" + token + "]";
	}
	
	
	
	

}
