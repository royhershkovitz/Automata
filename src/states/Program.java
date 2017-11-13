package states;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Program extends JFrame {
		public static void main(String[] args) {
			AnState._alefBeit = new char[]{'1', '0'};//StartState
			//R = (0,1)*0(0,1)
//			AnStartState s1 = new AnStartState("s");
//			AnState a2 = new AnState("1");
//			AnWiningState a3 = new AnWiningState("2");
//			AnWiningState a4 = new AnWiningState("3");
//			s1.addRoute('0', a2);
//			s1.addRoute('1', s1);
//			a2.addRoute('0', a3);
//			a2.addRoute('1', a4);
//			a3.addRoute('0', a3);
//			a3.addRoute('1', a4);
//			a4.addRoute('0', a2);
//			a4.addRoute('1', s1);
//			System.out.println("0 : " + s1.compute("0"));
//			System.out.println("01 : " + s1.compute("01"));
//			System.out.println("00 : " + s1.compute("00"));
//			System.out.println("0000011 : " + s1.compute("0000011"));
//			System.out.println("0100001 : " + s1.compute("0100001"));
//			System.out.println("0100000 : " + s1.compute("0100000"));
			
			AnStartState NFA = new AnStartState("s");
			AnState NFA1 = new AnState("1");
			AnWiningState NFA2 = new AnWiningState("2");
			NFA.addRoute('0', NFA);
			NFA.addRoute('1', NFA);
			NFA.addRoute('0', NFA1);
			NFA1.addRoute('0', NFA2);
			NFA1.addRoute('1', NFA2);
			System.out.println("0 : " + NFA.compute("0"));
			System.out.println("01 : " + NFA.compute("01"));
			System.out.println("00 : " + NFA.compute("00"));
			System.out.println("0000011 : " + NFA.compute("0000011"));
			System.out.println("0100001 : " + NFA.compute("0100001"));
			System.out.println("0100000 : " + NFA.compute("0100000"));
			
			new Program();
		}
//		int theAnswerToOurExistance = 42;
//		while(theAnswerToOurExistance == 42)
//			System.out.println("ima shelha yoledet tinok");	}
		Program(){
			super("Automata");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Settings of frame
			setResizable(false);
			setVisible(true);
			add(new JLabel("<html>DataBase is corrupted<br>here have a beautiful chars art instead<br>" + bonus() +"</html>"));
			pack();
			//presentMenu();
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
}
