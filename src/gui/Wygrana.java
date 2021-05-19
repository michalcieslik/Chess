package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Wygrana extends JFrame{
    private JPanel KoniecGry;
    private JButton button_nowagra;
    private JButton wyjścieButton;
    private JLabel kto_wygral;

    Wygrana(int kolor) {
        setContentPane(KoniecGry);
        if (kolor == 1)
            kto_wygral.setText("CZARNY");
        else
            kto_wygral.setText("BIAŁY");
        button_nowagra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f = null;
                try {
                    f = new Szachownica();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                dispose();
            }
        });
        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
