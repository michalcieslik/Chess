//Marcin
package figury;

import plansza.Plansza;
import plansza.Pozycja;

public class Skoczek extends Figura {

    public Skoczek(Pozycja pozycja, int kolor) {
        super(pozycja, kolor, "S");
    }

    public void ruchy(Plansza a, int x, int y) {
        if (x + 1 < 8 && y + 2 < 8)
            if (!a.plansza[x + 1][y + 2].getZajete() || a.plansza[x + 1][y + 2].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x + 1, y + 2));
        if (x - 1 >= 0 && y + 2 < 8)
            if (!a.plansza[x - 1][y + 2].getZajete() || a.plansza[x - 1][y + 2].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x - 1, y + 2));
        if (x - 2 >= 0 && y + 1 < 8)
            if (!a.plansza[x - 2][y + 1].getZajete() || a.plansza[x - 2][y + 1].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x - 2, y + 1));
        if (x + 2 < 8 && y + 1 < 8)
            if (!a.plansza[x + 2][y + 1].getZajete() || a.plansza[x + 2][y + 1].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x + 2, y + 1));
        if (x - 2 >= 0 && y - 1 >= 0)
            if (!a.plansza[x - 2][y - 1].getZajete() || a.plansza[x - 2][y - 1].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x - 2, y - 1));
        if (x - 1 >= 0 && y - 2 >= 0)
            if (!a.plansza[x - 1][y - 2].getZajete() || a.plansza[x - 1][y - 2].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x - 1, y - 2));
        if (x + 1 < 8 && y - 2 >= 0)
            if (!a.plansza[x + 1][y - 2].getZajete() || a.plansza[x + 1][y - 2].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x + 1, y - 2));
        if (x + 2 < 8 && y - 1 >= 0)
            if (!a.plansza[x + 2][y - 1].getZajete() || a.plansza[x + 2][y - 1].getFigura().getKolor() != getKolor())
                getWszystkie_ruchy().add(new Pozycja(x + 2, y - 1));
    }

}
