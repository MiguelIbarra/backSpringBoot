package cl.sistema.framework.vo;

import java.util.List;

public class MenuVO {
	
	private String nombreMenu;
	private int idMenu;
	private String recursoMenu;
	private List<SubMenuVO> subMenu;
	
	public String getNombreMenu() {
		return nombreMenu;
	}
	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
	
	public String getRecursoMenu() {
		return recursoMenu;
	}
	public void setRecursoMenu(String recursoMenu) {
		this.recursoMenu = recursoMenu;
	}
	public List<SubMenuVO> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<SubMenuVO> subMenu) {
		this.subMenu = subMenu;
	}
	@Override
	public String toString() {
		return "MenuVO [nombreMenu=" + nombreMenu + ", idMenu=" + idMenu + ", recursoMenu=" + recursoMenu + ", subMenu="
				+ subMenu + "]";
	}
	
	
	
		
	

	
}
