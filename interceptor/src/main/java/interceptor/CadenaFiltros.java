package interceptor;

import java.util.ArrayList;
import java.util.List;

public class CadenaFiltros {
	private List<Filtro> filtros = new ArrayList<Filtro>(); //declarar:filtrosesunArrayListgenericodeelementosFiltro
	private Interfaz objetivo;
	
	public void addFiltro(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public void ejecutar(String peticion){
		double velocidad = 0;
		for(Filtro filtro : filtros) {
			velocidad = filtro.ejecutar(peticion);
			System.out.println("Nuevavelocidad(m/s)" + velocidad);
		}
		objetivo.ejecutar(velocidad);
	}
	public void setObjetivo(Interfaz objetivo){
		this.objetivo = objetivo;
	}
}