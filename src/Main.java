import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    void main() throws InterruptedException {
        Sklad sklad = new Sklad();
        Sklad_hotovo skladHotovo = new Sklad_hotovo();
        Kasa kasa = new Kasa();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Napojar napojar = new Napojar(skladHotovo, sklad, kasa,"Karel");
        Napojar napojar2 = new Napojar(skladHotovo, sklad, kasa,"Kuba");

        Cisnik cisnik = new Cisnik(kasa, sklad, skladHotovo,"Tomáš");
        Cisnik cisnik2 = new Cisnik(kasa, sklad, skladHotovo,"Tianna");

        Parkovac parkovac = new Parkovac(skladHotovo, sklad, kasa,"Petr");

        Myc myc = new Myc(kasa, sklad, skladHotovo,"Ondra");

        napojar.start();
        napojar2.start();
        cisnik.start();
        cisnik2.start();
        parkovac.start();
        myc.start();

        napojar.join();
        napojar2.join();
        cisnik.join();
        cisnik2.join();
        myc.join();
        parkovac.join();



        int kasaTed=kasa.getPenize();
        log.info("Bylo vyrobeno piv {}",sklad.getParkyVyrobenno());
        log.info("Bylo prodáno piv {}",sklad.getPivoSell());
        log.info("Bylo vyrobeno  limonády {}",sklad.getLimonadaVYrobenno());
        log.info("Bylo prodáno limonády {}",sklad.getLimonadaSell());
        log.info("Bylo vyrobeno parků v rohlíku{}",sklad.getParkyVyrobenno());
        log.info("Bylo prodáno párků v rohlíku {}",sklad.getParkySell());
        log.info("Zůstalo párků {}",sklad.getParky());
        log.info("Zůstalo rohlíků {}",sklad.getRohlik());
        log.info("Zůstalo litrů piva {}", sklad.getLitry_piva());
        log.info("Zůstalo litrů limonády {}", sklad.getLitry_limonady());
        log.info("Zůstalo čistých sklenic {}", sklad.getCistySklenice());
        log.info("Aktualní stav kasičky {}",kasaTed);
        log.info("Vybráno {}",kasa.getVybrano());
        log.info("Ukradeno {}",kasa.getUkradeno());
        System.out.println("konec");


    }
}
