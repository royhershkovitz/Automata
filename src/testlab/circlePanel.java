package testlab;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class circlePanel extends JLayeredPane implements MouseMotionListener, MouseListener{
	public static final Image _circle = Images.InitImages.init("circle");
	public static final Image _cry = Images.InitImages.init("cry");
	private JLabel _pic = new JLabel();
	private JLabel _text = new JLabel();
	private static circleDrag _pa;
	public final int _name;
	
	circlePanel(int name){
		setSize(_circle.getWidth(this), _circle.getHeight(this));
		//setVisible(true);
		//this.setOpaque(true);
		_name = name;
		//pic
		_pic.setIcon(new ImageIcon(_circle));
		Dimension size = _pic.getPreferredSize();
		_pic.setBounds(0, 0, size.width, size.height);
		add(_pic, new Integer(1));
		
		//text
		_text = new JLabel(""+name, SwingConstants.CENTER);
		_text.setFont(new Font("David", Font.PLAIN, 24));
		//text.setForeground(Color.red);
		_text.setBounds(0, 0, size.width, size.height);
		add(_text, new Integer(2));
		
		addMouseMotionListener(this);
		addMouseListener(this);
		//System.out.println("fin-"+name + " " +  size.width + " " + size.height);
	}
	
	public static void setPa(circleDrag pa){
		_pa = pa;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		_pa.circleDrag(e, _name - 1);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//magnify the jlabel size
	public void magnify(double factor) {
		Image img = ((ImageIcon) _pic.getIcon()).getImage();
		int width = (int) (_pic.getWidth()*factor);
		int heigth = (int) (_pic.getHeight()*factor);
		_pic.setBounds(0, 0, width, heigth);
		_pic.setIcon(new ImageIcon(getScaledImage(img, width, heigth)));
		_text.setBounds(0, 0, width, heigth);
		setSize(width, heigth);
	}
	
	//reload the original settings
	public void refresh() {		
		int width = (int) (_circle.getWidth(this));
		int heigth = (int) (_circle.getHeight(this));
		_pic.setBounds(0, 0, width, heigth);
		_pic.setIcon(new ImageIcon(_circle));
		_text.setBounds(0, 0, width, heigth);
		setSize(width, heigth);
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_pa.circlePressed(e, _name - 1);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
