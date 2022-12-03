package cl.sistema.framework.vo;





import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Response Success
 * @author Miguel Ibarra
 *
 */
@Component
public class ResponseSuccessVO<E>{
	
	private int codigoRetorno;
	private String glosaRetorno;	
	private E resultado;
	public int getCodigoRetorno() {
		return codigoRetorno;
	}
	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
	public String getGlosaRetorno() {
		return glosaRetorno;
	}
	public void setGlosaRetorno(String glosaRetorno) {
		this.glosaRetorno = glosaRetorno;
	}
	public E getResultado() {
		return resultado;
	}
	public void setResultado(E resultado) {
		this.resultado = resultado;
	}
	
	
	
	

}
	
	