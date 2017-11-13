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
public class Reserva implements Comparable<Reserva>{
    
    private int cliente;
    private Hotel hotel;
    
    public int getCliente()
    {
        return cliente;
    }
    
    public void setCliente(int cliente)
    {
        this.cliente = cliente;
    }
    
    public Hotel getHotel()
    {
        return hotel;
    }
    
    public void setHotel(Hotel hotel)
    {
        this.hotel = hotel;
    }
    
    public Reserva(int cli, Hotel hotel)
    {
        this.cliente = cli;
        this.hotel = hotel;
    }

    @Override
    public int compareTo(Reserva o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
