/**
 *  For using IUCalendarChooser without using java.util.Observer
 */
package auxiliares.seleccionarFecha;

/**
 * @author Rodrigo Santellán Wibmer
 *
 */
public interface ObservadoCalendario {

	public void agregarObsevador(ObservadorCalendario ob);
	
	public void notificarCambios();
	
}
