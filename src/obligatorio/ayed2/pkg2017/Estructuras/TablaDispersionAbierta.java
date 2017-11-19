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
public class TablaDispersionAbierta<T extends Comparable<T>>{
    Lista<T>[] tablaHash;
    int tamanio;
    int conteo;

    public TablaDispersionAbierta(int tamanio) {
        this.tamanio = primoMayor(tamanio);
        tablaHash = new Lista[tamanio];
        crear();
        conteo = 0;
    }
    
    private int h(int key){
        return key % tamanio;
    }
    
    private void crear(){
        if(tablaHash == null){
            for(int i = 0; i<tamanio; i++){
                tablaHash[i] = new Lista();
            }
        }
    }
    
    public void insert(T dato){
        int posicion = h(dato.hashCode());
        if (tablaHash[posicion] == null){
            tablaHash[posicion] = new Lista();
        }
        tablaHash[posicion].agregar(dato);
    }
    
    public boolean contiene(T dato){
        int position = h(dato.hashCode());
        if(tablaHash[position] != null){
            return tablaHash[position].contiene(dato);
        }
        return false;
    }
    
    public void remover(T dato){
        int posicion = h(dato.hashCode());
        tablaHash[posicion].removerItem(dato);
    }
    
    public void imprimir(){
        for(int i = 0; i<tamanio; i++){
            System.out.println("posicion " + i + ": ");
            if(tablaHash[i] != null){
               tablaHash[i].imprimir();
            }
        }
    }
    
    public T obtener(T dato){
        
        return dato;
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
    
    /*private int primoMenor(int numero){
        int actual = numero;
        for(int i = numero; esPrimo(i); i++){
            actual = i;
        }
        return actual;
    }*/
}
