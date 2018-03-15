/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula300;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author tiagoseibel
 */
public class FormMaster extends JFrame {

    JButton btn = new JButton("OK");
    JDesktopPane desktop;

    public FormMaster() {
        init();
    }

    public void init() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(btn);

        desktop = new JDesktopPane();
        setContentPane(desktop);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    FormDetail f = new FormDetail();
                    f.setVisible(true);
                    desktop.add(f);
                    f.setSelected(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(FormMaster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        FormMaster p = new FormMaster();
        p.setVisible(true);
    }
}
