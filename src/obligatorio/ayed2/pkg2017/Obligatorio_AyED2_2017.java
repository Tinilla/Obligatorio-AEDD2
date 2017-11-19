/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.ayed2.pkg2017;

/**
 *
 * @author 
 */
public class Obligatorio_AyED2_2017 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        
        //-----------------------PRUEBAS OK---------------------------//
        
            PruebaOK_1(s,p);
            PruebaOK_2(s,p);
            PruebaOK_3(s,p);
            PruebaOK_4(s,p);
            PruebaOK_5(s,p);
            PruebaOK_6(s,p);
          
        //-----------------------PRUEBAS ERROR------------------------//
        
            //PruebaERROR_1(s,p);
            
        p.imprimirResultadosPrueba();
    }
    
    //-------------PRUEBAS OK-----------------//
    public static void PruebaOK_1(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 1: REGISTRAR HOTEL");
        p.ver(s.registrarHotel("Carmelo", "Urbano", 3, 20), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Carmelo");
        p.ver(s.registrarHotel("Carmelo", "Four Seasons", 5, 300), Sistema.TipoRet.OK, "Se agrega el hotel Four Seasons de Carmelo");
        p.ver(s.registrarHotel("Carmelo", "Centro", 2, 20), Sistema.TipoRet.OK, "Se agrega el hotel Centro de Carmelo");
        p.ver(s.registrarHotel("Colonia", "Urbano", 2, 20), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Colonia");
        s.listarHotelesRanking();
        finPrueba(" Fin PRUEBA 1");
    }
    
    public static void PruebaOK_2(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 2: INGRESAR SERVICIO");
        p.ver(s.registrarHotel("Carmelo", "Urbano", 3, 20), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Carmelo");
        
        p.ver(s.ingresarServicio("Carmelo", "Urbano", "Desayuno continental"), Sistema.TipoRet.OK, "Se agrega Desayuno continental a hotel Urbano de Carmelo");
        p.ver(s.ingresarServicio("Carmelo", "Urbano", "TV Cable"), Sistema.TipoRet.OK, "Se agrega TV Cable a hotel Urbano de Carmelo");
        p.ver(s.ingresarServicio("Carmelo", "Urbano", "Servicio a la habitación"), Sistema.TipoRet.OK, "Se agrega Servicio a la habitación a hotel Urbano de Carmelo");
        s.listarServicios("Carmelo", "Urbano");
        finPrueba(" Fin PRUEBA 2");
    }
    
    public static void PruebaOK_3(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 3: BORRAR SERVICIO");
        p.ver(s.registrarHotel("Carmelo", "Urbano", 3, 20), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Carmelo");
        
        p.ver(s.ingresarServicio("Carmelo", "Urbano", "Desayuno continental"), Sistema.TipoRet.OK, "Se agrega Desayuno continental a hotel Urbano de Carmelo");
        p.ver(s.ingresarServicio("Carmelo", "Urbano", "TV Cable"), Sistema.TipoRet.OK, "Se agrega TV Cable a hotel Urbano de Carmelo");
        p.ver(s.ingresarServicio("Carmelo", "Urbano", "Servicio a la habitación"), Sistema.TipoRet.OK, "Se agrega Servicio a la habitación a hotel Urbano de Carmelo");
        s.listarServicios("Carmelo", "Urbano");
        
        p.ver(s.borrarServicio("Carmelo", "Urbano", "Desayuno continental"), Sistema.TipoRet.OK, "Se borra Desayuno continental a hotel Urbano de Carmelo");
        s.listarServicios("Carmelo", "Urbano");
        finPrueba(" Fin PRUEBA 3");
    }
    
    public static void PruebaOK_4(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 4: INGRESAR COMENTARIO");
        p.ver(s.registrarHotel("Carmelo", "Urbano", 3, 20), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Carmelo");
        
        p.ver(s.ingresarComentario("Carmelo", "Urbano", "A gusto", 3), Sistema.TipoRet.OK, "Se ingresa comentario para hotel Urbano de Carmelo");
        p.ver(s.ingresarComentario("Carmelo", "Urbano", "Mala Atención", 0), Sistema.TipoRet.OK, "Se ingresa comentario para hotel Urbano de Carmelo");
        p.ver(s.ingresarComentario("Carmelo", "Urbano", "Lo que esperabamos", 4), Sistema.TipoRet.OK, "Se ingresa comentario para hotel Urbano de Carmelo");
        
        s.listarComentarios("Carmelo", "Urbano");
        finPrueba(" Fin PRUEBA 4");
    }
    
    public static void PruebaOK_5(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 5: REALIZAR RESERVA");
        p.ver(s.registrarHotel("Carmelo", "Urbano", 3, 2), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Carmelo");
        
        p.ver(s.realizarReserva(34175426, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 34175426");
        p.ver(s.realizarReserva(24515694, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 24515694");
        p.ver(s.realizarReserva(43547816, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 43547816");
        p.ver(s.realizarReserva(54177810, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 54177810");
        
        s.listarEspera("Carmelo", "Urbano");
        finPrueba(" Fin PRUEBA 5");
    }
    
    public static void PruebaOK_6(Sistema s, Prueba p){
        s.crearSistemaReservas();
        System.out.println("Se crea el Sistema de Reservas vacio");
        tituloPrueba("PRUEBA 6: CANCELAR RESERVA");
        p.ver(s.registrarHotel("Carmelo", "Urbano", 3, 2), Sistema.TipoRet.OK, "Se agrega el hotel Urbano de Carmelo");
        
        p.ver(s.realizarReserva(34175426, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 34175426");
        p.ver(s.realizarReserva(24515694, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 24515694");
        p.ver(s.realizarReserva(43547816, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 43547816");
        p.ver(s.realizarReserva(54177810, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Realiza una reserva para hotel Urbano de Carmelo, el cliente 54177810");
        s.listarEspera("Carmelo", "Urbano");
        
        p.ver(s.cancelarReserva(54177810, "Carmelo", "Urbano"), Sistema.TipoRet.OK, "Cancela una reserva para hotel Urbano de Carmelo, el cliente 54177810");
        s.listarEspera("Carmelo", "Urbano");
        finPrueba(" Fin PRUEBA 6");
    }
    
    
    
    
    public static void tituloPrueba(String s){
        System.out.println("****************************************************************");
        System.out.println("  "+ s );
        System.out.println("*****************************************************************");
    }

    public static void finPrueba(String s){
        System.out.println("******************* " + s +" ***********************");
        System.out.println("****************************************************");
        System.out.println();
    }
}
