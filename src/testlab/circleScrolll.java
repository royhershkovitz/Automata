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
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;


public class circleScrolll extends JFrame implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{
	public static void main(String[] args) {
		new circleScrolll();
	}
	

	int _xEventView = 0;
	int _yEventView = 0;
	int _xcurrView = 0;
	int _ycurrView = 0;
	int _xDiff = 20;
	int _yDiff = 20;
	int zoom = 0;
	JLayeredPane _panel;
	JLabel[] scrollablesPics;
	JLabel[] scrollablesTexts;
	int[] locationsX;
	int[] locationsY;
	Image projImg = null;
	
	circleScrolll(){
		super("circle Scrolll");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_panel = new JLayeredPane();
		//Settings of frame	
		add(_panel);		
		try{			
			projImg = ImageIO.read((InputStream) this.getClass().getResourceAsStream("/testlab/circle.png"));
			setIconImage(projImg);
		}
		catch(Throwable ex){
			//System.out.println("/Ass4-Media/creeps/mike-2.png");
			System.out.println("missing /testlab/circle.png");
		}
		setSize(1000, 1000);
		setResizable(false);
		setVisible(true);		
		scrollablesPics = new JLabel[5];
		scrollablesTexts = new JLabel[5];
		locationsX = new int[5];
		locationsY = new int[5];
		
		//pics
		try {
			for(int i = 0; i < scrollablesPics.length; i++){
				//pic
				scrollablesPics[i] = new JLabel(new ImageIcon(projImg));
				Dimension size = scrollablesPics[i].getPreferredSize();
				locationsX[i] = (int) (819*Math.random());
				locationsY[i] = (int) (821*Math.random());
				scrollablesPics[i].setBounds(locationsX[i], locationsY[i], size.width, size.height);
				_panel.add(scrollablesPics[i],  new Integer(1));
				//System.out.println(scrollables[i].getX() + ", " + scrollables[i].getY() + ", " + size.width + ", " + size.height);
				//text
				scrollablesTexts[i] = new JLabel(""+i+1, SwingConstants.CENTER);
				scrollablesTexts[i].setFont(new Font("David", Font.PLAIN, 24));
				//text.setForeground(Color.red);
				scrollablesTexts[i].setBounds(locationsX[i], locationsY[i], size.width, size.height);
				_panel.add(scrollablesTexts[i], new Integer(2));
				
			}
		} catch (Throwable e) {
			_panel.add(new JLabel("<html>DataBase is corrupted<br>here have a beautiful chars art instead<br>" + bonus() +"</html>"));
		}
		
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
		for(JLabel scrollable : scrollablesPics)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() - _yDiff, scrollable.getWidth(), scrollable.getHeight());
		for(JLabel scrollable : scrollablesTexts)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() - _yDiff, scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void up(){
		for(JLabel scrollable : scrollablesPics)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() + _yDiff, scrollable.getWidth(), scrollable.getHeight());
		for(JLabel scrollable : scrollablesTexts)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() + _yDiff, scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void right(){
		for(JLabel scrollable : scrollablesPics)
			scrollable.setBounds(scrollable.getX() - _xDiff, scrollable.getY(), scrollable.getWidth(), scrollable.getHeight());
		for(JLabel scrollable : scrollablesTexts)
			scrollable.setBounds(scrollable.getX() - _xDiff, scrollable.getY(), scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void left(){
		for(JLabel scrollable : scrollablesPics)
			scrollable.setBounds(scrollable.getX() + _xDiff, scrollable.getY(), scrollable.getWidth(), scrollable.getHeight());
		for(JLabel scrollable : scrollablesTexts)
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
			increaseFactor = 0.9;
			zoom--;
		}
		else if (zoom <= 6){
			increaseFactor = 1.1;
			zoom++;
		}
		
		if (zoom < 6 & zoom > -6) {
			int x = arg0.getX();
			int y = arg0.getY();
			if(zoom == 0){
				int i = 0;
				for(JLabel labl : scrollablesPics){
					labl.setIcon(new ImageIcon(projImg));// reorder all x,y by map location settings
					labl.setBounds(locationsX[i] + _xcurrView, locationsY[i] + _ycurrView, 100, 100);
					i++;
				}
				i = 0;
				for(JLabel labl : scrollablesTexts){
					labl.setBounds(locationsX[i] + _xcurrView, locationsY[i] + _ycurrView, 100, 100);
					i++;
				}
			}
			else{
				for(JLabel labl : scrollablesPics){
					Image img = ((ImageIcon) labl.getIcon()).getImage();
					int width = (int) (img.getWidth(this)*increaseFactor);
					int heigth = (int) (img.getHeight(this)*increaseFactor);
	
					labl.setBounds((int) (x + increaseFactor*(labl.getX() - x)), (int) (y + increaseFactor*(labl.getY() - y)), width, heigth);
					labl.setIcon(new ImageIcon(getScaledImage(img, width, heigth)));
				}
				for(JLabel labl : scrollablesTexts){
					int width = (int) (labl.getWidth()*increaseFactor);
					int heigth = (int) (labl.getHeight()*increaseFactor);
	
					labl.setBounds((int) (x + increaseFactor*(labl.getX() - x)), (int) (y + increaseFactor*(labl.getY() - y)), width, heigth);					
				}
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
		_xEventView = arg0.getX();
		_yEventView = arg0.getY();				
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
		for(JLabel scrollableP : scrollablesPics)
			scrollableP.setBounds(scrollableP.getX() + e.getX() - _xEventView, scrollableP.getY() + e.getY() - _yEventView, scrollableP.getWidth(), scrollableP.getHeight());
		for(JLabel scrollableT : scrollablesTexts)
			scrollableT.setBounds(scrollableT.getX() + e.getX() - _xEventView, scrollableT.getY() + e.getY() - _yEventView, scrollableT.getWidth(), scrollableT.getHeight());
		_xcurrView = _xcurrView + e.getX() - _xEventView;
		_ycurrView = _ycurrView + e.getY() - _yEventView;
		_xEventView = e.getX();
		_yEventView = e.getY();
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
