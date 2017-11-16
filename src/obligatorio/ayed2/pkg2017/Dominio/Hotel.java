/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Dominio;

import obligatorio.ayed2.pkg2017.Estructuras.Pila;
import obligatorio.ayed2.pkg2017.Estructuras.Lista;
import obligatorio.ayed2.pkg2017.Estructuras.TablaDCD;
import obligatorio.ayed2.pkg2017.Estructuras.TablaDispersionAbierta;
/**
 *
 * @author Equipo
 */
public class Hotel implements Comparable<Hotel>{
    
    private String ciudad;
    private String nombre;
    private int estrellas;
    private int capacidad;
    private int [] contadorRanking;
    private Pila<Comentario> comentarios;
    private Lista<Reserva> listaEspera;
    private Lista<Servicio> servicios;
    private TablaDCD<Reserva> reservas;
    
    public int [] getContadorRanking(){
        return contadorRanking;
    }
    
    public void setContadorRanking(int [] contador){
        this.contadorRanking = contador;
    }
    
    public Pila<Comentario> getComentarios(){
        return comentarios;
    }
    
    public void setComentarios(Pila<Comentario> coment){
        this.comentarios = coment;
    }
    
    public Lista<Reserva> getListaEspera(){
        return listaEspera;
    }
    
    public void setListaEspera(Lista<Reserva> espera){
        this.listaEspera = espera;
    }
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public Hotel(String nombre, String ciudad, int cantEstrellas, int capacidad)
    {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = cantEstrellas;
        this.capacidad = capacidad;
        inicializarEstructuras();
    }
    
    private void inicializarEstructuras(){
        this.contadorRanking = new int [6];
        this.comentarios = new Pila();
        this.listaEspera = new Lista();
    }
    
    public int calcularRanking(){
        int suma = 0;
        int contador = 0;
        for(int i = 0; i<contadorRanking.length; i++){
            suma+= (contadorRanking[i] * i);
            contador = contadorRanking[i];
        }
        return suma / contador;
    }    

    @Override
    public int compareTo(Hotel o) {
        if(nombre.compareTo(o.getNombre()) == 0){
            if(ciudad.compareTo(o.getCiudad()) == 0){
                return 0;
            }
            else{
                return 1;
            }
        }
        return -1;
    }
    
    @Override
    public boolean equals(Object other){
        if(this.nombre.equals(((Hotel)other).getNombre()) && this.ciudad.equals(((Hotel)other).getCiudad())){
            return true;
        }
        return false;
    }
}
