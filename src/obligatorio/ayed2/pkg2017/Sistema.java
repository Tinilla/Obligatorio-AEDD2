/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017;

import obligatorio.ayed2.pkg2017.Dominio.Ciudad;
import obligatorio.ayed2.pkg2017.Dominio.Hotel;
import obligatorio.ayed2.pkg2017.Estructuras.ArbolAVL;
import obligatorio.ayed2.pkg2017.Estructuras.Lista;
import obligatorio.ayed2.pkg2017.Estructuras.TablaDispersionAbierta;
import obligatorio.ayed2.pkg2017.Dominio.Comentario;

/**
 *
 * @author 
 */
public class Sistema {
    private ArbolAVL<Hotel> hotelesPorNombre;
    private Lista<Hotel>[] hotelesPorRanking;
    private TablaDispersionAbierta<Ciudad> ciudadesHoteles;  
    
    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, NO_IMPLEMENTADA
    };
    
    public TipoRet crearSistemaReservas(){
        hotelesPorNombre = new ArbolAVL();
        hotelesPorRanking = new Lista[6];
        for(int i = 0; i <6; i++){
            hotelesPorRanking[i] = new Lista<Hotel>();
        }
        ciudadesHoteles = new TablaDispersionAbierta(50);
        return TipoRet.OK;
    }
    
    public TipoRet destruirSistemaReservas(){
        hotelesPorNombre = null;
        hotelesPorRanking = null;
        ciudadesHoteles = null;
        return TipoRet.OK;
    }
    
    public TipoRet registrarHotel(String Ciudad, String Nombre, int Estrellas, int Capacidad){
        Hotel elHotel = new Hotel(Nombre, Ciudad, Estrellas, Capacidad);
        Ciudad laCiudad = new Ciudad(Ciudad);
        boolean existeCiudad = ciudadesHoteles.contiene(laCiudad);
        if(Estrellas < 1 || Estrellas > 5){
            return TipoRet.ERROR_1;
        }
        else if(Capacidad < 0){
            return TipoRet.ERROR_2;
        }
        else if(!existeCiudad){
            laCiudad.agregarHotel(elHotel);
            ciudadesHoteles.insert(laCiudad);
            this.hotelesPorNombre.insertar(elHotel);
            this.hotelesPorRanking[0].agregar(elHotel);
            return TipoRet.OK;
        }
        else{
            TipoRet resultado = ciudadesHoteles.obtener(laCiudad).agregarHotel(elHotel);
            if(resultado.equals(TipoRet.OK)){
                this.hotelesPorNombre.insertar(elHotel);
                this.hotelesPorRanking[0].agregar(elHotel);
            }
            return resultado;
        }
    }
    
    public TipoRet ingresarServicio(String Ciudad, String Hotel, String Servicio){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel != null){
                elHotel.ingresarServicio(Servicio);
                return TipoRet.OK;
            }
        }
        return TipoRet.ERROR_1;
    }
    
    public TipoRet borrarServicio(String Ciudad, String Hotel, String Servicio){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel!= null){
                return elHotel.eliminarServicio(Servicio);
            }
        }
        return TipoRet.ERROR_1;
    }
    
    public TipoRet ingresarComentario(String Ciudad, String Hotel, String Comentario, int Ranking){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(Ranking < 0 || Ranking > 5){
            return TipoRet.ERROR_1;
        }
        else if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel!=null){
                int viejoRanking = elHotel.calcularRanking();
                Comentario elComentario = new Comentario(Comentario, Ranking);
                int nuevoRanking = elHotel.ingresarComentario(elComentario);
                if(viejoRanking != nuevoRanking){
                    cambiarRanking(viejoRanking, nuevoRanking, elHotel);
                }
                return TipoRet.OK;
            }
        }
        return TipoRet.ERROR_2;
    }
    
    private void cambiarRanking(int viejoRanking, int nuevoRanking, Hotel elHotel){
        this.hotelesPorRanking[viejoRanking].removerItem(elHotel);
        this.hotelesPorRanking[nuevoRanking].agregar(elHotel);
    }
    
    public TipoRet realizarReserva(int cliente, String Ciudad, String Hotel){
        Ciudad laCiudad = this.ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel != null){
                elHotel.agregarReserva(cliente);
                return TipoRet.OK;
            }
        }
        return TipoRet.ERROR_1;
    }
    
    public TipoRet cancelarReserva(int cliente, String Ciudad, String Hotel){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel != null){
                return elHotel.cancelarReserva(cliente);
            }
        }
        return TipoRet.ERROR_1;
    }
    
    public TipoRet listarServicios(String Ciudad, String Hotel){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel != null){
                elHotel.listarServicios();
            }
        }
        return TipoRet.OK;
    }
    
    public TipoRet listarHotelesCiudad(String Ciudad){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad == null){
            System.out.println("No existen hoteles registrados en " + Ciudad);
        }else{
            laCiudad.getHoteles().imprimirAscendente();
        }
        return TipoRet.OK;
    }
    
    public TipoRet listarHotelesRanking(){
        boolean vacio = true;
        for(int i = 5; i>= 0; i--){
            if(!hotelesPorRanking[i].estaVacio()){
                hotelesPorRanking[i].imprimir();
                vacio = false;
            }
        }
        if(vacio){
            System.out.println("No hay registros de hoteles en el sistema");
        }
        return TipoRet.OK;
    }
    
    public TipoRet listarComentarios(String Ciudad, String Hotel){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel != null){
                if(!elHotel.getComentarios().estaVacio()){
                System.out.println("Comentarrios sobre el hotel " +Hotel + " " + Ciudad );
                elHotel.getComentarios().imprimir();
                }else{
                    System.out.println("No se han agregado comentarios al hotel "+Hotel+" "+ Ciudad);
                }
            }
        }
        return TipoRet.ERROR_1;
    }
    
    public TipoRet listarEspera(String Ciudad, String Hotel){
        Ciudad laCiudad = ciudadesHoteles.obtener(new Ciudad(Ciudad));
        if(laCiudad != null){
            Hotel elHotel = laCiudad.getHoteles().obtener(new Hotel(Hotel));
            if(elHotel != null){
                elHotel.imprimirEspera();
            }
        }
        return TipoRet.ERROR_1;
    }
    
}
