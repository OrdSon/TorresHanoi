package Movimientos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phily
 */
public class Moviemiento {
    
    public int darMovimientosLimite(int numeroDiscos){
        return (int) (Math.pow(2, numeroDiscos) -1);
    }
    
}
