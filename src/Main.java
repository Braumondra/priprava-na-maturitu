//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws InterruptedException {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
        Napojar napojar = new Napojar();
        Napojar napojar2 = new Napojar();

        Cisnik cisnik = new Cisnik();
        Cisnik cisnik2 = new Cisnik();

        Parkovac parkovac = new Parkovac();

        Myc myc = new Myc();

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
