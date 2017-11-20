/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Dominio;

import obligatorio.ayed2.pkg2017.Estructuras.Pila;
import obligatorio.ayed2.pkg2017.Estructuras.Lista;
import obligatorio.ayed2.pkg2017.Estructuras.TablaDCD;
import obligatorio.ayed2.pkg2017.Sistema;
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
    private Lista<Integer> listaEspera;
    private Lista<String> servicios;
    private TablaDCD<Integer> reservas;
    
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
    
    public Lista<Integer> getListaEspera(){
        return listaEspera;
    }
    
    public void setListaEspera(Lista<Integer> espera){
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

    public Lista<String> getServicios() {
        return servicios;
    }

    public void setServicios(Lista<String> servicios) {
        this.servicios = servicios;
    }

    public TablaDCD<Integer> getReservas() {
        return reservas;
    }

    public void setReservas(TablaDCD<Integer> reservas) {
        this.reservas = reservas;
    }

    public Hotel(String nombre) {
        this.nombre = nombre;

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
        this.reservas = new TablaDCD(capacidad);
        this.servicios = new Lista<>();
    }
    
     @Override
    public int compareTo(Hotel o) {
        return this.nombre.compareTo(o.getNombre());
    }
    
    @Override
    public boolean equals(Object other){
        if(this.nombre.equals(((Hotel)other).getNombre()) && this.ciudad.equals(((Hotel)other).getCiudad())){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.ciudad +" - " + this.nombre + " - " + calcularRanking();
    }
    
    public String toString2(){
        return this.nombre + " " + this.estrellas + " " + calcularRanking();
    }
    
    public int calcularRanking(){
        int suma = 0;
        int contador = 0;
        for(int i = 0; i<contadorRanking.length; i++){
            suma+= (contadorRanking[i] * i);
            contador = contadorRanking[i];
        }
        if(contador != 0){
            return suma / contador;
        }
        return contador;
    }    
    
    public void agregarReserva(Integer cliente){
        if(this.reservas.getContador() == capacidad){
            listaEspera.agregarInicio(cliente);
        }
        else{
            reservas.insertar(cliente);
        }
    }
    
    public Sistema.TipoRet cancelarReserva(Integer cliente){
        if(reservas.contiene(cliente)){
            reservas.remover(cliente);
            return Sistema.TipoRet.OK;
        }
        else if(listaEspera.contiene(cliente)){
            listaEspera.removerItem(cliente);
            return Sistema.TipoRet.OK;
        }
        return Sistema.TipoRet.ERROR_2;
    }
    
    public void ingresarServicio(String servicio){
        this.servicios.agregarInicio(servicio);
    }
    
    public Sistema.TipoRet eliminarServicio(String elServicio){
        if(servicios.contiene(elServicio)){
            servicios.removerItem(elServicio);
            return Sistema.TipoRet.OK;
        }
        return Sistema.TipoRet.ERROR_2;
    }
    
    public int ingresarComentario(Comentario elComentario){
        this.comentarios.apilar(elComentario);
        this.contadorRanking[elComentario.getRanking()]++;
        return calcularRanking();
    }
    
    public void listarServicios(){
        if(servicios.estaVacio()){
            System.out.println("No existen servicios registrados en el hotel " + nombre + " " + ciudad);
        }
        else{
            servicios.imprimir();
        }
    }
    
    public void imprimirEspera(){
        if(listaEspera.estaVacio()){
            System.out.println("No existen reservas pendientes para el hotel "+ nombre + " " + ciudad);
        }
        else{
            listaEspera.imprimir();
        }
    }
    
}
