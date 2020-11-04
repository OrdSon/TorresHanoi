/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author phily
 */
public class Torre extends LinkedList<Disco> {
    private int posicion;
    
    public Torre(){
        
    }
    
    public void ubicar(){
        for (int i = 0; i < size(); i++) {
            int x = posicion + (300 - get(i).getSize().width)/2;
            int y = (545-(35*i));
            Point point = new Point(x,y);
            get(i).setLocation(point);
            get(i).setAbsoluto(point);
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
