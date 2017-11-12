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
public class ListaDoble <T extends Comparable <T>> implements IListaDoble<T> {
    
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
            nodo.setSiguiente(inicio);
            nodo.setAnterior(null);
            inicio.setSiguiente(nodo);
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
        while(actual != null){
            System.out.println(actual.getDato());
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
    
    public ListaDoble<T> cola(){
        ListaDoble<T> cola = new ListaDoble<T>();
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
        ListaDoble<T> lista = new ListaDoble<T> ();
        NodoDoble<T> actual = inicio;
        while(actual != null){
            if(actual.getDato().compareTo(n) == 0){
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    public ListaDoble(){
        inicio = null;
        contador= 0;
    }
}
