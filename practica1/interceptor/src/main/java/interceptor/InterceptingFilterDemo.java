package interceptor;

public class InterceptingFilterDemo {
	
	public static GestorFiltros gestorFiltros;
	public static Cliente cliente;

	
	public static void main(String[] args) {
		gestorFiltros = new GestorFiltros(new Interfaz());
		gestorFiltros.setFiltro(new CalcularVelocidad());

		cliente = new Cliente();
		cliente.setGestorFiltros(gestorFiltros);
		//cliente.enviarPeticion("HOME");
	}
}