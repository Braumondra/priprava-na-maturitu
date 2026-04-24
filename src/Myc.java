import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Myc  extends Thread{
    private static final Logger log = LoggerFactory.getLogger(Myc.class);


    private Sklad_hotovo sklad_aktualne;
    private Sklad sklad;
    private Kasa kasa;


    public Myc(Kasa kasa, Sklad sklad, Sklad_hotovo sklad_aktualne,String jmeno) {
        super(jmeno);
        this.kasa = kasa;
        this.sklad = sklad;
        this.sklad_aktualne = sklad_aktualne;
    }

    public void cisteni() throws InterruptedException {
        if (sklad.getCistySklenice()<30){
            sklad.vycisty();
            log.info("Čistím sklenici");
        }
        else {
            log.info("Čekám na práci");
            Thread.sleep(1000);

        }

    }

    @Override
    public void run() {
        while(kasa.getPenize()<1000 && !sklad.isDest()){
            try {
                cisteni();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
