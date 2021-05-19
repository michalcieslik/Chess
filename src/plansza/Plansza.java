package plansza;

import figury.*;

public class Plansza {
    public Pole[][] plansza;
    private String[][] board;

    public Plansza() {
        this.plansza = new Pole[8][8];
        this.board = new String[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                plansza[i][j] = new Pole(new Pozycja(i, j), false);
        for (int i = 0; i < 8; i++) {  //ustawiamy figury i pionki
            this.plansza[i][1].setFigura(new Pion(new Pozycja(i, 1), 0));
            this.plansza[i][6].setFigura(new Pion(new Pozycja(i, 6), 1));
        } //cd
        this.plansza[2][0].setFigura(new Goniec(new Pozycja(2, 0), 0));
        this.plansza[5][0].setFigura(new Goniec(new Pozycja(5, 0), 0));
        this.plansza[2][7].setFigura(new Goniec(new Pozycja(2, 7), 1));
        this.plansza[5][7].setFigura(new Goniec(new Pozycja(5, 7), 1));
        this.plansza[0][0].setFigura(new Wieża(new Pozycja(0, 0), 0));
        this.plansza[7][0].setFigura(new Wieża(new Pozycja(7, 0), 0));
        this.plansza[0][7].setFigura(new Wieża(new Pozycja(0, 7), 1));
        this.plansza[7][7].setFigura(new Wieża(new Pozycja(7, 7), 1));
        this.plansza[1][0].setFigura(new Skoczek(new Pozycja(1, 0), 0));
        this.plansza[6][0].setFigura(new Skoczek(new Pozycja(6, 0), 0));
        this.plansza[1][7].setFigura(new Skoczek(new Pozycja(1, 7), 1));
        this.plansza[6][7].setFigura(new Skoczek(new Pozycja(6, 7), 1));
        this.plansza[3][0].setFigura(new Hetman(new Pozycja(3, 0), 0));
        this.plansza[4][0].setFigura(new Król(new Pozycja(4, 0), 0));
        this.plansza[3][7].setFigura(new Hetman(new Pozycja(3, 7), 1));
        this.plansza[4][7].setFigura(new Król(new Pozycja(4, 7), 1));


    }

    public void wypisz() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (plansza[j][i].getFigura() == null)
                    board[j][i] = "  ";
                else {
                    if (plansza[j][i].getFigura().getKolor() == 0) {
                        String typ = plansza[j][i].getFigura().getTyp_pionka();
                        switch (typ) {
                            case "W":
                                board[j][i] = "wW";
                                break;
                            case "S":
                                board[j][i] = "wS";
                                break;
                            case "G":
                                board[j][i] = "wG";
                                break;
                            case "H":
                                board[j][i] = "wH";
                                break;
                            case "K":
                                board[j][i] = "wK";
                                break;
                            case "P":
                                board[j][i] = "wP";
                                break;
                        }
                    }
                    if (plansza[j][i].getFigura().getKolor() == 1) {
                        String typ = plansza[j][i].getFigura().getTyp_pionka();
                        switch (typ) {
                            case "W":
                                board[j][i] = "bW";
                                break;
                            case "S":
                                board[j][i] = "bS";
                                break;
                            case "G":
                                board[j][i] = "bG";
                                break;
                            case "H":
                                board[j][i] = "bH";
                                break;
                            case "K":
                                board[j][i] = "bK";
                                break;
                            case "P":
                                board[j][i] = "bP";
                                break;
                        }
                    }
                }
                System.out.print(board[j][i] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("-----------------------" + "\n");
    }
}

