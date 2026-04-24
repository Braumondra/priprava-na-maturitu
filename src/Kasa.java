import java.util.Objects;

public class Kasa {
    private int penize=0;

    public void Prachy(int jidlo,int kolik){
        switch (jidlo){
            case 1:
                //pivo
                penize+=40*kolik;
                System.out.println("dostali jsme "+40*kolik);
                System.out.println(getPenize());
                break;
            case 2:
                //limonada
                penize+=25*kolik;
                System.out.println("dostali jsme "+25*kolik);
                System.out.println(getPenize());
                break;
            case 3:
                //parek v rohliku
                penize+=30*kolik;
                System.out.println("dostali jsme "+30*kolik);
                System.out.println(getPenize());
                break;
        }
    }

    public synchronized int getPenize() {
        return penize;
    }
}
