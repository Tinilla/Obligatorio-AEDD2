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
public interface ICola<T extends Comparable<T>>{
    
    public void encolar(T dato);
    public T desencolar();
    public T principio();
    public boolean estaVacio();
    
}
