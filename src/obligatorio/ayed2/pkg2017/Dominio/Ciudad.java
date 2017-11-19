/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017.Dominio;

import obligatorio.ayed2.pkg2017.Estructuras.ArbolAVL;
import obligatorio.ayed2.pkg2017.Sistema;

/**
 *
 * @author Equipo
 */
public class Ciudad implements Comparable<Ciudad>{
    private String nombre;
    private ArbolAVL<Hotel> hoteles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArbolAVL<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArbolAVL<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    @Override
    public int compareTo(Ciudad o) {
        return this.nombre.compareTo(o.getNombre());
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.hoteles = new ArbolAVL<Hotel>();
    }
    
    public Sistema.TipoRet agregarHotel(Hotel elHotel){
        if(hoteles.contiene(elHotel)){
            return Sistema.TipoRet.ERROR_3;
        }
        else{
            hoteles.insertar(elHotel);
            return Sistema.TipoRet.OK;
        }
    }

    @Override
    public int hashCode() {
        int codigoHash = 0;
        for(int i = 0; i<nombre.length(); i++){
            codigoHash += (int)nombre.charAt(i);
        }
        return codigoHash;
    }
}
