
/**
 * A interface sensor permite definir o método read que será implementado em todas
 * as classes que implementam esta mesma interface
 * 
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 17/05/2024
 */

public interface Sensor
{
    /**
     * Método geral que será implementado nas classes descendentes com as suas
     * funcionalidades especificas.
     * Este método deverá ler algo definido por cada classe
     */
    void read();
}
