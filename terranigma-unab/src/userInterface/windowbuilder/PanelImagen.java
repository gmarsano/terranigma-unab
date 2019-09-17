package userInterface.windowbuilder;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {
	
	private ImageIcon imagen;
	
	public PanelImagen() {
		super();
		
		this.imagen = new ImageIcon(new ImageIcon(getClass().getResource("/userInterface/windowbuilder/images/terranigma.jpg")).getImage());
	}
	
	public void changeImage(String imgUri) {
		this.imagen = new ImageIcon(new ImageIcon(getClass().getResource(imgUri)).getImage());
		repaint();
	}
	
	@Override
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		Dimension tam = getSize();		
		
		g.drawImage(this.imagen.getImage(),0,0,tam.width,tam.height,null);
	}
}

