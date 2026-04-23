public class Myc  extends Thread{

    private Sklad_hotovo sklad_aktualne;
    private Sklad sklad;
    private Kasa kasa;


    public Myc(Kasa kasa, Sklad sklad, Sklad_hotovo sklad_aktualne) {
        this.kasa = kasa;
        this.sklad = sklad;
        this.sklad_aktualne = sklad_aktualne;
    }

    public void cisteni() throws InterruptedException {
        if (sklad.getCistySklenice()<30){
            sklad.vycisty();
        }
        else {
            Thread.sleep(1000);
        }

    }

    @Override
    public void run() {
        while(kasa.getPenize()<1000){
            try {
                cisteni();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("konec");
    }
}
