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
public class ArbolAVL<T extends Comparable<T>> {
    private NodoAVL<T> raiz;
    
    public void insertar(T dato){
        raiz = insertar(dato, raiz);
    }
    
    private NodoAVL<T> insertar(T dato, NodoAVL<T> nodo){
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
        }else if(dato.compareTo(nodo.getDato()) > 0){
            nodo.setDerecho(insertar(dato, nodo.getDerecho()));
            if(altura(nodo.getDerecho()) - altura(nodo.getIzquierdo()) == 2){
                if(nodo.getDerecho().getDato().compareTo(dato) < 0){
                    return rotacionHijoDerecho(nodo);
                }else{
                    return rotacionDobleHijoDerecho(nodo);
                }
            }
        }
        return null;
    }
    
    private int max(int alturaIzquierda, int alturaDerecha){
        return alturaIzquierda > alturaDerecha ? alturaIzquierda : alturaDerecha;
    }
    
    private NodoAVL<T> rotacionHijoIzquierdo(NodoAVL<T> nodo){
        NodoAVL<T> aux = nodo.getIzquierdo();
        nodo.setIzquierdo(aux.getDerecho());
        aux.setDerecho(nodo);
        nodo.setAltura(max(altura(aux.getIzquierdo()), nodo.getAltura()) + 1);
        aux.setAltura(max(altura(aux.getIzquierdo()), nodo.getAltura()) + 1);
        return aux;
    }
    
    private NodoAVL<T> rotacionHijoDerecho(NodoAVL<T> nodo){
        NodoAVL<T> aux = nodo.getDerecho();
        nodo.setDerecho(aux.getIzquierdo());
        aux.setIzquierdo(nodo);
        nodo.setAltura(max(altura(aux.getDerecho()), nodo.getAltura()) + 1);
        aux.setAltura(max(altura(aux.getDerecho()), nodo.getAltura()));
        return aux;
    }
    
    private NodoAVL<T> rotacionDobleHijoIzquierdo(NodoAVL<T> nodo){
        nodo.setIzquierdo(rotacionHijoDerecho(nodo.getIzquierdo()));
        return rotacionHijoDerecho(nodo);
    }
    
    private NodoAVL<T> rotacionDobleHijoDerecho(NodoAVL<T> nodo){
        nodo.setDerecho(rotacionHijoIzquierdo(nodo.getDerecho()));
        return rotacionHijoDerecho(nodo);
    }
    
    private int altura(NodoAVL<T> nodo){
        return nodo == null ? -1 : nodo.getAltura();
    }
    
    public void imprimirAscendente(){
        imprimirAscendente(raiz);
    }
    
    private void imprimirAscendente(NodoAVL nodo){
        if(nodo != null){
            imprimirAscendente(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            imprimirAscendente(nodo.getDerecho());
        }
    }
    
    public void imprimirDescendente(){
        imprimirDescendente(raiz);
    }
    
    private void imprimirDescendente(NodoAVL<T> nodo){
        if(nodo != null){
            imprimirDescendente(nodo.getDerecho());
            System.out.println(nodo.getDato());
            imprimirDescendente(nodo.getIzquierdo());
        }
    }
    
    public int alturaArbol(){
        return alturaArbol(raiz);
    }
    
    private int alturaArbol(NodoAVL<T> nodo){
        if(nodo == null){
            return -1;
        }else{
            return 1 + Math.max(alturaArbol(nodo.getIzquierdo()), alturaArbol(nodo.getDerecho())); // hacer una función que compare?
        }
    }
}
