/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import com.mycompany.complementoshanoi.Disco;
import com.mycompany.complementoshanoi.Torre;
import java.util.LinkedList;

/**
 *
 * @author samuelson
 */
public class Juego {

    LinkedList<Torre> torres = new LinkedList<>();

    public Juego() {
        instanciarTorres();
    }
    
    public void llenarTorre(int cantidad){
        torres.getFirst().llenar(cantidad);
    }
    
    public void instanciarTorres(){
        for (int i = 0; i < 3; i++) {
            Torre torre = new Torre();
            torres.add(torre);
        }
    }

    public LinkedList<Torre> getTorres() {
        return torres;
    }

    public void setTorres(LinkedList<Torre> torres) {
        this.torres = torres;
    }
    
    
}
