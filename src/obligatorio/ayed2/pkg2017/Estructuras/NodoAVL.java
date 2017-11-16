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
public class NodoAVL<T extends Comparable<T>> {
    private T dato;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura;

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public NodoAVL(T dato){
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 0;
    }
    
    public NodoAVL(T dato, NodoAVL izquierdo, NodoAVL derecho){
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.altura = 0;
    }
    
}
