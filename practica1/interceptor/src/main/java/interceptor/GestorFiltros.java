package interceptor;

public class GestorFiltros {

	private CadenaFiltros cadenaFiltros;

	public GestorFiltros(Interfaz objetivo){
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setObjetivo(objetivo);
	}
	
	public void setFiltro(Filtro filtro){
		cadenaFiltros.addFiltro(filtro);
	}

	public void filterRequest(String request){
		cadenaFiltros.ejecutar(request);
	}
}
