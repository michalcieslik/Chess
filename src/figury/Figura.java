//Marcin
package figury;

import plansza.Plansza;
import plansza.Pozycja;

import java.util.ArrayList;

public class Figura {
    private Pozycja pozycja;
    private String typ_pionka;
    private int kolor; // 1 -> czarny, 0 -> biały
    private ArrayList<Pozycja> wszystkie_ruchy = new ArrayList<>();


    public Figura(Pozycja pozycja, int kolor, String typ_pionka){
        this.pozycja = pozycja;
        this.kolor = kolor;
        this.typ_pionka = typ_pionka;
    }

    public void ruchy(Plansza a, int x, int y) {

    };

    public Pozycja getPozycja() {
        return pozycja;
    }

    public ArrayList<Pozycja> getWszystkie_ruchy() {
        return (ArrayList<Pozycja>) wszystkie_ruchy;
    }

    public int getKolor() {
        return kolor;
    }
    public void czysc_wszystkie_ruchy(){
        wszystkie_ruchy.clear();
    }
    public void setPozycja(Pozycja pozycja) {
        this.pozycja = pozycja;
    }
    public String getTyp_pionka(){return typ_pionka;}
    public boolean getPierwszyruch() { return true;}
    public void setPierwszyruch() {}

}
