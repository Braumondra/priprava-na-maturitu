import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
public class Cisnik extends Thread{
    private static final Logger log = LoggerFactory.getLogger(Cisnik.class);
    private Sklad_hotovo sklad_aktualne;
    private Sklad sklad;
    private Kasa kasa;
    private Random random=new Random();
    private int ukradnul=0;

    public Cisnik(Kasa kasa, Sklad sklad, Sklad_hotovo sklad_aktualne,String jmeno) {
        this.kasa = kasa;
        super(jmeno);
        this.sklad = sklad;
        this.sklad_aktualne = sklad_aktualne;
    }


    @Override
    public void run() {
        while (kasa.getPenize()<1000 && !sklad.isDest()){
            int cislo=random.nextInt(9)+1;
            switch (cislo){
                case 1:
                    while (sklad_aktualne.getHotove_pivo()>0){
                        if (sklad_aktualne.getHotove_pivo() >0){
                            sklad_aktualne.minusPivo(1);
                            kasa.Prachy(1,1);
                           // System.out.println();
                            log.info("Zákazník jsi vybral 1 pivo");
                        }
                        else {
                            try {
                                log.info("Čekám na objednávku");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
                case 2:
                    while (sklad_aktualne.getHotove_limonady()>0){
                        if (sklad_aktualne.getHotove_limonady()>0){
                            sklad_aktualne.minusLimonady(1);
                            kasa.Prachy(2,1);
                            //System.out.println();
                            log.info("Zákazník jsi vybral 1 limonádu");

                        }
                        else {
                            try {
                                log.info("Čekám na objednávku");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {}
                        }
                    }
                    break;
                case 3:
                    while (sklad_aktualne.getHotove_ParkyvRohliku()>0){
                        if (sklad_aktualne.getHotove_ParkyvRohliku()>0){
                            sklad_aktualne.minusParkyvRohliku(1);
                            kasa.Prachy(3,1);
                            //System.out.println();
                            log.info("Zákazník jsi vybral 1 parek v rohlíku");

                        }
                        else {
                            try {
                                log.info("Čekám na objednávku");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {}
                        }
                    }
                    break;
                case 4:
                    while ((sklad_aktualne.getHotove_pivo()>1 && sklad_aktualne.getHotove_limonady()>0)){
                        if (sklad_aktualne.getHotove_pivo()>1 && sklad_aktualne.getHotove_limonady()>0){
                            sklad_aktualne.minusLimonady(1);
                            sklad_aktualne.minusPivo(2);
                            kasa.Prachy(1,2);
                            kasa.Prachy(2,1);
                            System.out.println();
                            log.info("Zákazník jsi vybral 2 pivo a 1 limonádu");

                        }
                        else {
                            try {
                                log.info("Čekám na objednávku");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {}
                        }
                    }
                   break;
                case 5:
                    while (sklad_aktualne.getHotove_limonady()>2){
                        if (sklad_aktualne.getHotove_limonady()>2){
                            sklad_aktualne.minusLimonady(3);
                            kasa.Prachy(2,3);
                            //System.out.println();
                            log.info("Zákazník jsi vybral 3 limonády");

                        }
                        else {
                            try {
                                log.info("Čekám na objednávku");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {}
                        }
                    }
                    break;
                case 6:
                    System.out.println();
                    log.info("Zákazník je naštvaný");
                    break;
                case 7:
                    if (sklad_aktualne.getHotove_limonady()>3 && sklad_aktualne.getHotove_pivo()>2 && sklad_aktualne.getHotove_ParkyvRohliku()>1){
                        kasa.Prachy(1,3);
                        kasa.Prachy(2,4);
                        kasa.Prachy(3,2);
                        log.info("Zákazník chtěl 3 piva, 4 limonády, 2 párky v rohlíku");
                    }
                    break;
                case 8:
                    int dostal=random.nextInt(3)+1;
                    switch (dostal){
                        case 1:
                            log.info("Nic neukradnul");
                            break;
                        case 2,3:
                            kasa.ukradnul();
                            log.info("Byly jsem okradeni {}",ukradnul);
                            break;
                    }
                    break;
                case 9:
                    dostal = random.nextInt(3)+1;
                    log.info("Začalo pršet");
                    switch (dostal){
                        case 1:
                            log.info("Přestalo pršet a hospoda pokračuje");
                            break;
                        case 2,3:
                            log.info("Hospoda se uzavírá");
                            sklad.setDest(true);
                            break;
                    }
                    break;
            }
        }
    }
}
