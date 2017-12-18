package testlab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ScrollScrap extends JFrame implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{
	public static void main(String[] args) {
		new ScrollScrap();
	}
	

	int _xView = 0;
	int _yView = 0;
	int _xDiff = 20;
	int _yDiff = 20;
	int zoom = 0;
	JPanel _panel;
	JLabel[] scrollables;
	Image projImg = null;
	
	ScrollScrap(){
		super("Scroll Scrap");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_panel = new JPanel(null);
		//Settings of frame	
		add(_panel);		
		try{			
			projImg = ImageIO.read(this.getClass().getResourceAsStream("/Media/cry.png"));
			setIconImage(projImg);
		}
		catch(Throwable ex){
			//System.out.println("/Ass4-Media/creeps/mike-2.png");
			System.out.println("missing /Media/cry.PNG");
		}
		setSize(1000, 1000);
		setResizable(false);
		setVisible(true);		
		scrollables = new JLabel[5];
		
		//pics
		try {
			for(int i = 0; i < scrollables.length; i++){
				scrollables[i] = new JLabel(new ImageIcon(projImg));
				_panel.add(scrollables[i]);
				Dimension size = scrollables[i].getPreferredSize();
				scrollables[i].setBounds((int) (819*Math.random()), (int) (821*Math.random()), size.width, size.height);
				//System.out.println(scrollables[i].getX() + ", " + scrollables[i].getY() + ", " + size.width + ", " + size.height);
			}
		} catch (Throwable e) {
			_panel.add(new JLabel("<html>DataBase is corrupted<br>here have a beautiful chars art instead<br>" + bonus() +"</html>"));
		}
		
		//text
		JLabel text = new JLabel("Hello");
		text.setFont(new Font("David", Font.PLAIN, 24));
		text.setForeground(Color.red);
		Dimension size = text.getPreferredSize();				
		text.setBounds((int) (50 + 800*Math.random()), (int) (50 + 800*Math.random()), size.width, size.height);
		_panel.add(text);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
	    addKeyListener(this);
	}

	/**
	 * a conforming for exception picture
	 */
	private static String bonus() {
		return 	"<pre><br>/        /   /                    /   /        /       /         /          <br>"
				+"         /              /     /                              /              <br>"
				+"   /                  //        /             /                             <br>"
				+"       ________      / |                            /         /             <br>"
				+"      /  ___   |    / //          /   /                                     <br>"
				+"     / //   |   |  / ///      /               /           /                 <br>"
				+"    / //    |____)/ / / |_   /                                    /         <br>"
				+"    |//     /      / /    \\     /      /   /            /                  <br>"
				+"    |/     /   (0 ))      |                 /                    /          <br>"
				+"          /                \\            /         /                        <br>"
				+"/       /         .        |________-------------->       /                 <br>"
				+"       -&lt^>  ______  _______|____           . . .   \\            .         <br>"
				+"  /     \\||     ________   /      \\          .  .     \\    ,             <br>"
				+"         ---------------  /                            |      /             <br>"
				+"              /                                         |  /                <br>"
				+" /           /                                         |^\\  /     /        <br>"
				+"      /     |                         /               |  |                  <br>"
				+"        /   |                        /                |. |    /|  /         <br>"
				+"             |                       |                 _/  /\\              <br>"
				+"    /          \\_______/   /___________\\________./  /         /\\         <br>"
				+"               ///_______/              ///________/        /\\   /         <br>"
				+"        /                        /             /                            <br>"
				+"             /     /    /                           /                       <br>"
				+"            /     //                                          /             <br>"
				+"/          //    / /                 /   /            \\   /                <br>"
				+"  /       / /   / //         __________-------------->       /              <br>"
				+"         /  |  / //     -------                        \\       /|          <br>"
				+"  /     /   )_/ ///_ /                                   \\                 <br>"
				+"       /           \\                                      |      /         <br>"
				+"      |    .        |                                      |  /             <br>"
				+" /    (O))    (O))   |                                     |^\\  /     /    <br>"
				+"      |              |                        /           |  |              <br>"
				+"      |        .    |                        /            |. |  |  /        <br>"
				+"    --\\    --   _____                      |               _/        /\\   <br>"
				+"    / --&lt^> ___   /   _____/   /___________\\________./   /             /\\ <br>"
				+"        \\||/=== /   ///_______/              ///________/      /\\   /     <br>"
				+" /                               /   /  / /                 /      /        <br>"
				+"                                                                            <br>"
				+"                              The Rabbit                                    <br>"
				+"    @Roy hershkovitz                                                        <br>"
				+" -------------------------------------------------------------------------- </pre>";
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT | e.getKeyCode()== KeyEvent.VK_A){
			//System.out.println("A");
			left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT | e.getKeyCode()== KeyEvent.VK_D){
			//System.out.println("D");
			right();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP | e.getKeyCode()== KeyEvent.VK_W){			
			//System.out.println("W");
			up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode()== KeyEvent.VK_S){
			//System.out.println("S");
			down();
		}		
	}
	
	private void down(){
		for(JLabel scrollable : scrollables)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() - _yDiff, scrollable.getWidth(), scrollable.getHeight());					
	}
	
	private void up(){
		for(JLabel scrollable : scrollables)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() + _yDiff, scrollable.getWidth(), scrollable.getHeight());		
	}
	
	private void right(){
		for(JLabel scrollable : scrollables)
			scrollable.setBounds(scrollable.getX() - _xDiff, scrollable.getY(), scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void left(){
		for(JLabel scrollable : scrollables)
			scrollable.setBounds(scrollable.getX() + _xDiff, scrollable.getY(), scrollable.getWidth(), scrollable.getHeight());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		//System.out.println("2");		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//System.out.println("3");		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		//System.out.println(arg0.getWheelRotation());
		double increaseFactor = 0;
		if(arg0.getWheelRotation() < 0 & zoom >= -6){
			increaseFactor = 1.1;
			zoom--;
		}
		else if (zoom <= 6){
			increaseFactor = 0.9;
			zoom++;
		}
		
		if (zoom < 6 & zoom > -6) {
			int x = arg0.getX();
			int y = arg0.getY();
			if(zoom == 0){
				for(JLabel labl : scrollables){
					labl.setIcon(new ImageIcon(projImg));// reorder all x,y by map location settings
					labl.setBounds((int) (x + increaseFactor*(labl.getX() - x)), (int) (y + increaseFactor*(labl.getY() - y)), labl.getWidth(), labl.getHeight());
				}
			}
			else
				for(JLabel labl : scrollables){
					Image img = ((ImageIcon) labl.getIcon()).getImage();
					int width = (int) (img.getWidth(this)*increaseFactor);
					int heigth = (int) (img.getHeight(this)*increaseFactor);
	
					labl.setBounds((int) (x + increaseFactor*(labl.getX() - x)), (int) (y + increaseFactor*(labl.getY() - y)), width, heigth);
					labl.setIcon(new ImageIcon(getScaledImage(img, width, heigth)));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//System.out.println("1: " +arg0.getX() +" "+ arg0.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//System.out.println("2: " +arg0.getX() +" "+ arg0.getY());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//System.out.println("3: " +arg0.getX() +" "+ arg0.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//System.out.println("4: " +arg0.getX() +" "+ arg0.getY());
		_xView = arg0.getX();
		_yView = arg0.getY();				
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//System.out.println("5: " +arg0.getX() +" "+ arg0.getY());
//		if(arg0.getX() - _xView > 5 | arg0.getX() - _xView < -5 | arg0.getY() - _yView > 5 | arg0.getY() - _yView < -5)
//		for(JLabel scrollable : scrollables)
//			scrollable.setBounds(scrollable.getX() + arg0.getX() - _xView, scrollable.getY() + arg0.getY() - _yView, scrollable.getWidth(), scrollable.getHeight());	
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("drag: " +e.getX() +" "+ e.getY());
		for(JLabel scrollable : scrollables)
			scrollable.setBounds(scrollable.getX() + e.getX() - _xView, scrollable.getY() + e.getY() - _yView, scrollable.getWidth(), scrollable.getHeight());	
		_xView = e.getX();
		_yView = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("move: " +e.getX() +" "+ e.getY());
		
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

}
