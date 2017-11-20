/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Estructuras;

import obligatorio.ayed2.pkg2017.Dominio.Hotel;

/**
 *
 * @author Equipo
 */
public class ArbolAVL2<T extends Comparable<Hotel>> {
    private NodoAVL<Hotel> raiz;
    
    public void insertar(Hotel dato){
        raiz = insertar(dato, raiz);
    }
    
    private NodoAVL<Hotel> insertar(Hotel dato, NodoAVL<Hotel> nodo){
        if(nodo == null){
            return new NodoAVL(dato);
        }else if(dato.compareTo(nodo.getDato()) < 0){
            nodo.setIzquierdo(insertar(dato, nodo.getIzquierdo()));
            if(altura(nodo.getIzquierdo()) - altura(nodo.getDerecho()) == 2){
                if(nodo.getIzquierdo().getDato().compareTo(dato) > 0){
                    return rotacionHijoIzquierdo(nodo);
                } else{
                    return rotacionDobleHijoIzquierdo(nodo);
                }
            }
        }else /*if(dato.compareTo(nodo.getDato()) > 0)*/{
            nodo.setDerecho(insertar(dato, nodo.getDerecho()));
            if(altura(nodo.getDerecho()) - altura(nodo.getIzquierdo()) == 2){
                if(nodo.getDerecho().getDato().compareTo(dato) < 0){
                    return rotacionHijoDerecho(nodo);
                }else{
                    return rotacionDobleHijoDerecho(nodo);
                }
            }
        }
        return nodo;
        //return null;
    }
    
    private int max(int alturaIzquierda, int alturaDerecha){
        return alturaIzquierda > alturaDerecha ? alturaIzquierda : alturaDerecha;
    }
    
    private NodoAVL<Hotel> rotacionHijoIzquierdo(NodoAVL<Hotel> nodo){
        NodoAVL<Hotel> aux = nodo.getIzquierdo();
        nodo.setIzquierdo(aux.getDerecho());
        aux.setDerecho(nodo);
        nodo.setAltura(max(altura(aux.getIzquierdo()), nodo.getAltura()) + 1);
        aux.setAltura(max(altura(aux.getIzquierdo()), nodo.getAltura()) + 1);
        return aux;
    }
    
    private NodoAVL<Hotel> rotacionHijoDerecho(NodoAVL<Hotel> nodo){
        NodoAVL<Hotel> aux = nodo.getDerecho();
        nodo.setDerecho(aux.getIzquierdo());
        aux.setIzquierdo(nodo);
        nodo.setAltura(max(altura(aux.getDerecho()), nodo.getAltura()) + 1);
        aux.setAltura(max(altura(aux.getDerecho()), nodo.getAltura()));
        return aux;
    }
    
    private NodoAVL<Hotel> rotacionDobleHijoIzquierdo(NodoAVL<Hotel> nodo){
        nodo.setIzquierdo(rotacionHijoDerecho(nodo.getIzquierdo()));
        return rotacionHijoDerecho(nodo);
    }
    
    private NodoAVL<Hotel> rotacionDobleHijoDerecho(NodoAVL<Hotel> nodo){
        nodo.setDerecho(rotacionHijoIzquierdo(nodo.getDerecho()));
        return rotacionHijoDerecho(nodo);
    }
    
    private int altura(NodoAVL<Hotel> nodo){
        return nodo == null ? -1 : nodo.getAltura();
    }
    
    public void imprimirAscendente(){
        imprimirAscendente(raiz);
    }
    
    private void imprimirAscendente(NodoAVL<Hotel> nodo){
        if(nodo != null){
            imprimirAscendente(nodo.getIzquierdo());
            System.out.println(nodo.getDato().toString2);
            imprimirAscendente(nodo.getDerecho());
        }
    }
    
    public void imprimirDescendente(){
        imprimirDescendente(raiz);
    }
    
    private void imprimirDescendente(NodoAVL<Hotel> nodo){
        if(nodo != null){
            imprimirDescendente(nodo.getDerecho());
            System.out.println(nodo.getDato());
            imprimirDescendente(nodo.getIzquierdo());
        }
    }
    
    public int alturaArbol(){
        return alturaArbol(raiz);
    }
    
    private int alturaArbol(NodoAVL<Hotel> nodo){
        if(nodo == null){
            return -1;
        }else{
            return 1 + Math.max(alturaArbol(nodo.getIzquierdo()), alturaArbol(nodo.getDerecho())); // hacer una función que compare?
        }
    }
    
    public boolean contiene(Hotel dato){
        if(estaVacio()){
            return false;
        }
        else{
            NodoAVL<Hotel> nodo = raiz;
            while(nodo != null){
                int comparacion = nodo.getDato().compareTo(dato);
                if(comparacion == 0){
                    return true;
                }
                else if(comparacion <0){
                    nodo = nodo.getDerecho();
                }
                else{
                    nodo = nodo.getIzquierdo();
                }
            }
            return false;
        }
    }
    
    public Hotel obtener(Hotel dato){
        if(estaVacio()){
            return null;
        }
        else{
            NodoAVL<Hotel> nodo = raiz;
            while(nodo != null){
                int comparacion = nodo.getDato().compareTo(dato);
                if(comparacion == 0){
                    return nodo.getDato();
                }
                else if(comparacion <0){
                    nodo = nodo.getDerecho();
                }
                else{
                    nodo = nodo.getIzquierdo();
                }
            }
            return null;
        }
        //return obtener(dato, raiz);
    }
    
    private Hotel obtener(Hotel dato, NodoAVL<Hotel> nodo){
        if(nodo == null){
            return null;
        }
        else if(nodo.getDato().compareTo(dato) == 0){
            return nodo.getDato();
        }
        else{
            if(nodo.getDato().compareTo(dato) > 0){
                return (Hotel)obtener(dato, nodo.getIzquierdo());
            }
            else{
                return (Hotel)obtener(dato, nodo.getDerecho());
            }     
        }
    }
    
    public boolean estaVacio(){
        return raiz == null;
    }
}
