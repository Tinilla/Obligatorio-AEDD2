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
public class Pila<T extends Comparable<T>> implements IPila<T> {
    
    Nodo<T> tope;
    int contador;
    
    public int Contador()
    {
        return contador;
    }
    
    @Override 
    public void apilar(T dato){
        Nodo<T> viejoTope = tope;
        tope = new Nodo(dato);
        tope.setSiguiente(viejoTope);
        contador++;
    }
    
    
    @Override
    public T desapilar(){
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        contador--;
        return dato;
    }

    @Override
    public boolean estaVacio() {
        return tope == null;
    }

    @Override
    public void imprimir() {
        if(!estaVacio())
        {
            if(contador == 1){
                T dato = desapilar();
                System.out.println(dato);
                apilar(dato);
            }
            else{
                T dato = desapilar();
                System.out.println(dato);
                imprimir();
                apilar(dato);
            }
        }
    }
    
    @Override
    public T ultimo(){
        return tope.getDato();
    }
    
    public Pila(){
        tope = null;
        contador= 0;
    }
    
    
    
    
    
}
