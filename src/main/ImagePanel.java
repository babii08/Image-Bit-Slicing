package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private BufferedImage image;
	private boolean fitToScreen;
	private boolean aspectRatio;

	public ImagePanel() {
		super();
		image = null;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g1) {
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		
		if(image == null)
			return ;
		
		if(fitToScreen) {
			if(aspectRatio) {
				double vScale = 1.0 * getWidth() / image.getWidth();
				double hScale = 1.0 * getHeight() / image.getHeight();
				
				double scale = Math.min(vScale, hScale);
				int width = (int)scale * image.getWidth();
				int height = (int)scale * image.getHeight();
				
				g.drawImage(image,0,0,width,height,null);
			}
			else
			g.drawImage(image,0,0,getWidth(),getHeight(),null);
		}
		else {
			g.drawImage(image,null,0,0);
		}
	}
	
	public void loadImage(File file) {
		try {
			BufferedImage img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isFitToScreen() {
		return fitToScreen;
	}

	public void setFitToScreen(boolean fitToScreen) {
		this.fitToScreen = fitToScreen;
	}

	public boolean isAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(boolean aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
	
	
	
}
