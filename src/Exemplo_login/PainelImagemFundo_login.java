package Exemplo_login;


import java.awt.Graphics;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matheus.csantos41
 */
public class PainelImagemFundo_login extends javax.swing.JPanel {

    private ImageIcon img;

    public PainelImagemFundo_login() {
        img = new ImageIcon();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public ImageIcon getImg() {
        return this.img;
    }
}
