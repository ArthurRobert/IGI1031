package vue;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FinPartieVictoire extends JFrame{
    
    public FinPartieVictoire(){             
        this.setTitle("Félicitation!");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);

        Font fonte = new Font("Times New Roman",Font.BOLD,25);

        Icon icon = new ImageIcon("victoire3.jpg");
        
        JPanel panel = new JPanel();
        JLabel jLabel1 =new JLabel(icon, SwingConstants.CENTER);
        JLabel jLabel2 =new JLabel("Bravo, vous avez gagné!",SwingConstants.CENTER);

        jLabel2.setFont(fonte);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(jLabel1);
        panel.add(jLabel2);

        this.setContentPane(panel);               
        this.setVisible(true);
      }
}