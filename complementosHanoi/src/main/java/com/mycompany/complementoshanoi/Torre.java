/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complementoshanoi;

import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JLabel;

/**
 *
 * @author phily
 */
public class Torre extends JLabel{
    private LinkedList<Disco> listadoDiscos;
    private final int numero;        
    
    public Torre(LinkedList<Disco> discos, int numeroTorre, int width, int height, int puntoX, int puntoY){
        listadoDiscos = discos;
        numero = numeroTorre;
        this.setSize(width, height);
        this.setLocation(new Point(puntoX, puntoY));
    }
    
    public void establecerListaDiscos(Disco disco){
        listadoDiscos.add(disco);
    }
    
    public void vaciarTorre(){
        listadoDiscos.clear();
    }
    
    public void aceptarDisco(Disco nuevoDisco){
        listadoDiscos.addLast(nuevoDisco);
    }
    
    public void sacarDisco(){
        listadoDiscos.removeLast();
    }
    
}
