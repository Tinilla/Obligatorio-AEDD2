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
public class TablaDCD<T extends Comparable<T>>{
    CeldaDCD<T>[] tablaHash; // extends ICelda
    int tamanio;
    int r;
    int contador;

    public int getTamanio() {
        return tamanio;
    }

    public int getContador() {
        return contador;
    }

    public TablaDCD(int tamanio) {
        r = primoMenor(tamanio);
        tamanio = primoMayor(tamanio);
        crear();
    }
    
    private void crear(){
        //r - primo menor
        //t - primo mayor
        tablaHash = new CeldaDCD[tamanio];
        for(int i = 0; i< tamanio; i++){
            tablaHash[i] = new CeldaDCD(0, CeldaDCD.Estado.Vacio);
        }
    }
    
    private int h(int clave){
        return clave % tamanio;
    }
    
    private int h2(int clave){
        return r -((clave % r));
    }
    
    public void insertar(T dato){
        int posicion = h(dato.hashCode());
        int count = 1;
        while(tablaHash[posicion].getEstado() == CeldaDCD.Estado.Ocupado){
            posicion = count * h2(dato.hashCode());
            count ++;
        }
        tablaHash[posicion].setDato(dato);
    }
    
    public boolean contiene(T dato){
        int posicion = h(dato.hashCode());
        int i = 1;
        while(tablaHash[posicion].getEstado() == CeldaDCD.Estado.Eliminado || tablaHash[posicion].getEstado() == CeldaDCD.Estado.Ocupado){
            if(tablaHash[posicion].getDato().compareTo(dato) == 0){
                return true;
            }
            posicion = (h(dato.hashCode()) + i * h2(dato.hashCode(), i)) % tamanio;
            i++;
        }
        return false;
    }
    
    public void remover(T dato){
        int posicion = h(dato.hashCode());
    }
    
    public void print(){

    }
    
    private boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
    
    private int primoMayor(int numero){
        int actual = numero;
        for(int i = numero; esPrimo(i); i++){
            actual = i;
        }
        return actual;
    }
    
    private int primoMenor(int numero){
        int actual = numero;
        for(int i = numero; esPrimo(i); i++){
            actual = i;
        }
        return actual;
    }
}
