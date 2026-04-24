import java.util.Random;

public class Cisnik extends Thread{

    private Sklad_hotovo sklad_aktualne;
    private Sklad sklad;
    private Kasa kasa;
    private Random random=new Random();

    public Cisnik(Kasa kasa, Sklad sklad, Sklad_hotovo sklad_aktualne) {
        this.kasa = kasa;
        this.sklad = sklad;
        this.sklad_aktualne = sklad_aktualne;
    }

    @Override
    public void run() {
        while (kasa.getPenize()<1000){
            int cislo=random.nextInt(6)+1;
            switch (cislo){
                case 1:
                    while (sklad_aktualne.getHotove_pivo()>0){
                        if (sklad_aktualne.getHotove_pivo() >0){
                            sklad_aktualne.minusPivo(1);
                            kasa.Prachy(1,1);
                            System.out.println("Zákazník jsi vybral 1 pivo");
                        }
                        else {
                            try {
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
                            System.out.println("Zákazník jsi vybral 1 limonádu");

                        }
                        else {
                            try {
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
                            System.out.println("Zákazník jsi vybral 1 parek v rohlíku");

                        }
                        else {
                            try {
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
                            System.out.println("Zákazník jsi vybral 2 pivo a 1 limonádu");

                        }
                        else {
                            try {
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
                            System.out.println("Zákazník jsi vybral 3 limonády");

                        }
                        else {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {}
                        }
                    }
                    break;
                case 6:
                    System.out.println("Zákazník je naštvaný");
                    break;
            }
        }
    }
}
