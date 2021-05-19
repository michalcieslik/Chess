package figury;

import plansza.Plansza;
import plansza.Pozycja;

public class Hetman extends Figura {

    public Hetman(Pozycja pozycja, int kolor) {
        super(pozycja, kolor, "H");
    }

    public void ruchy(Plansza a, int x, int y) {
        int mojkolor = a.plansza[x][y].getFigura().getKolor();
        Pozycja mozliwe = new Pozycja(x, y);
        for (int i = 1; x + i <= 7 && y + i <= 7; i++) {     //skos po prawej gora
            mozliwe.setX(mozliwe.getX() + 1);
            mozliwe.setY(mozliwe.getY() + 1);
            if (a.plansza[mozliwe.getX()][mozliwe.getY()].getZajete()) {
                if (a.plansza[mozliwe.getX()][mozliwe.getY()].getFigura().getKolor() == mojkolor)
                    break;
                else {
                    a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
                    break;
                }
            }
            a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
        }
        mozliwe.setX(x);
        mozliwe.setY(y);
        for (int i = 1; x - i >= 0 && y + i <= 7; i++) {     //skos po lewej gora
            mozliwe.setX(mozliwe.getX() - 1);
            mozliwe.setY(mozliwe.getY() + 1);
            if (a.plansza[mozliwe.getX()][mozliwe.getY()].getZajete()) {
                if (a.plansza[mozliwe.getX()][mozliwe.getY()].getFigura().getKolor() == mojkolor)
                    break;
                else {
                    a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
                    break;
                }
            }
            a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
        }
        mozliwe.setX(x);
        mozliwe.setY(y);
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {     //skos po lewej dol
            mozliwe.setX(mozliwe.getX() - 1);
            mozliwe.setY(mozliwe.getY() - 1);
            if (a.plansza[mozliwe.getX()][mozliwe.getY()].getZajete()) {
                if (a.plansza[mozliwe.getX()][mozliwe.getY()].getFigura().getKolor() == mojkolor)
                    break;
                else {
                    a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
                    break;
                }
            }
            a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
        }
        mozliwe.setX(x);
        mozliwe.setY(y);
        for (int i = 1; x + i <= 7 && y - i >= 0; i++) {     //skos po prawej dol
            mozliwe.setX(mozliwe.getX() + 1);
            mozliwe.setY(mozliwe.getY() - 1);
            if (a.plansza[mozliwe.getX()][mozliwe.getY()].getZajete()) {
                if (a.plansza[mozliwe.getX()][mozliwe.getY()].getFigura().getKolor() == mojkolor)
                    break;
                else {
                    a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
                    break;
                }
            }
            a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(mozliwe.getX(), mozliwe.getY()));
        }
        for (int i = y - 1; i >= 0; i--) { //ruchy w dół
            if (a.plansza[x][i].getZajete()) {
                if (a.plansza[x][i].getFigura().getKolor() != getKolor()) {
                    getWszystkie_ruchy().add(new Pozycja(x, i));
                    break;
                } else
                    break;
            }
            getWszystkie_ruchy().add(new Pozycja(x, i));
        }

        for (int i = y + 1; i < 8; i++) { //ruchy w góre
            if (a.plansza[x][i].getZajete()) {
                if (a.plansza[x][i].getFigura().getKolor() != getKolor()) {
                    getWszystkie_ruchy().add(new Pozycja(x, i));
                    break;
                }else
                    break;
            }
            getWszystkie_ruchy().add(new Pozycja(x, i));
        }

        for (int i = x - 1; i >= 0; i--) { //ruchy w lewo
            if (a.plansza[i][y].getZajete()) {
                if (a.plansza[i][y].getFigura().getKolor() != getKolor()) {
                    getWszystkie_ruchy().add(new Pozycja(i, y));
                    break;
                }else
                    break;
            }
            getWszystkie_ruchy().add(new Pozycja(i, y));
        }

        for (int i = x + 1; i < 8; i++) { //ruchy w prawo
            if (a.plansza[i][y].getZajete()) {
                if (a.plansza[i][y].getFigura().getKolor() != getKolor()) {
                    getWszystkie_ruchy().add(new Pozycja(i, y));
                    break;
                } else
                    break;
            }
            getWszystkie_ruchy().add(new Pozycja(i, y));
        }
    }
}
