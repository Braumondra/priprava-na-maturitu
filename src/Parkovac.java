import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parkovac  extends Thread {
    private static final Logger log = LoggerFactory.getLogger(Parkovac.class);


    private Sklad_hotovo sklad_aktualne;
    private Sklad sklad;
    private Kasa kasa;

    public Parkovac(Sklad_hotovo sklad_aktualne, Sklad sklad, Kasa kasa,String jmeno) {
        this.sklad_aktualne = sklad_aktualne;
        super(jmeno);
        this.sklad = sklad;
        this.kasa = kasa;
    }

    public void pridejParek() throws InterruptedException {
        if (sklad_aktualne.getHotove_ParkyvRohliku()>0 && sklad_aktualne.getHotove_ParkyvRohliku()<3){
            if (sklad.getRohlik()>0 && sklad.getParky()>0){
                sklad.minusParky();
                sklad.minusRohliku();
                sklad_aktualne.addParkyvRohliku();
                log.info("Hotovej párek");
            }
        }
        else {
            Thread.sleep(6000);
        }

    }

    @Override
    public void run() {
        while (kasa.getPenize()<1000&&!sklad.isDest()){
        if (!(sklad.getParky()<0 || sklad.getRohlik()<0)){
            try {
                pridejParek();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                Thread.sleep(5000);
                sklad.addparky(10);
                sklad.addrohlik(10);
                log.info("Pridali jsme na 10 párků a rohlíků");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
       }
    }
}
