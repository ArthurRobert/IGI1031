	package vue;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;

	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	
public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1812513897512845459L;

		public GameFrame(){
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

	        this.setJMenuBar(menubar);

			
		}

}
