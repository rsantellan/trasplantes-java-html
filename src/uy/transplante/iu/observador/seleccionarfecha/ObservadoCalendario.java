/**
 *  For using IUCalendarChooser without using java.util.Observer
 */
package uy.transplante.iu.observador.seleccionarFecha;

/**
 * @author Rodrigo Santell�n Wibmer
 *
 */
public interface ObservadoCalendario {

	public void agregarObsevador(ObservadorCalendario ob);
	
	public void notificarCambios();
	
}
