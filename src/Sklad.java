public class Sklad {
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
    private int spinavy=0;


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
        spinavy-=5;
        cistySklenice+=5;
        cistySkleniceMAX+=5;
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
}
