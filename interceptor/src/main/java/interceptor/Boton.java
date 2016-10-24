package interceptor;

public class Boton {
	private String texto;
	private String color;
	
	public Boton(String texto, String color) {
		this.setTexto(texto);
		this.setColor(color);
	}

	public String getTexto() {	return texto; }
	public void setTexto(String texto) { this.texto = texto; }
	public String getColor() {	return color; }
	public void setColor(String color) { this.color = color;	}

}
