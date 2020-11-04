/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import Juego.EndScreen;
import Juego.Interfaz;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author samuelson
 */
public class botonSalir extends ActionButton{
       Interfaz interfaz;
       EndScreen endScreen;
       
    public botonSalir(Interfaz interfaz) {
        super();
        this.interfaz = interfaz;
        super.iconoExit();
    }
    public botonSalir(EndScreen endScreen) {
        super();
        this.endScreen = endScreen;
        super.iconoExit();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int confirm = JOptionPane.showConfirmDialog(interfaz, "¿Quiere salir del juego?");
        if (confirm == 0) {
            System.exit(0);
        }
        
    }
}
