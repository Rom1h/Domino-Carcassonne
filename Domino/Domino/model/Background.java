package Domino.model;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;

public class Background {

	private BufferedImage image;
	
	public Background(String path) throws FileNotFoundException{
		try{
			image = ImageIO.read(new File(path));
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
}

