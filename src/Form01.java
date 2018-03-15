
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Form01 extends JFrame {

    private JButton botao = new JButton("Clique aqui!");
    private JTextField texto = new JTextField(10);
    private JLabel resultado = new JLabel("[]");
    
    private JCheckBox cb = new JCheckBox();
    
    
    public Form01() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 300);
//        BorderLayout bl = new BorderLayout();
//        setLayout(bl);
//        add(texto, BorderLayout.CENTER);
//        add(botao, BorderLayout.SOUTH);
//        GridLayout gl = new GridLayout(1, 2);
//        setLayout(gl);
        setLayout(new FlowLayout());
        add(texto);
        add(botao);
        add(resultado);
        add(cb);

        
        
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if ( cb.isSelected() )
                {
                    JOptionPane.showMessageDialog(null, "Esta selecionado!");
                }
                resultado.setText(texto.getText());
                Tela02 tela = new Tela02();
                tela.setVisible(true);
            }
        });

        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    JOptionPane.showMessageDialog(null, "CTRL");
                }
                resultado.setText( texto.getText() );
            }
        });

    }

    public static void main(String[] args) {
        System.out.println("iniciando...");
        Form01 f = new Form01();
        f.setVisible(true);
    }
}
