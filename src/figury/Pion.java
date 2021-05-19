package figury;

import plansza.Plansza;
import plansza.Pozycja;

public class Pion extends Figura {
    private boolean pierwszyruch;

    public Pion(Pozycja pozycja, int kolor) {
        super(pozycja, kolor, "P");
        this.pierwszyruch = true;
    }

    public boolean getPierwszyruch() {
        return pierwszyruch;
    }

    public void setPierwszyruch() {
        this.pierwszyruch = false;
    }

    public void ruchy(Plansza a, int x, int y) {
        if (a.plansza[x][y].getFigura().getKolor() == 0 && y < 7 && !a.plansza[x][y + 1].getZajete()) {
            a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(x, (y + 1)));
            if (a.plansza[x][y].getFigura().getPierwszyruch() && !a.plansza[x][y + 2].getZajete()) {
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(x, (y + 2)));
            }
        }
        if (a.plansza[x][y].getFigura().getKolor() == 0 && x == 0 && a.plansza[x + 1][y + 1].getZajete())
            if (a.plansza[x + 1][y + 1].getFigura().getKolor() == 1)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x + 1), (y + 1)));
        if (a.plansza[x][y].getFigura().getKolor() == 0 && x == 7 && a.plansza[x - 1][y + 1].getZajete())
            if (a.plansza[x - 1][y + 1].getFigura().getKolor() == 1)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x - 1), (y + 1)));
        if (a.plansza[x][y].getFigura().getKolor() == 0 && 0 < x && x < 7 && a.plansza[x + 1][y + 1].getZajete())
            if (a.plansza[x + 1][y + 1].getFigura().getKolor() == 1)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x + 1), (y + 1)));
        if (a.plansza[x][y].getFigura().getKolor() == 0 && 0 < x && x < 7 && a.plansza[x - 1][y + 1].getZajete())
            if (a.plansza[x - 1][y + 1].getFigura().getKolor() == 1)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x - 1), (y + 1)));

        if (a.plansza[x][y].getFigura().getKolor() == 1 && y > 0 && !a.plansza[x][y - 1].getZajete()) {
            a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(x, (y - 1)));
            if (a.plansza[x][y].getFigura().getPierwszyruch() && !a.plansza[x][y - 2].getZajete()) {
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja(x, (y - 2)));
            }
        }
        if (a.plansza[x][y].getFigura().getKolor() == 1 && x == 0 && a.plansza[x + 1][y - 1].getZajete())
            if (a.plansza[x + 1][y - 1].getFigura().getKolor() == 0)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x + 1), (y - 1)));
        if (a.plansza[x][y].getFigura().getKolor() == 1 && x == 7 && a.plansza[x - 1][y - 1].getZajete())
            if (a.plansza[x - 1][y - 1].getFigura().getKolor() == 0)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x - 1), (y - 1)));
        if (a.plansza[x][y].getFigura().getKolor() == 1 && 0 < x && x < 7 && a.plansza[x + 1][y - 1].getZajete())
            if (a.plansza[x + 1][y - 1].getFigura().getKolor() == 0)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x + 1), (y - 1)));
        if (a.plansza[x][y].getFigura().getKolor() == 1 && 0 < x && x < 7 && a.plansza[x - 1][y - 1].getZajete())
            if (a.plansza[x - 1][y - 1].getFigura().getKolor() == 0)
                a.plansza[x][y].getFigura().getWszystkie_ruchy().add(new Pozycja((x - 1), (y - 1)));
    }
}
