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
public interface IPila <T extends Comparable<T>>{
    
    public void apilar(T dato);
    public T desapilar();
    public boolean estaVacio();
    public void imprimir();
    public T ultimo();
    
}
