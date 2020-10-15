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
    private LinkedList<Disco> listadoDiscos = new LinkedList<>();       
    private int numero = 0;
    
    public Torre() {
        this.setText("torre?");
    }
    
    public Torre(int numeroTorre, int width, int height, int puntoX, int puntoY){
        numero = numeroTorre;
        this.setSize(width, height);
        this.setLocation(new Point(puntoX, puntoY));
    }
    
    public void llenar(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            int alto = 40;
            int x = ((int)this.getLocation().getX())+((int)(this.getSize().getWidth()/2));
            int y = (600-(40*i));
            int ancho = (300 - (20*i));
            Disco disco = new Disco(alto, ancho, x, y);
            listadoDiscos.add(disco);
        }
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
    
    public void eliminarDisco(Disco disco){
        listadoDiscos.remove(disco);
    }
    
}
