
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Form02 extends JFrame {

    private JButton botao = new JButton("Clique aqui!");
    private JTextField texto = new JTextField(10);
    private JLabel resultado = new JLabel("[]");
    
    private JList lista;
    private JScrollPane scrollPane;
    
    private JCheckBox cb = new JCheckBox();
    
    
    public Form02() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 300);
        setLayout(new FlowLayout());

        DefaultListModel model = new DefaultListModel();
        
        lista = new JList(model);
        
        model.addElement("TEste");
        //model.remove(0);
        
        JTable table = new JTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.addColumn("A");
        
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(180,100));
        scrollPane.setViewportView(lista);
        
        add(texto);
        add(botao);
        add(resultado);
        add(cb);

        add(scrollPane);
        
        
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

        texto.addKeyListener(new KeyAdapter() {

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
        Form02 f = new Form02();
        f.setVisible(true);
    }
}
