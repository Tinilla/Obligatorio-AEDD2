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
public class Comentario implements Comparable<Comentario>{
    private String comentario;
    private int ranking;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Comentario(String comentario, int ranking) {
        this.comentario = comentario;
        this.ranking = ranking;
    }

    @Override
    public int compareTo(Comentario o) {
        return this.comentario.compareTo(o.getComentario()); //To change body of generated methods, choose Tools | Templates.
    }    
    
    @Override
    public String toString(){
        return this.comentario + " - " + this.ranking;
    }
}
