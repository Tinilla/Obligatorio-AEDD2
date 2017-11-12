/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Dominio;

/**
 *
 * @author Equipo
 */
public class Hotel {
    
    private String ciudad;
    private String nombre;
    private int estrellas;
    private int capacidad;
    
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
    }
    
    
    
}
