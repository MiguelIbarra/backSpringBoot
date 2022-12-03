package cl.sistema.framework.vo;

/**
 * Modelo Error
 * 
 *
 */
public class ResponseErrorVO {

	private String error;
	private int code;
	private String uriRequest;
	
	public ResponseErrorVO(String error, int code, String uriRequest) {
		super();
		this.error = error;
		this.code = code;
		this.uriRequest = uriRequest;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getUriRequest() {
		return uriRequest;
	}

	public void setUriRequest(String uriRequest) {
		this.uriRequest = uriRequest;
	}

	@Override
	public String toString() {
		return "ResponseErrorVO [error=" + error + ", code=" + code + ", uriRequest=" + uriRequest + "]";
	}


	
}
