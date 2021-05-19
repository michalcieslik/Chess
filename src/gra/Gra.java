package gra;

import figury.Figura;
import figury.Hetman;
import figury.Król;
import figury.Wieża;
import plansza.Plansza;
import plansza.Pozycja;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gra {
    private Plansza szachownica;
    private int gracz_biały;
    private int gracz_czarny;
    private boolean ruch_done;
    protected final Logger log = Logger.getLogger("SzachyLog");
    private FileHandler fileHandler = new FileHandler("szachy.log", true);



    public Gra() throws IOException {
        szachownica = new Plansza();
        gracz_czarny = 1;
        gracz_biały = 0;
        log.addHandler(fileHandler);
    }

    public Plansza getSzachownica() {
        return szachownica;
    }

    public boolean szach(int kol) {
        Pozycja pozkrol = new Pozycja(-1, -1);   //szukam krola
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (szachownica.plansza[j][i].getZajete()) {
                    if (szachownica.plansza[j][i].getFigura().getTyp_pionka().equals("K") && szachownica.plansza[j][i].getFigura().getKolor() == kol) {
                        pozkrol.setX(j);
                        pozkrol.setY(i);
                        break;
                    }
                }
            }
            if (pozkrol.getX() != -1)
                break;
        }
        //sprawdzam czy cos go atakuje przechodze po figurach i patrze czy w ich mzoliwych ruchach jest ruch na pozycje krola jesli tak jest szach

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (szachownica.plansza[j][i].getZajete()) {
                    if (szachownica.plansza[j][i].getFigura().getKolor() != kol) {
                        szachownica.plansza[j][i].getFigura().czysc_wszystkie_ruchy();
                        szachownica.plansza[j][i].getFigura().ruchy(szachownica, j, i);
                        for (int k = 0; k < szachownica.plansza[j][i].getFigura().getWszystkie_ruchy().size(); k++) {
                            if (szachownica.plansza[j][i].getFigura().getWszystkie_ruchy().get(k).getX() == pozkrol.getX() && szachownica.plansza[j][i].getFigura().getWszystkie_ruchy().get(k).getY() == pozkrol.getY()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean czypromocja() {
        for (int i = 0; i < 8; i++) {
            if (szachownica.plansza[i][0].getZajete()) {
                if (szachownica.plansza[i][0].getFigura().getTyp_pionka().equals("P")) {
                    return true;
                }
            }
            if (szachownica.plansza[i][7].getZajete()) {
                if (szachownica.plansza[i][7].getFigura().getTyp_pionka().equals("P")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void promocja() {
        for (int i = 0; i < 8; i++) {
            if (szachownica.plansza[i][0].getZajete()) {
                if (szachownica.plansza[i][0].getFigura().getTyp_pionka().equals("P")) {
                    szachownica.plansza[i][0].setFigura(new Hetman(new Pozycja(i, 0), 1));
                }
            }
            if (szachownica.plansza[i][7].getZajete()) {
                if (szachownica.plansza[i][7].getFigura().getTyp_pionka().equals("P")) {
                    szachownica.plansza[i][7].setFigura(new Hetman(new Pozycja(i, 7), 0));
                }
            }
        }
    }

    public boolean szachmat(Gra gra, int kol) {
        Pozycja pozkrol = new Pozycja(-1, -1);   //szukam krola
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (szachownica.plansza[j][i].getZajete()) {
                    if (szachownica.plansza[j][i].getFigura().getTyp_pionka().equals("K") && szachownica.plansza[j][i].getFigura().getKolor() == kol) {
                        pozkrol.setX(j);
                        pozkrol.setY(i);
                        break;
                    }
                }
            }
            if (pozkrol.getX() != -1)
                break;
        }
        boolean czycosjest;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (szachownica.plansza[j][i].getZajete()) {
                    if (szachownica.plansza[j][i].getFigura().getKolor() == kol) {
                        szachownica.plansza[j][i].getFigura().czysc_wszystkie_ruchy();
                        szachownica.plansza[j][i].getFigura().ruchy(szachownica, j, i);
                        for (int k = 0; k < szachownica.plansza[j][i].getFigura().getWszystkie_ruchy().size(); k++) {
                            Pozycja gdzie = szachownica.plansza[j][i].getFigura().getWszystkie_ruchy().get(k);
                            czycosjest = szachownica.plansza[gdzie.getX()][gdzie.getY()].getZajete();
                            szachownica.plansza[j][i].getFigura().czysc_wszystkie_ruchy();
                            Figura temp = szachownica.plansza[j][i].getFigura();
                            Figura zbita = szachownica.plansza[j][i].getFigura();
                            temp.setPozycja(new Pozycja(gdzie.getX(), gdzie.getY()));
                            if (czycosjest) {
                                zbita = szachownica.plansza[gdzie.getX()][gdzie.getY()].getFigura();
                            }
                            szachownica.plansza[j][i].setFigura(null);
                            szachownica.plansza[j][i].zmienZajete();
                            szachownica.plansza[gdzie.getX()][gdzie.getY()].setFigura(temp);
                            if (!gra.szach(kol)) {
                                szachownica.plansza[gdzie.getX()][gdzie.getY()].getFigura().czysc_wszystkie_ruchy();
                                Figura tempo = szachownica.plansza[gdzie.getX()][gdzie.getY()].getFigura();
                                tempo.setPozycja(new Pozycja(j, i));
                                szachownica.plansza[gdzie.getX()][gdzie.getY()].setFigura(null);
                                szachownica.plansza[gdzie.getX()][gdzie.getY()].zmienZajete();
                                szachownica.plansza[j][i].setFigura(tempo);
                                if (czycosjest){
                                    szachownica.plansza[gdzie.getX()][gdzie.getY()].setFigura(zbita);
                                }
                                szachownica.plansza[j][i].getFigura().ruchy(szachownica, j, i);

                                return false;
                            }
                            szachownica.plansza[gdzie.getX()][gdzie.getY()].getFigura().czysc_wszystkie_ruchy();
                            Figura tempo = szachownica.plansza[gdzie.getX()][gdzie.getY()].getFigura();
                            tempo.setPozycja(new Pozycja(j, i));
                            szachownica.plansza[gdzie.getX()][gdzie.getY()].setFigura(null);
                            szachownica.plansza[gdzie.getX()][gdzie.getY()].zmienZajete();
                            szachownica.plansza[j][i].setFigura(tempo);
                            if(czycosjest){
                                szachownica.plansza[gdzie.getX()][gdzie.getY()].setFigura(zbita);
                            }
                            szachownica.plansza[j][i].getFigura().ruchy(szachownica, j, i);

                        }
                    }
                }
            }
        }
        return true;
    }


    public boolean isRuch_done() {
        return ruch_done;
    }

    public int getGracz_biały() {
        return gracz_biały;
    }

    public int getGracz_czarny() {
        return gracz_czarny;
    }

    public void ruch(int kolor_gracza, int x_1, int y_1, int x_2, int y_2) {
        ruch_done = false;
        if (szachownica.plansza[x_1][y_1].getFigura().getKolor() != kolor_gracza) { // czy gracz nie próbuje ruszyć pustego pola lub figure nie swojego koloru
            System.out.println("Nie twoja figura!");
            log.log(Level.INFO, "Gracz wybrał figure nie swojego koloru");
        } else {
            szachownica.plansza[x_1][y_1].getFigura().ruchy(szachownica, x_1, y_1);
            //Jesli poruszamy pione to sprawdzmy czy jest to jego pierwszy ruch jesli tak to zmienmy na false
            if (szachownica.plansza[x_1][y_1].getFigura().getTyp_pionka().equals("P"))
                if (szachownica.plansza[x_1][y_1].getFigura().getPierwszyruch())
                    szachownica.plansza[x_1][y_1].getFigura().setPierwszyruch();
            //sprawdzamy czy podany ruch jest dostępny z puli wszystkich ruchów danej figury
            for (int i = 0; i < szachownica.plansza[x_1][y_1].getFigura().getWszystkie_ruchy().size(); i++) {
                //pobieramy wspolrzedna x ruchu zpod danego indeksu
                int x = szachownica.plansza[x_1][y_1].getFigura().getWszystkie_ruchy().get(i).getX();
                //wspilrzedna y
                int y = szachownica.plansza[x_1][y_1].getFigura().getWszystkie_ruchy().get(i).getY();
                // jesli planowany ruch jest mozliwy
                if (x == x_2 && y == y_2) {
                    if (szachownica.plansza[x][y].getZajete()) {
                        szachownica.plansza[x_1][y_1].getFigura().czysc_wszystkie_ruchy();
                        Figura zbita = szachownica.plansza[x_2][y_2].getFigura();
                        Figura temp = szachownica.plansza[x_1][y_1].getFigura();
                        temp.setPozycja(new Pozycja(x_2, y_2));
                        szachownica.plansza[x_1][y_1].setFigura(null);
                        szachownica.plansza[x_1][y_1].zmienZajete();
                        szachownica.plansza[x_2][y_2].setFigura(temp);
                        //jesli przesuniecie tej figury sprawia ze gracz dalej jest szachowany -> cofnij ruch
                        if (szach(kolor_gracza)) {
                            szachownica.plansza[x_2][y_2].getFigura().czysc_wszystkie_ruchy();
                            Figura tempp = szachownica.plansza[x_2][y_2].getFigura();
                            tempp.setPozycja(new Pozycja(x_1, y_1));
                            szachownica.plansza[x_2][y_2].setFigura(null);
                            szachownica.plansza[x_2][y_2].zmienZajete();
                            szachownica.plansza[x_1][y_1].setFigura(tempp);
                            szachownica.plansza[x_2][y_2].setFigura(zbita);
                            ruch_done = false;
                            log.log(Level.INFO, "Gracz próbuje ruszyć figurę, która nie pozwala mu uciec od szacha");
                            return;
                        } else {
                            ruch_done = true;
                            break;
                        }
                    } else {
                        szachownica.plansza[x_1][y_1].getFigura().czysc_wszystkie_ruchy();
                        Figura temp = szachownica.plansza[x_1][y_1].getFigura();
                        temp.setPozycja(new Pozycja(x_2, y_2));
                        szachownica.plansza[x_1][y_1].setFigura(null);
                        szachownica.plansza[x_1][y_1].zmienZajete();
                        szachownica.plansza[x_2][y_2].setFigura(temp);
                        //tak samo jak wyzej
                        if (szach(kolor_gracza)) {
                            szachownica.plansza[x_2][y_2].getFigura().czysc_wszystkie_ruchy();
                            Figura tempp = szachownica.plansza[x_2][y_2].getFigura();
                            tempp.setPozycja(new Pozycja(x_1, y_1));
                            szachownica.plansza[x_2][y_2].setFigura(null);
                            szachownica.plansza[x_2][y_2].zmienZajete();
                            szachownica.plansza[x_1][y_1].setFigura(tempp);
                            ruch_done = false;
                            log.log(Level.INFO, "Gracz próbuje ruszyć figurę, która nie pozwala mu uciec od szacha");
                            return;
                        } else {
                            ruch_done = true;
                            break;
                        }
                    }
                }
            }
            if (!ruch_done) {
                System.out.println("Błąd wykonaj poprawny ruch!");
                ruch_done = false;
                log.log(Level.INFO, "Gracz próbuje ruszyć figurę na pozycję której nie może ona osiągnąć");
            }
            //wypisujemy terminalowa wersje
            szachownica.wypisz();
        }
    }

    public boolean roszada(int kolor_gracza, int x_1, int y_1, int x_2, int y_2) {
        if (kolor_gracza == 0){
            if (x_1 == 4 && y_1 == 0 && x_2 == 6 && y_2 == 0){
                if (szachownica.plansza[x_1][y_1].getFigura().getTyp_pionka().equals("K") && szachownica.plansza[x_1][y_1].getFigura().getPierwszyruch()){
                    if (szachownica.plansza[7][0].getZajete()){
                        if (szachownica.plansza[7][0].getFigura().getTyp_pionka().equals("W")){
                            if (szachownica.plansza[7][0].getFigura().getPierwszyruch()){
                                if (!szachownica.plansza[5][0].getZajete() && !szachownica.plansza[6][0].getZajete()){
                                    szachownica.plansza[x_1][y_1].setFigura(null);
                                    szachownica.plansza[x_1][y_1].zmienZajete();
                                    szachownica.plansza[7][0].setFigura(null);
                                    szachownica.plansza[7][0].zmienZajete();
                                    szachownica.plansza[6][0].setFigura(new Król(new Pozycja(6,0),0));
                                    szachownica.plansza[5][0].setFigura(new Wieża(new Pozycja(5,0),0));
                                    ruch_done = false;
                                    szachownica.wypisz();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (kolor_gracza == 0){
            if (x_1 == 4 && y_1 == 0 && x_2 == 2 && y_2 == 0){
                if (szachownica.plansza[x_1][y_1].getFigura().getTyp_pionka().equals("K") && szachownica.plansza[x_1][y_1].getFigura().getPierwszyruch()){
                    if (szachownica.plansza[0][0].getZajete()){
                        if (szachownica.plansza[0][0].getFigura().getTyp_pionka().equals("W")){
                            if (szachownica.plansza[0][0].getFigura().getPierwszyruch()){
                                if (!szachownica.plansza[3][0].getZajete() && !szachownica.plansza[2][0].getZajete() && !szachownica.plansza[1][0].getZajete()){
                                    szachownica.plansza[x_1][y_1].setFigura(null);
                                    szachownica.plansza[x_1][y_1].zmienZajete();
                                    szachownica.plansza[0][0].setFigura(null);
                                    szachownica.plansza[0][0].zmienZajete();
                                    szachownica.plansza[2][0].setFigura(new Król(new Pozycja(2,0),0));
                                    szachownica.plansza[3][0].setFigura(new Wieża(new Pozycja(3,0),0));
                                    ruch_done = false;
                                    szachownica.wypisz();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (kolor_gracza == 1){
            if (x_1 == 4 && y_1 == 7 && x_2 == 6 && y_2 == 7){
                if (szachownica.plansza[x_1][y_1].getFigura().getTyp_pionka().equals("K") && szachownica.plansza[x_1][y_1].getFigura().getPierwszyruch()){
                    if (szachownica.plansza[7][7].getZajete()){
                        if (szachownica.plansza[7][7].getFigura().getTyp_pionka().equals("W")){
                            if (szachownica.plansza[7][7].getFigura().getPierwszyruch()){
                                if (!szachownica.plansza[5][7].getZajete() && !szachownica.plansza[6][7].getZajete()){
                                    szachownica.plansza[x_1][y_1].setFigura(null);
                                    szachownica.plansza[x_1][y_1].zmienZajete();
                                    szachownica.plansza[7][7].setFigura(null);
                                    szachownica.plansza[7][7].zmienZajete();
                                    szachownica.plansza[6][7].setFigura(new Król(new Pozycja(6,7),1));
                                    szachownica.plansza[5][7].setFigura(new Wieża(new Pozycja(5,7),1));
                                    ruch_done = false;
                                    szachownica.wypisz();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (kolor_gracza == 1){
            if (x_1 == 4 && y_1 == 7 && x_2 == 2 && y_2 == 7){
                if (szachownica.plansza[x_1][y_1].getFigura().getTyp_pionka().equals("K") && szachownica.plansza[x_1][y_1].getFigura().getPierwszyruch()){
                    if (szachownica.plansza[0][7].getZajete()){
                        if (szachownica.plansza[0][7].getFigura().getTyp_pionka().equals("W")){
                            if (szachownica.plansza[0][7].getFigura().getPierwszyruch()){
                                if (!szachownica.plansza[3][7].getZajete() && !szachownica.plansza[2][7].getZajete() && !szachownica.plansza[1][7].getZajete()){
                                    szachownica.plansza[x_1][y_1].setFigura(null);
                                    szachownica.plansza[x_1][y_1].zmienZajete();
                                    szachownica.plansza[0][7].setFigura(null);
                                    szachownica.plansza[0][7].zmienZajete();
                                    szachownica.plansza[2][7].setFigura(new Król(new Pozycja(2,7),1));
                                    szachownica.plansza[3][7].setFigura(new Wieża(new Pozycja(3,7),1));
                                    ruch_done = false;
                                    szachownica.wypisz();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
