package interceptor;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean (name="cliente", eager=true )
@RequestScoped
public class Cliente {
	
	private GestorFiltros gestorFiltros;
	public static final String BOTON_UNO = "1";
	public static final String BOTON_DOS = "2";
	
	public Cliente() {
		System.out.println("creating cliente");
		gestorFiltros = new GestorFiltros(new Interfaz());
		gestorFiltros.setFiltro(new CalcularVelocidad());
		}

	public void setGestorFiltros(GestorFiltros gestorFiltros){ 	this.gestorFiltros = gestorFiltros; }
		
	public void enviarPeticion(String request) {
		gestorFiltros.filterRequest(request);
	}
			
}
