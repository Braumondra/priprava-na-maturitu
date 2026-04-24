//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws InterruptedException {

        Sklad_hotovo skladHotovo=new Sklad_hotovo();
        Sklad sklad=new Sklad();
        Kasa kasa=new Kasa();
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
        Napojar napojar = new Napojar(skladHotovo,sklad,kasa);
        Napojar napojar2 = new Napojar(skladHotovo,sklad,kasa);

        Cisnik cisnik = new Cisnik(kasa,sklad,skladHotovo);
        Cisnik cisnik2 = new Cisnik(kasa,sklad,skladHotovo);

        Parkovac parkovac = new Parkovac(skladHotovo,sklad,kasa);

        Myc myc = new Myc(kasa,sklad,skladHotovo);

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

    System.out.println("konec");

}
