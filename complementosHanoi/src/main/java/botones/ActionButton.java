/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import Juego.Menu;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author samuelson
 */
class ActionButton extends JLabel implements MouseListener {
    Menu menu;
    Dimension dimension;
    public ActionButton() {
        
        dimension = new Dimension(170, 58);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        
        this.setText("");
        this.setVisible(true);
        //se agregan los listener
        this.addMouseListener(this);
    }
    
    public void iconoJugar(){
      
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Interfaz/buttonPlay.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        this.setIcon(imageIcon);
    }
    
    public void iconoOpciones(){
        
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Interfaz/buttonOptions.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        this.setIcon(imageIcon);
    }
    
    public void iconoSalir(){
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Interfaz/buttonExitMain.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        this.setIcon(imageIcon);
    }
    
    public void iconorReinicia(){
        this.setSize(226, 30);
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Interfaz/ButtonReset.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(226, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        this.setIcon(imageIcon);
    }
    
    public void iconoExit(){
        this.setSize(226, 30);
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Interfaz/ButtonExit.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(226, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        this.setIcon(imageIcon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
