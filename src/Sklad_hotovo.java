public class Sklad_hotovo {
    private  int hotove_pivo=0;
    private int hotove_limonady=0;
    private int hotove_ParkyvRohliku=0;


    public void addpivo(){
        hotove_pivo++;
    }
    public void addlimonady(){
        hotove_limonady++;
    }
    public void addParkyvRohliku(){
        hotove_ParkyvRohliku++;
    }

    public void addparkyvRohliku(){
        hotove_ParkyvRohliku++;
    }



    public synchronized void minusPivo(int pivo){
        hotove_pivo-=pivo;
    }
    public synchronized void minusLimonady(int limonady){
        hotove_limonady-=limonady;
    }
    public synchronized void minusParkyvRohliku(int parkyvRohliku){
        hotove_ParkyvRohliku-=parkyvRohliku;
    }



    public int getHotove_pivo() {
        return hotove_pivo;
    }

    public int getHotove_limonady() {
        return hotove_limonady;
    }

    public int getHotove_ParkyvRohliku() {
        return hotove_ParkyvRohliku;
    }
}
