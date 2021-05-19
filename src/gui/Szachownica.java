package gui;

import gra.Gra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Szachownica extends JFrame {
    private JPanel szachownica;
    private JButton button00;
    private JButton button03;
    private JButton button10;
    private JButton button20;
    private JButton button30;
    private JButton button40;
    private JButton button50;
    private JButton button60;
    private JButton button70;
    private JButton button01;
    private JButton button11;
    private JButton button21;
    private JButton button31;
    private JButton button41;
    private JButton button51;
    private JButton button61;
    private JButton button71;
    private JButton button02;
    private JButton button12;
    private JButton button22;
    private JButton button32;
    private JButton button42;
    private JButton button52;
    private JButton button62;
    private JButton button72;
    private JButton button73;
    private JButton button63;
    private JButton button53;
    private JButton button43;
    private JButton button33;
    private JButton button23;
    private JButton button13;
    private JButton button04;
    private JButton button14;
    private JButton button24;
    private JButton button34;
    private JButton button44;
    private JButton button54;
    private JButton button64;
    private JButton button74;
    private JButton button75;
    private JButton button65;
    private JButton button55;
    private JButton button45;
    private JButton button35;
    private JButton button25;
    private JButton button15;
    private JButton button05;
    private JButton button06;
    private JButton button16;
    private JButton button26;
    private JButton button36;
    private JButton button46;
    private JButton button56;
    private JButton button66;
    private JButton button76;
    private JButton button77;
    private JButton button67;
    private JButton button57;
    private JButton button47;
    private JButton button37;
    private JButton button27;
    private JButton button17;
    private JButton button07;
    private JButton temp;

    private Gra gra = new Gra();

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int tura_gracza = gra.getGracz_biały();  // 0 -> biały, 1 -> czarny

    private boolean pierwszy_klik = true;

    public void ruch(int x1, int y1, Gra gra, JButton jButton) {
        if (pierwszy_klik) {
            if (gra.getSzachownica().plansza[x1][y1].getZajete()) {
                this.x1 = x1;
                this.y1 = y1;
                temp = jButton;
                pierwszy_klik = false;
            }
        } else {
            this.x2 = x1;
            this.y2 = y1;
            String txt = jaka_figura();
            if (gra.roszada(tura_gracza, this.x1, this.y1, this.x2, this.y2)){
                if (x2 == 6 && y2 == 0){
                    button40.setIcon(null);
                    button50.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\wieza_b.png"));
                    button60.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\krol_b.png"));
                    button70.setIcon(null);
                }
                if (x2 == 2 && y2 == 0){
                    button40.setIcon(null);
                    button30.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\wieza_b.png"));
                    button20.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\krol_b.png"));
                    button10.setIcon(null);
                    button00.setIcon(null);
                }
                if (x2 == 6 && y2 == 7){
                    button47.setIcon(null);
                    button57.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\wieza_cz.png"));
                    button67.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\krol_cz.png"));
                    button77.setIcon(null);
                }
                if (x2 == 2 && y2 == 7){
                    button47.setIcon(null);
                    button37.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\wieza_cz.png"));
                    button27.setIcon(new ImageIcon("E:\\intelij\\szachy\\src\\plansza\\krol_cz.png"));
                    button17.setIcon(null);
                    button07.setIcon(null);
                }
                if (tura_gracza == 0) {
                    szach_mat_detector(tura_gracza);
                    tura_gracza = gra.getGracz_czarny();
                } else {
                    szach_mat_detector(tura_gracza);
                    tura_gracza = gra.getGracz_biały();
                }
                pierwszy_klik = true;
            }else
                gra.ruch(tura_gracza, this.x1, this.y1, this.x2, this.y2);
            if (gra.isRuch_done()) {
                if (gra.czypromocja()) {
                    gra.promocja();
                    if (tura_gracza == 0)
                        txt = "E:\\intelij\\szachy\\src\\plansza\\hetman_b.png";
                    else
                        txt = "E:\\intelij\\szachy\\src\\plansza\\hetman_cz.png";
                }
                temp.setIcon(null);
                jButton.setIcon(new ImageIcon(txt));
                //jButton.setIcon(new ImageIcon("C:\\Users\\marci\\IdeaProjects\\po2020\\Chess\\src\\plansza\\goniec_b.png"));
                if (tura_gracza == 0) {
                    szach_mat_detector(tura_gracza);
                    tura_gracza = gra.getGracz_czarny();
                } else {
                    szach_mat_detector(tura_gracza);
                    tura_gracza = gra.getGracz_biały();
                }
                pierwszy_klik = true;
            } else
                pierwszy_klik = true;
        }
    }

    public String jaka_figura() {
        if (gra.getSzachownica().plansza[x1][y1].getFigura() != null) {
            String figura_typ = gra.getSzachownica().plansza[x1][y1].getFigura().getTyp_pionka();
            String kolor = "";
            if (gra.getSzachownica().plansza[x1][y1].getFigura().getKolor() == 0)
                kolor = "_b";
            else
                kolor = "_cz";
            if(kolor.equals("_b")) {
                switch (figura_typ) {
                    case "P":
                        return "E:\\intelij\\szachy\\src\\plansza\\pion_b.png";
                    case "K":
                        return "E:\\intelij\\szachy\\src\\plansza\\krol_b.png";
                    case "H":
                        return "E:\\intelij\\szachy\\src\\plansza\\hetman_b.png";
                    case "G":
                        return "E:\\intelij\\szachy\\src\\plansza\\goniec_b.png";
                    case "W":
                        return "E:\\intelij\\szachy\\src\\plansza\\wieza_b.png";
                    case "S":
                        return "E:\\intelij\\szachy\\src\\plansza\\kon_b.png";
                }
            }else
                switch (figura_typ) {
                    case "P":
                        return "E:\\intelij\\szachy\\src\\plansza\\pion_cz.png";
                    case "K":
                        return "E:\\intelij\\szachy\\src\\plansza\\krol_cz.png";
                    case "H":
                        return "E:\\intelij\\szachy\\src\\plansza\\hetman_cz.png";
                    case "G":
                        return "E:\\intelij\\szachy\\src\\plansza\\goniec_cz.png";
                    case "W":
                        return "E:\\intelij\\szachy\\src\\plansza\\wieza_cz.png";
                    case "S":
                        return "E:\\intelij\\szachy\\src\\plansza\\kon_cz.png";
                }
        }
        return null;
    }

    public void szach_mat_detector(int tura_gracza) {
        if (tura_gracza == 0) {
            if (gra.szachmat(gra, 1)) {
                JFrame f = new Wygrana(0);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        } else {
            if (gra.szachmat(gra, 0)) {
                JFrame f = new Wygrana(1);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        }


    }

    public Szachownica() throws IOException {
        setContentPane(szachownica);
        //Przyciski - kolumna 0
        button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 0, gra, button00);
            }
        });
        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 1, gra, button01);
            }
        });
        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 2, gra, button02);
            }
        });
        button03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 3, gra, button03);
            }
        });
        button04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 4, gra, button04);
            }
        });
        button05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 5, gra, button05);
            }
        });
        button06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 6, gra, button06);
            }
        });
        button07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(0, 7, gra, button07);
            }
        });
        ///////////////////////////////////////////////////
        //Przyciski - kolumna 1

        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 0, gra, button10);
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 1, gra, button11);
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 2, gra, button12);
            }
        });
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 3, gra, button13);
            }
        });
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 4, gra, button14);
            }
        });
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 5, gra, button15);
            }
        });
        button16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 6, gra, button16);
            }
        });
        button17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(1, 7, gra, button17);
            }
        });
        /////////////////////////////////////////////////////
        //Przyciski kolumna - 2
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 0, gra, button20);
            }
        });
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 1, gra, button21);
            }
        });
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 2, gra, button22);
            }
        });
        button23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 3, gra, button23);
            }
        });
        button24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 4, gra, button24);
            }
        });
        button25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 5, gra, button25);
            }
        });
        button26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 6, gra, button26);
            }
        });
        button27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(2, 7, gra, button27);
            }
        });
        /////////////////////////////////////////////////////
        //Przyciski kolumna - 3

        button30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 0, gra, button30);
            }
        });
        button31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 1, gra, button31);
            }
        });
        button32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 2, gra, button32);
            }
        });
        button33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 3, gra, button33);
            }
        });
        button34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 4, gra, button34);
            }
        });
        button35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 5, gra, button35);
            }
        });
        button36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 6, gra, button36);
            }
        });
        button37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(3, 7, gra, button37);
            }
        });
        /////////////////////////////////////////////////////
        //Przyciski kolumna - 4

        button40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 0, gra, button40);
            }
        });
        button41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 1, gra, button41);
            }
        });
        button42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 2, gra, button42);
            }
        });
        button43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 3, gra, button43);
            }
        });
        button44.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 4, gra, button44);
            }
        });
        button45.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 5, gra, button45);
            }
        });
        button46.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 6, gra, button46);
            }
        });
        button47.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(4, 7, gra, button47);
            }
        });
        /////////////////////////////////////////////////////
        //Przyciski kolumna - 5

        button50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 0, gra, button50);
            }
        });
        button51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 1, gra, button51);
            }
        });
        button52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 2, gra, button52);
            }
        });
        button53.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 3, gra, button53);
            }
        });
        button54.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 4, gra, button54);
            }
        });
        button55.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 5, gra, button55);
            }
        });
        button56.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 6, gra, button56);
            }
        });
        button57.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(5, 7, gra, button57);
            }
        });
        /////////////////////////////////////////////////////
        //Przyciski kolumna - 6

        button60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 0, gra, button60);
            }
        });
        button61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 1, gra, button61);
            }
        });
        button62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 2, gra, button62);
            }
        });
        button63.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 3, gra, button63);
            }
        });
        button64.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 4, gra, button64);
            }
        });
        button65.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 5, gra, button65);
            }
        });
        button66.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 6, gra, button66);
            }
        });
        button67.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(6, 7, gra, button67);
            }
        });
        /////////////////////////////////////////////////////
        //Przyciski kolumna - 7

        button70.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 0, gra, button70);
            }
        });
        button71.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 1, gra, button71);
            }
        });
        button72.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 2, gra, button72);
            }
        });
        button73.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 3, gra, button73);
            }
        });
        button74.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 4, gra, button74);
            }
        });
        button75.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 5, gra, button75);
            }
        });
        button76.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 6, gra, button76);
            }
        });
        button77.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruch(7, 7, gra, button77);
            }
        });
    }
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Szachy");
        frame.setContentPane(new Szachownica().szachownica);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(881, 866);
        frame.setResizable(false);
    }
}
