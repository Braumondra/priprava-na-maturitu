import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Napojar extends Thread {
    private static final Logger log = LoggerFactory.getLogger(Napojar.class);


    private Sklad_hotovo sklad_aktualne;
    private Sklad sklad;
    private Kasa kasa;

    public Napojar(Sklad_hotovo sklad_aktualne, Sklad sklad, Kasa kasa,String jmeno) {
        this.sklad_aktualne = sklad_aktualne;
        super(jmeno);
        this.sklad = sklad;
        this.kasa = kasa;
    }

    public void pridejPivo() {
        if (sklad.getMaxPivo()>sklad_aktualne.getHotove_pivo()){
            if (sklad.getLitry_piva() > 0 && sklad.getCistySklenice() > 0) {
                sklad.minusLitry_piva();
                sklad.minusCistySklenice();
                sklad_aktualne.addpivo();
                //System.out.println();
                log.info("Udělal jsem pivo {}", sklad_aktualne.getHotove_pivo());
            }
        }
    }

    public void pridejLimonady(){
        if (sklad.getMaxLimonada()>sklad_aktualne.getHotove_limonady()) {
            if (sklad.getLitry_piva() > 0 && sklad.getCistySklenice() > 0) {
                sklad.minusLitry_limonady();
                sklad.minusCistySklenice();
                sklad_aktualne.addlimonady();
                //System.out.println("Udělal jsem limonady "+sklad_aktualne.getHotove_limonady());
                log.info("Udělal jsem limonady {}", sklad_aktualne.getHotove_limonady());
            }
        }
    }


    public void vyrabej() throws InterruptedException {
        if (sklad_aktualne.getHotove_pivo()<=sklad_aktualne.getHotove_limonady() || sklad_aktualne.getHotove_pivo()<sklad.getMaxPivo()){
            pridejPivo();
        }
        if (sklad_aktualne.getHotove_pivo()>=sklad_aktualne.getHotove_limonady() || sklad_aktualne.getHotove_limonady()<sklad.getMaxLimonada()) {
            pridejLimonady();
        }
        else {
            log.info("Čekám na práci");
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        while (kasa.getPenize()<1000 && !sklad.isDest()){
            try {
                vyrabej();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
