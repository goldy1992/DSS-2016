package interceptor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalcularVelocidad implements Filtro {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double velocidad = 0;
	
	public double ejecutar(String request) {
		if (request.equals(MbModel.APAGAR)) { velocidad = 0;}
		if (request.equals(MbModel.ENCENDER)) { velocidad = 200;}
		if (request.equals(MbModel.ACELERAR)) { velocidad += 200;}
		return velocidad;
	}


}
