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
    
    public int getCliente()
    {
        return cliente;
    }
    
    public void setCliente(int cliente)
    {
        this.cliente = cliente;
    }
    
    public Reserva(int cli, Hotel hotel)
    {
        this.cliente = cli;
    }

    @Override
    public int compareTo(Reserva o) {
        return ((Integer)cliente).compareTo(((Integer)o.getCliente()));
    }
    
}
