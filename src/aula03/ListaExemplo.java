package aula03;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListaExemplo extends JFrame {

    private JLabel legenda = new JLabel("Digite o nome:");
    private JTextField nome = new JTextField(20);
    private JButton inserir = new JButton("Inserir");
    private JList lista;
    private JScrollPane painel;
    private DefaultListModel modelo;
    
    public ListaExemplo() {
        init();
    }

    // Inicializa componentes da interface grafica
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new FlowLayout());
        add(legenda);
        add(nome);
        add(inserir);
        // Montar a lista
        // Painel de rolagem
        painel = new JScrollPane();
        painel.setPreferredSize(new Dimension(380, 300));
        add(painel);
        // Lista
        modelo = new DefaultListModel();
        lista = new JList(modelo); // Vincula lista ao modelo
        painel.setViewportView(lista); // Adiciona lista no painel

        // Button click
        inserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionar();
            }
        });

        // Click na lista
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    remover();
                }
            }
        });
    }

    private void adicionar() {
        String text = nome.getText();
        modelo.addElement(text);
    }

    private void remover() {
        int linha = lista.getSelectedIndex();
        modelo.remove(linha);
    }

    public static void main(String[] args) {
        ListaExemplo le = new ListaExemplo();
        le.setVisible(true);
    }
}
