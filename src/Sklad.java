import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sklad {
    private static final Logger log = LoggerFactory.getLogger(Sklad.class);

    private int rohlik=20;
    private int parky=20;
    private int maxPivo=3;
    private int maxLimonada=5;
    private Double litry_piva=500.0;
    private Double litry_limonady=500.0;
    private int cistySklenice=20;
    private int cistySkleniceMAX=20;
    private Sklad_hotovo sklad=new Sklad_hotovo();;
    private Kasa kasa=new Kasa();
    private int spinavy=20;


    //
    private int pivoVyrobenno=0;
    private int pivoSell=0;
    private int limonadaVYrobenno=0;
    private int limonadaSell=0;
    private int parkyVyrobenno=0;
    private int parkySell=0;
    private int parkyVeSkladu=0;
    private int rohlikyVeSkladu=0;
    private int pivoVeSkladu=0;
    private int limonadaVeSkladu=0;
    private int kasaTed=0;
    private int penizeVybrano=0;
    private int penizeVykraden=0;

    public int getPivoVyrobenno() {
        return pivoVyrobenno;
    }

    public void setPivoVyrobenno(int pivoVyrobenno) {
        this.pivoVyrobenno = pivoVyrobenno;
    }

    public int getPivoSell() {
        return pivoSell;
    }

    public void setPivoSell(int pivoSell) {
        this.pivoSell = pivoSell;
    }

    public int getLimonadaVYrobenno() {
        return limonadaVYrobenno;
    }

    public void setLimonadaVYrobenno(int limonadaVYrobenno) {
        this.limonadaVYrobenno += limonadaVYrobenno;
    }

    public int getLimonadaSell() {
        return limonadaSell;
    }

    public void setLimonadaSell(int limonadaSell) {
        this.limonadaSell += limonadaSell;
    }

    public int getParkyVyrobenno() {
        return parkyVyrobenno;
    }

    public void setParkyVyrobenno(int parkyVyrobenno) {
        this.parkyVyrobenno += parkyVyrobenno;
    }

    public int getParkySell() {
        return parkySell;
    }

    public void setParkySell(int parkySell) {
        this.parkySell += parkySell;
    }

    public int getParkyVeSkladu() {
        return parkyVeSkladu;
    }

    public void setParkyVeSkladu(int parkyVeSkladu) {
        this.parkyVeSkladu += parkyVeSkladu;
    }

    public int getRohlikyVeSkladu() {
        return rohlikyVeSkladu;
    }

    public void setRohlikyVeSkladu(int rohlikyVeSkladu) {
        this.rohlikyVeSkladu = rohlikyVeSkladu;
    }

    public int getPivoVeSkladu() {
        return pivoVeSkladu;
    }

    public void setPivoVeSkladu(int pivoVeSkladu) {
        this.pivoVeSkladu += pivoVeSkladu;
    }

    public int getLimonadaVeSkladu() {
        return limonadaVeSkladu;
    }

    public void setLimonadaVeSkladu(int limonadaVeSkladu) {
        this.limonadaVeSkladu += limonadaVeSkladu;
    }

    public int getKasaTed() {
        return kasaTed;
    }

    public void setKasaTed(int kasaTed) {
        this.kasaTed += kasaTed;
    }

    public int getPenizeVybrano() {
        return penizeVybrano;
    }

    public void setPenizeVybrano(int penizeVybrano) {
        this.penizeVybrano += penizeVybrano;
    }

    public int getPenizeVykraden() {
        return penizeVykraden;
    }

    public void setPenizeVykraden(int penizeVykraden) {
        this.penizeVykraden += penizeVykraden;
    }

    public void setCistySklenice(int cistySklenice) {
        this.cistySklenice += cistySklenice;
    }









    private boolean dest=false;

    public synchronized void setDest(boolean dest) {
        this.dest = dest;
    }

    public synchronized boolean isDest() {
        return dest;
    }

    public synchronized void minusLitry_piva(){
        litry_piva-=0.5;
    }

    public synchronized void minusLitry_limonady(){
        litry_limonady=0.5;
    }

    public synchronized void minusRohliku(){
        rohlik-=1;
    }

    public synchronized void minusParky(){
        parky-=1;
    }


    public synchronized void minusCistySklenice(){
        cistySklenice--;
        spinavy++;
    }

    public int getMaxPivo() {
        return maxPivo;
    }

    public int getMaxLimonada() {
        return maxLimonada;
    }

    public synchronized void addparky(int pocet){
        parky+=pocet;

    }

    public synchronized void addrohlik(int pocet){
        rohlik+=pocet;
    }

    public synchronized void vycisty(){
        if (spinavy>4){
            spinavy-=5;
            cistySklenice+=5;
            cistySkleniceMAX+=5;
            log.info("Čištený");
        }

    }


    public int getCistySklenice() {
        return cistySklenice;
    }


    public double getLitry_limonady() {
        return litry_limonady;
    }

    public double getLitry_piva() {
        return litry_piva;
    }

    public int getParky() {
        return parky;
    }

    public int getRohlik() {
        return rohlik;
    }



    public void statistika(){
        kasaTed=kasa.getPenize();
        log.info("Bylo vyrobeno piv {}",getParkyVyrobenno());
        log.info("Bylo prodáno piv {}",getPivoSell());
        log.info("Bylo vyrobeno  limonády {}",getLimonadaVYrobenno());
        log.info("Bylo prodáno limonády {}",getLimonadaSell());
        log.info("Bylo vyrobeno parků v rohlíku{}",getParkyVyrobenno());
        log.info("Bylo prodáno párků v rohlíku {}",getParkySell());
        log.info("Zůstalo párků {}",getParky());
        log.info("Zůstalo rohlíků {}",getRohlik());
        log.info("Zůstalo litrů piva {}", getLitry_piva());
        log.info("Zůstalo litrů limonády {}", getLitry_limonady());
        log.info("Zůstalo čistých sklenic {}", getCistySklenice());
        log.info("Aktualní stav kasičky {}",getKasaTed());
        log.info("Vybráno {}",kasa.getVybrano());
        log.info("Ukradeno {}",kasa.getUkradeno());

    }
}
