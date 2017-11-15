package Images;
import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;

import testlab.ScrollScrap;

public class InitImages {
	/** 
	 * @return the image icon with this name in package 'Ass4-Media'
	 */
	public static Image init(String name){
		Image tImage = null;
		try {
			tImage = ImageIO.read((InputStream) ScrollScrap.class.getResourceAsStream("/Media/"+name+".png"));
		} 
		catch (Throwable e) {
			System.out.println("Missing /Media/"+name+".png Picture");
		}
		return tImage;
	}
	
	public static Image[] init(String[] names){
		Image[] imageArr = new Image[names.length];
		for(int i = 0; i<names.length; i++)
			imageArr[i] = init(names[i]);
		return imageArr;
	}
}
