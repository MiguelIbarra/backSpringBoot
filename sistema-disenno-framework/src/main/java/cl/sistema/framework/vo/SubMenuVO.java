package cl.sistema.framework.vo;

public class SubMenuVO {
	
	private String nombreSubMenu;
	private int idSubMenu;
	private String recursoSubMenu;
	
	
	public String getNombreSubMenu() {
		return nombreSubMenu;
	}
	public void setNombreSubMenu(String nombreSubMenu) {
		this.nombreSubMenu = nombreSubMenu;
	}
	public int getIdSubMenu() {
		return idSubMenu;
	}
	public void setIdSubMenu(int idSubMenu) {
		this.idSubMenu = idSubMenu;
	}
	public String getRecursoSubMenu() {
		return recursoSubMenu;
	}
	public void setRecursoSubMenu(String recursoSubMenu) {
		this.recursoSubMenu = recursoSubMenu;
	}
	@Override
	public String toString() {
		return "SubMenuVO [nombreSubMenu=" + nombreSubMenu + ", idSubMenu=" + idSubMenu + ", recursoSubMenu="
				+ recursoSubMenu + "]";
	}
	
	

}
