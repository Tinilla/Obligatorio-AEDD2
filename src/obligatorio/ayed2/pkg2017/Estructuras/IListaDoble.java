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
public interface IListaDoble<T extends Comparable<T>> {
    
    public void agregar(T n);
    public boolean estaVacio();
    public void imprimir();
    public void vacia();
    public void eliminar();
    
}
