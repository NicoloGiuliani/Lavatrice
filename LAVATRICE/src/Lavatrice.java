import java.util.Scanner;

public class Lavatrice {
    private Scanner sc = new Scanner(System.in); 
    private boolean sportelloChiuso = true;
    private Stato stato = Stato.spenta;
    private boolean detersivoPresente = false;
    private boolean temperaturaImpostata=false;
    private boolean lavaggioEseguito = false;
    private boolean lavaggioTerminato = false;
    private int temperatura;

    public Stato getStato() {
        return stato;
    }

    public void accendi() {
        if (stato == Stato.spenta) {
            stato = Stato.standBy;
            System.out.println("La lavatrice è accesa\n");
        }
        else {
            System.out.println("La lavatrice è già accesa\n");
        }
    }

    public void apriSportello() {
        if (stato!=Stato.lavaggioInCorso) {
            if (sportelloChiuso == false) {
                System.out.println("Sportello già aperto\n");   
            }
            else {
                sportelloChiuso = false;
                System.out.println("Sportello aperto\n");
            }
        }
        else {
            System.out.println("Non puoi aprire lo sportello durante il lavaggio\n");
        }
    }

    public void chiudiSportello() {
        if (sportelloChiuso == true) {
            System.out.println("Sportello già chiuso\n");   
        }
        else {
            System.out.println("Sportello chiuso\n");
            sportelloChiuso = true;
        }
    }
    
    public void inserisciDetersivo() {
        if (detersivoPresente == false) {
            System.out.println("Detersivo inserito\n");
            detersivoPresente = true;
        }
        else {
            System.out.println("Detersivo già inserito\n");   
        }
    }

    public void impostaTemperatura() {
        if (stato == Stato.spenta) {
            System.out.println("Accendi la lavatrice prima di impostare la temperatura.\n");
            return;
        }

        System.out.println("Inserisci la temperatura (tra 20 e 90 gradi): ");
        int nuovaTemperatura = sc.nextInt();

        if (nuovaTemperatura <= 20 || nuovaTemperatura >= 90) {
            System.out.println("Temperatura non valida. Deve essere compresa tra 20 e 90 gradi.\n");
            return;
        }

        if (temperaturaImpostata && nuovaTemperatura == temperatura) {
            System.out.println("La temperatura inserita è già impostata.\n");
            return;
        }

        if (stato == Stato.lavaggioInCorso) {
            System.out.println("Non puoi cambiare la temperatura durante il lavaggio.\n");
            return;
        }

        temperatura = nuovaTemperatura;
        temperaturaImpostata = true;
        System.out.println("Temperatura impostata a " + temperatura + " gradi.\n");
    }

    public void avviaLavaggio() {
        if (lavaggioEseguito) {
            System.out.println("Il lavaggio è già stato eseguito. Riavvia la lavatrice per eseguire un nuovo lavaggio.\n");
            return;
        }

        if (stato == Stato.standBy && sportelloChiuso && detersivoPresente && temperatura >= 20 && temperatura <= 90) {
            stato = Stato.lavaggioInCorso;
            lavaggioEseguito = true;
            System.out.println("Lavaggio avviato con temperatura impostata a " + temperatura + " gradi.\n");
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Impossibile avviare il lavaggio. Verifica che lo sportello sia chiuso, il detersivo sia presente e la temperatura sia corretta.\n");
        }
    }
    
    public void terminaLavaggio() {
        if (lavaggioTerminato) {
            System.out.println("Il lavaggio è già terminato.\n");
            return;
        }

        if (stato == Stato.lavaggioInCorso) {
            System.out.println("Lavaggio terminato\n");
            stato = Stato.standBy;
            lavaggioTerminato = true;
        } else {
            System.out.println("Non c'è un lavaggio in corso da terminare.\n");
        }
    }

    public void spegni() {
        if (stato != Stato.spenta) {
            stato = Stato.spenta;
            System.out.println("La lavatrice è spenta\n");
        }
        else {
            System.out.println("La lavatrice è già spenta\n");
        }
    }
}