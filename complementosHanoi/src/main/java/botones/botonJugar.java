/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import Juego.Interfaz;
import Juego.Menu;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JSlider;

/**
 *
 * @author samuelson
 */
public class botonJugar extends ActionButton {
    
    
   
    public botonJugar(Menu menu) {
        super();
        this.menu = menu;
        super.iconoJugar();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Interfaz interfaz = new Interfaz();
        interfaz.iniciar(menu.getCantidadDiscos());
        interfaz.setVisible(true);
        menu.dispose();
    }

}
