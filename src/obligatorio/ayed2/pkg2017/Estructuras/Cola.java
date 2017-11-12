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
public class Cola <T extends Comparable<T>> implements ICola<T> {
    
    Nodo<T> principio;
    Nodo<T> finalizacion;
    int contador;
    
    public int Contador(){
        return contador;
    }
    
    @Override
    public void encolar(T n){
        Nodo<T> nodoNuevo = new Nodo<T>(n);
        if(contador == 0){
            principio = nodoNuevo;
            finalizacion = nodoNuevo;
        }
        else { 
            if(contador == 1)
            {
                principio.setSiguiente(nodoNuevo);
                finalizacion = nodoNuevo;
            }
            else{
                finalizacion.setSiguiente(nodoNuevo);
                finalizacion = nodoNuevo;
            }
        }
        contador++;
    }
    
    @Override
    public T desencolar(){
        T viejoPrimerDato = principio.getDato();
        if(principio.getSiguiente() != null){
            principio = principio.getSiguiente();
        }
        else{
            if(contador == 2){
                principio = principio.getSiguiente();
                finalizacion = principio;
            }
            else{
                principio = null;
                finalizacion = null;
            }
        }
        contador--;
        return viejoPrimerDato;
    }
    
    @Override 
    public T principio(){
        if(principio != null){
            return principio.getDato();
        }
        return null;
    }
    
    @Override
    public boolean estaVacio(){
        return principio == null;
    }
     
    public void imprimir(){
        if(!estaVacio()){
            imprimir(new Cola<T>());
        }
    }
    
    public void imprimir(Cola<T> aux){
        if(contador == 1){
            T dato = desencolar();
            System.out.println(dato);
            aux.encolar(dato);
            encolar(aux.desencolar());
        }
        else{
            T dato = desencolar();
            System.out.println(dato);
            aux.encolar(dato);
            imprimir(aux);
            encolar(aux.desencolar());
        }
    }
    
    public Cola(){
        principio = null;
        finalizacion = null;
        contador =0;
    }
}
