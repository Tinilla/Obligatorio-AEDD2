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
public class NodoDoble <T extends Comparable <T>>{
    
    private T dato;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;
    
    public T getDato()
    {
        return dato;
    }
    
    public void setDato(T dato)
    {
        this.dato = dato;
    }
    
    public NodoDoble<T> getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(NodoDoble<T> siguiente){
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior(){
        return anterior;
    }
    
    public void setAnterior(NodoDoble<T> anterior){
        this.anterior = anterior;
    }
    
    public NodoDoble(T dato)
    {
        this.dato = dato;
        siguiente = null;
        anterior = null;
    }
}
