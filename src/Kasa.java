import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Kasa {
    private static final Logger log = LoggerFactory.getLogger(Kasa.class);

    private int penize=0;
    private int vybrano=0;
    private int ukradeno=0;

    public void Prachy(int jidlo,int kolik){
        switch (jidlo){
            case 1:
                //pivo
                penize+=40*kolik;
                vybrano+=40*kolik;
                /*System.out.println("dostali jsme "+40*kolik);
                System.out.println(getPenize());*/
                log.info("dostali jsme {}", 40 * kolik);
                log.info("Aktuálně máme v kase {}", getPenize());
                break;
            case 2:
                //limonada
                penize+=25*kolik;
                vybrano+=25*kolik;
               /* System.out.println("dostali jsme "+25*kolik);
                System.out.println(getPenize());*/

                log.info("dostali jsme {}", 25 * kolik);
                log.info("Aktuálně máme v kase {}", getPenize());
                break;
            case 3:
                //parek v rohliku
                penize+=30*kolik;
                vybrano+=30*kolik;
                /*System.out.println("dostali jsme "+30*kolik);
                System.out.println(getPenize());*/

                log.info("dostali jsme {}", 30 * kolik);
                log.info("Aktuálně máme v kase {}", getPenize());
                break;
        }
    }

    public void ukradnul() {
        ukradeno=penize;
        penize=0;

    }
    public void setPenize(int penize) {
        this.penize = penize;
    }

    public int getVybrano() {
        return vybrano;
    }

    public synchronized int getPenize() {
        return penize;
    }
}
