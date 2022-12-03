package cl.sistema.framework.vo;

import java.util.List;

public class ResponsePremisosVO {

	private String idUsuario;
	private String nombreRol;
	private int idRol;
	private String nombreEmpresa;
	private int idEmpresa;
	private List<ModuloVO> modulo;
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public List<ModuloVO> getModulo() {
		return modulo;
	}
	public void setModulo(List<ModuloVO> modulo) {
		this.modulo = modulo;
	}
	@Override
	public String toString() {
		return "ResponsePremisosVO [idUsuario=" + idUsuario + ", nombreRol=" + nombreRol + ", idRol=" + idRol
				+ ", nombreEmpresa=" + nombreEmpresa + ", idEmpresa=" + idEmpresa + ", modulo=" + modulo + "]";
	}
	
	
}
