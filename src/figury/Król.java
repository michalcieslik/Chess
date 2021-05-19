package figury;

import plansza.Plansza;
import plansza.Pozycja;

public class Król extends Figura {
    private boolean pierwszyruch;

    public Król(Pozycja pozycja, int kolor) {
        super(pozycja, kolor, "K");
        this.pierwszyruch = true;
    }

    public boolean getPierwszyruch() {
        return pierwszyruch;
    }

    public void setPierwszyruch() {
        this.pierwszyruch = false;
    }

    public void ruchy(Plansza a, int x, int y) {
        if (x != 0 && y != 0 && x != 7 && y != 7) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
                }
            }
            // Wychodzimy od dołu
        } else if (y == 0 && x != 0 && x != 7) {
            for (int i = x - 1; i <= x + 1; i++)
                for (int j = 0; j <= 1; j++)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
            // Wychodzimy od góry
        } else if (y == 7 && x != 0 && x != 7) {
            for (int i = x - 1; i <= x + 1; i++)
                for (int j = 7; j >= 6; j--)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
            // Wychodzimy od lewej
        } else if (x == 0 && y != 0 && y != 7) {
            for (int i = 0; i <= 1; i++)
                for (int j = y + 1; j >= y - 1; j--)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
            //Wychodzimy od prawej
        } else if (x == 7 && y != 0 && y != 7) {
            for (int i = 6; i <= 7; i++)
                for (int j = y - 1; j <= y + 1; j++)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
            //Warunki brzegowe
        } else if (x == 0 && y == 0) {
            for (int i = 0; i <= 1; i++)
                for (int j = 0; j <= 1; j++)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
        } else if (x == 7 && y == 0) {
            for (int i = 6; i <= 7; i++)
                for (int j = 0; j <= 1; j++)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
        } else if (x == 0) {
            for (int i = 0; i <= 1; i++)
                for (int j = 6; j <= 7; j++)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
        } else {
            for (int i = 6; i <= 7; i++)
                for (int j = 6; j <= 7; j++)
                    if (!a.plansza[i][j].getZajete() || a.plansza[i][j].getFigura().getKolor() != getKolor())
                        getWszystkie_ruchy().add(new Pozycja(i, j));
        }
    }
}

