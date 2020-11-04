/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import Juego.Interfaz;
import Juego.Menu;
import Juego.Opciones;
import java.awt.event.MouseEvent;

/**
 *
 * @author samuelson
 */
public class botonOpciones extends ActionButton{
    
    public botonOpciones(Menu menu) {
        super();
        this.menu = menu;
        super.iconoOpciones();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Opciones opciones = new Opciones(menu);
        opciones.setVisible(true);
    }
}
