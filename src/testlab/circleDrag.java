package testlab;

import java.awt.Dimension;
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

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class circleDrag extends JFrame implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener{
	public static void main(String[] args) {
		new circleDrag();
	}	
	private int _xEventView = 0;
	private int _yEventView = 0;
	private int _xcurrView = 0;
	private int _ycurrView = 0;
	private int _xDiff = 30;
	private int _yDiff = 30;
	private int zoom = 0;
	private JPanel _panel;
	private circlePanel[] _draggablePanels;
	private int[] locationsX;
	private int[] locationsY;
	
	circleDrag(){
		super("circle Drag");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(circlePanel._cry);
		circlePanel.setPa(this);
		_panel = new JPanel(null);		
		add(_panel);
		//_panel.add(new JInternalFrame());
		
		setSize(1000, 1000);
		setResizable(false);
		setVisible(true);
		_draggablePanels = new circlePanel[5];
		locationsX = new int[5];
		locationsY = new int[5];
		
		for(int i = 0; i < _draggablePanels.length; i++){
			//pic
			_draggablePanels[i] = new circlePanel(1 + i);			
			Dimension size = _draggablePanels[i].getPreferredSize();
			locationsX[i] = (int) (900*Math.random());
			locationsY[i] = (int) (900*Math.random());
			_panel.add(_draggablePanels[i]);
			_draggablePanels[i].setBounds(locationsX[i], locationsY[i], size.width, size.height);
			//System.out.println("pane: " + i + ", locationsX: " + locationsX[i] + ", locationsY: " +
			//		locationsY[i] + ", size: " + size.width + ", " + size.height);				
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
		for(circlePanel scrollable : _draggablePanels)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() - _yDiff, scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void up(){
		for(circlePanel scrollable : _draggablePanels)
			scrollable.setBounds(scrollable.getX(), scrollable.getY() + _yDiff, scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void right(){
		for(circlePanel scrollable : _draggablePanels)
			scrollable.setBounds(scrollable.getX() - _xDiff, scrollable.getY(), scrollable.getWidth(), scrollable.getHeight());
	}
	
	private void left(){
		for(circlePanel scrollable : _draggablePanels)
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
		//System.out.println(arg0.getWheelRot                                        ation());
		double increaseFactor = 0;
		if(arg0.getWheelRotation() < 0 & zoom >= -6){
			increaseFactor = 1.2;
			zoom--;
		}
		else if (zoom <= 6){
			increaseFactor = 0.8;
			zoom++;
		}
		
		if (zoom < 6 & zoom > -6) {
			int x = arg0.getX();
			int y = arg0.getY();
			int i = 0;
			if(zoom == 0){				
				for(circlePanel scrollable : _draggablePanels){
					scrollable.refresh();					
					scrollable.setBounds(locationsX[i] + _xcurrView, locationsY[i] + _ycurrView, 100, 100);
					i++;
				}
			}
			else{
				for(circlePanel scrollable : _draggablePanels){
					scrollable.magnify(increaseFactor);
					scrollable.setBounds((int) (x + increaseFactor*(scrollable.getX() - x)), 
							(int) (y + increaseFactor*(scrollable.getY() - y)), scrollable.getWidth(), scrollable.getHeight());
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
		//System.out.println("4: " +arg0.getX() +", "+ arg0.getY());
		_xEventView = arg0.getX();
		_yEventView = arg0.getY();				
	}
	
	public void circlePressed(MouseEvent arg0, int name) {
		//System.out.print("4: " +arg0.getX() +", "+ arg0.getY());
		_xEventView = _draggablePanels[name].getX() + arg0.getX();
		_yEventView = _draggablePanels[name].getY() + arg0.getY();
		//System.out.println("->" + _xEventView +", "+ _yEventView);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("drag: " +e.getX() +" "+ e.getY());
		int dx = e.getX() - _xEventView;
		int dy = e.getY() - _yEventView;
		for(circlePanel scrollableP : _draggablePanels)
			scrollableP.setBounds(scrollableP.getX() + dx, scrollableP.getY() + dy, 
					scrollableP.getWidth(), scrollableP.getHeight());		
		//System.out.println(dx + " = " + e.getX() + " - " + _xEventView);
		//System.out.println(dy + " = " + e.getY() + " - " + _yEventView);
		_xcurrView = _xcurrView + dx;
		_ycurrView = _ycurrView + dy;
		_xEventView = e.getX();
		_yEventView = e.getY();
	}
	
	@Override
		public void mouseReleased(MouseEvent arg0) {
			//System.out.println("5: " +arg0.getX() +" "+ arg0.getY());
	//		if(arg0.getX() - _xView > 5 | arg0.getX() - _xView < -5 | arg0.getY() - _yView > 5 | arg0.getY() - _yView < -5)
	//		for(JLabel scrollable : scrollables)
	//			scrollable.setBounds(scrollable.getX() + arg0.getX() - _xView, scrollable.getY() + arg0.getY() - _yView, scrollable.getWidth(), scrollable.getHeight());	
			
		}

	public void circleDrag(MouseEvent e, int name) {
		int eX = _draggablePanels[name].getX() + e.getX();
		int eY = _draggablePanels[name].getY() + e.getY();
		int dx = eX - _xEventView;
		int dy = eY - _yEventView;
		//System.out.println(_draggablePanels[name].getX() + ", " + _draggablePanels[name].getY());
		//System.out.println(dx + " = " + e.getX() + " - " + _xEventView);
		//System.out.println(dy + " = " + e.getY() + " - " + _yEventView);
		_draggablePanels[name].setBounds(_draggablePanels[name].getX() + dx, _draggablePanels[name].getY() + dy,
				_draggablePanels[name].getWidth(), _draggablePanels[name].getHeight());
		locationsX[name] = _draggablePanels[name].getX();
		locationsY[name] = _draggablePanels[name].getY();
		//System.out.println(locationsX[name] + " " + locationsY[name]);
		_xEventView = eX;
		_yEventView = eY;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("move: " +e.getX() +" "+ e.getY());
		
	}
}
