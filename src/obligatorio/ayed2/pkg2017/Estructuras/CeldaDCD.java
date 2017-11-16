/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Estructuras;

/**
 *
 * @author Equipo
 */
public class CeldaDCD<T extends Comparable<T>> {
    private T dato;
    private Estado estado;

    enum Estado{
        Vacio,
        Ocupado,
        Eliminado
    }
        
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setState(Estado estado) {
        this.estado = estado;
    }

    public CeldaDCD(T dato, Estado estado) {
        this.dato = dato;
        this.estado = estado;
    }
    
}
