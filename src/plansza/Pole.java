package plansza;

import figury.Figura;

public class Pole {
    private final Pozycja wsplorzedne;
    private boolean zajete;
    private Figura figura;

    public Pole(Pozycja pozycja, boolean czyzajete) {
        this.wsplorzedne = pozycja;
        this.zajete = czyzajete;
        this.figura = null;
    }

    public void setFigura(Figura fig) {
        this.figura = fig;
        this.zajete = true;
    }

    public Figura getFigura() {
        return figura;
    }

    public void zmienZajete() {
        if (zajete)
            this.zajete = false;
        else
            this.zajete = true;
    }

    public boolean getZajete() { return zajete;}

}
