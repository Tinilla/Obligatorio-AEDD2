/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Estructuras;
import obligatorio.ayed2.pkg2017.Dominio.Comentario;
/**
 *
 * @author Equipo
 */
public class Pila<Comentario extends Comparable<Comentario>> implements IPila<Comentario> {
    
    Nodo<Comentario> tope;
    int contador;
    
    public int Contador()
    {
        return contador;
    }
    
    @Override 
    public void apilar(Comentario dato){
        Nodo<Comentario> viejoTope = tope;
        tope = new Nodo(dato);
        tope.setSiguiente(viejoTope);
        contador++;
    }
    
    
    @Override
    public Comentario desapilar(){
        Comentario dato = tope.getDato();
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
                Comentario dato = desapilar();
                System.out.println(dato);
                apilar(dato);
            }
            else{
                Comentario dato = desapilar();
                System.out.println(dato);
                imprimir();
                apilar(dato);
            }
        }
    }
    
    private void imprimit(int cuenta){
        
    }
    
    @Override
    public Comentario ultimo(){
        return tope.getDato();
    }
    
    public Pila(){
        tope = null;
        contador= 0;
    }    
}
