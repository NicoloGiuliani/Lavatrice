import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Lavatrice lavatrice = new Lavatrice();
        int scelta = 0;
        
        while (scelta != 9) {
            System.out.println("1. accendi");
            System.out.println("2. apri sportello");
            System.out.println("3. chiudi sportello");
            System.out.println("4. inserisci detersivo");
            System.out.println("5. imposta temperatura");
            System.out.println("6. avvia lavaggio");
            System.out.println("7. termina lavaggio");
            System.out.println("8. spegni");
            System.out.println("9. esci");
            System.out.println("\nInserisci l'azione da eseguire: ");
            scelta = sc.nextInt();

            switch(scelta) {
                case 1:
                    lavatrice.accendi();
                    break;
                case 2:
                    lavatrice.apriSportello();
                    break;
                case 3:
                    lavatrice.chiudiSportello();
                    break;
                case 4:
                    lavatrice.inserisciDetersivo();
                    break;
                case 5:
                    lavatrice.impostaTemperatura();
                    break;
                case 6:
                    lavatrice.avviaLavaggio();
                    break;
                case 7:
                    lavatrice.terminaLavaggio();
                    break;
                case 8:
                    lavatrice.spegni();
                    break;
                case 9:
                    System.out.println("Arrivederci");
                    break;
            }
        }
        sc.close();
    }
}
