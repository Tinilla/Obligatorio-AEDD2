/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Estructuras;

import java.util.Iterator;

/**
 *
 * @author Equipo
 */
public class Lista <T extends Comparable <T>> implements IListaDoble<T>/*, Iterable<T>*/{
    
    NodoDoble<T> inicio;
    int contador;
    
    public int Contador()
    {
        return contador;
    }
    
    @Override
    public void agregar(T n)
    {
        NodoDoble<T> nodo = new NodoDoble<T> (n);
        if(estaVacio()){
            nodo.setSiguiente(null);
            nodo.setAnterior(null);
            inicio = nodo;
        }
        else{
            nodo.setSiguiente(null);
            nodo.setAnterior(inicio);
            inicio.setSiguiente(nodo);
            inicio = nodo;
        }
        contador++;
    }
    
    public void agregarInicio(T n){
        NodoDoble<T> nodo = new NodoDoble<T> (n);
        if(estaVacio()){
            nodo.setSiguiente(null);
            nodo.setAnterior(null);
            inicio = nodo;
        }
        else{
            nodo.setSiguiente(inicio);
            nodo.setAnterior(null);
            inicio = nodo;
        }
        contador++;
    }
    
    public T obtenerElemento(T n){
        NodoDoble<T> actual = inicio;
        while(actual != null){
            if(actual.getDato().compareTo(n) ==0){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    @Override 
    public boolean estaVacio(){
        return inicio == null;
    }
    
    @Override
    public void imprimir(){
        NodoDoble<T> actual = inicio;
        int contador = 1;
        while(actual != null){
            System.out.println(contador++ + " - " + actual.getDato());
            actual = actual.getSiguiente();
        }
    }
    
    @Override
    public void vacia(){
        while(!estaVacio()){
            eliminar();
        }
        contador = 0;
    }
    
    @Override
    public void eliminar(){
        if(contador > 0){
            inicio = inicio.getSiguiente();
            if(inicio != null){
                inicio.setAnterior(null);
            }
            contador--;
        }
    }
    
    public void removerItem(T item){
        NodoDoble<T> actual = inicio;
        while(actual !=null){
            if(actual.getDato().compareTo(item) == 0){
                if(actual.getAnterior() == null && actual.getSiguiente() == null){
                    inicio = null;
                }
                else{
                    if(actual.getAnterior() == null){
                        actual.getSiguiente().setAnterior(null);
                        inicio = actual.getSiguiente();
                    }
                    else{
                        if(actual.getSiguiente() == null){
                            actual.getAnterior().setSiguiente(null);
                        }
                        else{
                            actual.getAnterior().setSiguiente(actual.getSiguiente());
                            actual.getSiguiente().setAnterior(actual.getAnterior());
                        }
                    }
                }
            }
            actual = actual.getSiguiente();
        }
    }
    
    public Lista<T> cola(){
        Lista<T> cola = new Lista<T>();
        NodoDoble<T> actual = inicio.getSiguiente();
        while(actual != null){
            cola.agregar(actual.getDato());
            actual= actual.getSiguiente();
        }
        return cola;
    }
    
    public NodoDoble<T> cabeza(){
        return inicio;
    }
    
    public boolean contiene(T n){
        Lista<T> lista = new Lista<T> ();
        NodoDoble<T> actual = inicio;
        while(actual != null){
            if(actual.getDato().compareTo(n) == 0){
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    public Lista(){
        inicio = null;
        contador= 0;
    }
    
    /*public class Iterador<T> implements Iterator<T> {
    private Nodo<T> actual = Lista.this.getRaiz();
    @Override
    public boolean hasNext() {
        return actual < Lista.this.contador;
    }

    @Override
    public T next() {
        if(hasNext()){
            return 
        }
    }   
}*/

}
