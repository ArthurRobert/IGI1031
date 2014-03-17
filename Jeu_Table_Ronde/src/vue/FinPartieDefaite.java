package vue;

import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FinPartieDefaite extends JFrame{
    
	private static final long serialVersionUID = 1L;

	public FinPartieDefaite(){  
		/*			
		 	String path = new File("").getAbsolutePath();
			String pathImage=path+"/src/defaite.gif";
	        Icon icon = new ImageIcon(pathImage);
	        JOptionPane.showMessageDialog(null,
	                "Votre quête du graal s'achève ici...",
	                "Défaite", JOptionPane.INFORMATION_MESSAGE,
	                icon);
	     */
		
        this.setTitle("Dommage!");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);

        Font fonte = new Font("Times New Roman",Font.BOLD,25);
		String path = new File("").getAbsolutePath();
		String pathImage=path+"/src/defaite.gif";
        Icon icon = new ImageIcon(pathImage);
        
        JPanel panel = new JPanel();
        JLabel jLabel1 =new JLabel(icon, SwingConstants.CENTER);
        JLabel jLabel2 =new JLabel("Votre quête du Graal s'achève ici...",SwingConstants.CENTER);

        jLabel2.setFont(fonte);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(jLabel1);
        panel.add(jLabel2);

        this.setContentPane(panel);               
        this.setVisible(true);
      }       
    }