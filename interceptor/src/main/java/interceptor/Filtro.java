package interceptor;

import java.io.Serializable;

public interface Filtro extends Serializable {
	public double ejecutar(String request);
}
