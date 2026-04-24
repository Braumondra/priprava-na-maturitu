import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sklad_hotovo {
    private static final Logger log = LoggerFactory.getLogger(Sklad_hotovo.class);

    private  int hotove_pivo=0;
    private int hotove_limonady=0;
    private int hotove_ParkyvRohliku=0;
    Sklad sklad = new Sklad();



    public void addpivo(){
        hotove_pivo++;
        sklad.setPivoVyrobenno(1);
    }

    public void addlimonady(){
        hotove_limonady++;
        sklad.setLimonadaVYrobenno(1);
    }

    public void addParkyvRohliku(){
        hotove_ParkyvRohliku++;
        sklad.setParkyVyrobenno(1);
    }



    public synchronized void minusPivo(int pivo){
        hotove_pivo-=pivo;
        sklad.setPivoSell(1);
    }

    public synchronized void minusLimonady(int limonady){
        hotove_limonady-=limonady;
        sklad.setLimonadaSell(1);
    }

    public synchronized void minusParkyvRohliku(int parkyvRohliku){
        hotove_ParkyvRohliku-=parkyvRohliku;
        sklad.setParkySell(1);
    }



    public synchronized int getHotove_pivo() {
        return hotove_pivo;
    }

    public synchronized int getHotove_limonady() {
        return hotove_limonady;
    }

    public synchronized int getHotove_ParkyvRohliku() {
        return hotove_ParkyvRohliku;
    }
}
