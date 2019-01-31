package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	static BufferedImage OpenImage(String Path) {
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(Path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
