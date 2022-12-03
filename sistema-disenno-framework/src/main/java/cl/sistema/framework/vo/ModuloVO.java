package cl.sistema.framework.vo;

import java.util.List;

public class ModuloVO {

	
	private String nombreModulo;
	private int idModulo;
	private List<MenuVO> menu;
	
	public String getNombreModulo() {
		return nombreModulo;
	}
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
	public int getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
	public List<MenuVO> getMenu() {
		return menu;
	}
	public void setMenu(List<MenuVO> menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "ModuloVO [nombreModulo=" + nombreModulo + ", idModulo=" + idModulo + ", menu=" + menu + "]";
	}
	
	
}
