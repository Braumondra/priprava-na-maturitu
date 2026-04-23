import java.util.Objects;

public class Kasa {
    private int penize=0;

    public void Prachy(int jidlo,int kolik){
        switch (jidlo){
            case 1:
                //pivo
                penize+=40*kolik;
                break;
            case 2:
                //limonada
                penize+=25*kolik;
                break;
            case 3:
                //parek v rohliku
                penize+=30*kolik;
                break;
        }

    }

    public synchronized int getPenize() {
        return penize;
    }
}
