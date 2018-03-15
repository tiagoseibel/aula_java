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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TabelaExemplo extends JFrame {

    private JLabel legenda = new JLabel("Digite o nome:");
    private JTextField nome = new JTextField(20);
    private JButton inserir = new JButton("Inserir");
    private JTable tabela;
    private JScrollPane painel;
    private DefaultTableModel modelo;

    public TabelaExemplo() {
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
        // Montar a tabela
        // Painel de rolagem
        painel = new JScrollPane();
        painel.setPreferredSize(new Dimension(380, 300));
        add(painel);
        // Tabela
        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        
        tabela = new JTable(modelo);
        painel.setViewportView(tabela); // Adiciona tabela no painel

        // Button click
        inserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionar();
            }
        });

        // Click na lista
        tabela.addMouseListener(new MouseAdapter() {
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
        String[] linha = {text, "(55) 9 9999-9999"};
        modelo.addRow(linha);
    }

    private void remover() {
        int linha = tabela.getSelectedRow();
        tabela.remove(linha);
    }

    public static void main(String[] args) {
        TabelaExemplo le = new TabelaExemplo();
        le.setVisible(true);
    }
}
