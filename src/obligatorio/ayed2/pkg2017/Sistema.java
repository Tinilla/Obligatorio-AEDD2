/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017;

import obligatorio.ayed2.pkg2017.Dominio.Hotel;
import obligatorio.ayed2.pkg2017.Estructuras.ArbolAVL;
import obligatorio.ayed2.pkg2017.Estructuras.TablaDispersionAbierta;

/**
 *
 * @author 
 */
public class Sistema {
    ArbolAVL<Hotel> hotelesPorNombre;
    ArbolAVL<Hotel> hotelesPorRanking;
    TablaDispersionAbierta<Hotel> hotelesPorCiudad;
    
    
    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, NO_IMPLEMENTADA
    };
    
    public TipoRet crearSistemaReservas(){
        hotelesPorNombre = new ArbolAVL();
        hotelesPorRanking = new ArbolAVL();
        hotelesPorCiudad = new TablaDispersionAbierta(50);
        return TipoRet.OK;
    }
    
    public TipoRet destruirSistemaReservas(){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet registrarHotel(String Ciudad, String Nombre, int Estrellas, int Capacidad){
        Hotel elHotel = new Hotel(Nombre, Ciudad, Estrellas, Capacidad);
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet ingresarServicio(String Ciudad, String Hotel, String Servicio){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet borrarServicio(String Ciudad, String Hotel, String Servicio){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet ingresarComentario(String Ciudad, String Hotel, String Comentario, int Ranking){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet realizarReserva(int cliente, String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet cancelarReserva(int cliente, String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarServicios(String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarHotelesCiudad(String Ciudad){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarHotelesRanking(){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarComentarios(String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
    public TipoRet listarEspera(String Ciudad, String Hotel){
        return TipoRet.NO_IMPLEMENTADA;
    }
    
}
