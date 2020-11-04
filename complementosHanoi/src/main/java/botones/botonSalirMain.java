/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import Juego.Menu;
import java.awt.event.MouseEvent;

/**
 *
 * @author samuelson
 */
public class botonSalirMain extends ActionButton{
    
    public botonSalirMain(Menu menu) {
        super();
        this.menu = menu;
        super.iconoSalir();
    }

    @Override
    public void mouseClicked(MouseEvent e) { 
        menu.dispose();
    }
    
}
