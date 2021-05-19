//Marcin
package figury;


import plansza.Plansza;
import plansza.Pozycja;

public class Wieża extends Figura {
    private boolean pierwszyruch;

    public Wieża(Pozycja pozycja, int kolor) {
        super(pozycja, kolor, "W");
        this.pierwszyruch = true;
    }

    public boolean getPierwszyruch() {
        return pierwszyruch;
    }

    public void setPierwszyruch() {
        this.pierwszyruch = false;
    }

    public void ruchy(Plansza a, int x, int y) {
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
