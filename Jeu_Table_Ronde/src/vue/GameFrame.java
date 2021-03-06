	package vue;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
	
public class GameFrame extends JFrame{
	
	private static final long serialVersionUID = 1812513897512845459L;
	
	//instance singleton
	public static volatile GameFrame gameFrame=null;
	private Carte map=null;
	
	
	public final static GameFrame getInstance(){
		if (GameFrame.gameFrame==null){
			synchronized(GameFrame.class){
				if(GameFrame.gameFrame==null)
				{
					GameFrame.gameFrame= new GameFrame();
				}
			}
		}
		return GameFrame.gameFrame;
	}

		private GameFrame(){
			super("Aux quatre coins du monde");
			
			//taille de la fenêtre
			this.setSize(700,700);
			
			//croix rouge active
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//ajouter un menu
			this.ajouterMenu();
			
			//rendre la fenêtre visible
			this.setVisible(true);
			
		}
		

		//mettre dans une classe
		void ajouterMenu(){
			JMenuBar menubar = new JMenuBar();
	       
	        JMenu file = new JMenu("File");
	        file.setMnemonic(KeyEvent.VK_F);
	        
	        JMenuItem eMenuItemNew = new JMenuItem("Nouvelle Partie");
	        eMenuItemNew.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	
	        		
	        		
	            	new NouvellePartie();
	            }
	        });
	        file.add(eMenuItemNew);
	        
	        JMenuItem eMenuItemFermer = new JMenuItem("Fermer");
	        eMenuItemFermer.setMnemonic(KeyEvent.VK_E);
	        eMenuItemFermer.setToolTipText("Fermer l'application");
	        
	        eMenuItemFermer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                System.exit(0);
	            }
	        });

	        file.add(eMenuItemFermer);

	        menubar.add(file);
	        
	        JMenu aide = new JMenu("?");
	        JMenuItem eMenuItemRegle = new JMenuItem("Règles");
	        aide.add(eMenuItemRegle);
	        menubar.add(aide);

	        final String regles="<html><p>Le but est de récupérer les 4 objets Graal puis de retourner au château.</p>"	
	        +"<p>Après avoir récupéré un objet, chaque déplacement vous enlève autant de vie que le poids de l'objet</p></html>";
	        eMenuItemRegle.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	//default title and icon
	    			JOptionPane.showMessageDialog(gameFrame,
	    			    regles,"Règles du jeu", JOptionPane.INFORMATION_MESSAGE);
	    			
	            }
	        });
	    	
			
	        this.setJMenuBar(menubar);	
		}
		
		
		public Carte getMap() {
			return map;
		}

		public void setMap(Carte map) {
			this.map = map;
			if (map != null){
			 this.add(map.getCartePanel());
			this.setVisible(true);
			}
		}
		
		public static GameFrame getGameFrame() {
			return gameFrame;
		}

		public static void setGameFrame(GameFrame gameFrame) {
			GameFrame.gameFrame = gameFrame;
		}
	
	

}
