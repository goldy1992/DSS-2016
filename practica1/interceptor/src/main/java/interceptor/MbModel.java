package interceptor;

import java.awt.Color;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean (name="mbModel", eager=true )
@SessionScoped
public class MbModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String APAGADO = "apagado";
	public static final String APAGAR = "apagar";
	public static final String ENCENDER = "encender";
	public static final String ACELERAR = "acelerar";
	public static final String ACELERANDO = "acelerando";
	
	public static final String RED = "red";
	public static final String BLUE = "blue";
	
	private String estado = APAGADO;	
	private Boton botonUno = new Boton(ENCENDER, Color.RED.toString());
	private Boton botonDos = new Boton(ACELERAR, Color.BLACK.toString());
	
	public MbModel() {
		InterceptingFilterDemo.main(new String[0]);
	}
	
	public void botonEncender(ActionEvent e) {
		if (estado.equals(APAGADO)) {
			setEstado(ACELERANDO);
			botonUno.setTexto(APAGAR);
			botonUno.setColor(BLUE);
			InterceptingFilterDemo.cliente.enviarPeticion(ENCENDER);
		} else {
			setEstado(APAGADO);
			botonUno.setTexto(ENCENDER);
			botonUno.setColor(RED);
			InterceptingFilterDemo.cliente.enviarPeticion(APAGAR);
		}
	}
	
	public void botonAcelerar(ActionEvent e) {
		if (estado.equals(APAGADO)) {
			setEstado(ACELERANDO);
			botonUno.setTexto(APAGAR);
			botonUno.setColor(BLUE);
		} 
		InterceptingFilterDemo.cliente.enviarPeticion(ACELERAR);
	}
	
	public void setEstado(String estado) {	this.estado = estado;	}
	public String getEstado() { return estado;	}
	
	public void setBotonUno(Boton botonUno) {	this.botonUno = botonUno;	}
	public Boton getBotonUno() { return botonUno;	}
	
	public void setBotonDos(Boton botonDos) {	this.botonDos = botonDos;	}
	public Boton getBotonDos() { return botonDos;	}


	
}
