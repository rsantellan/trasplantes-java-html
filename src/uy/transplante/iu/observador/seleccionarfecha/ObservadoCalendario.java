/**
 *  For using IUCalendarChooser without using java.util.Observer
 */
package uy.transplante.iu.observador.seleccionarfecha;

/**
 * @author Rodrigo Santellán Wibmer
 *
 */
public interface ObservadoCalendario {

	public void agregarObsevador(ObservadorCalendario observer);
	
	public void notificarCambios();
	
}
