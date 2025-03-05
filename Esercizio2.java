import java.util.Scanner;


public class Esercizio2 {
    static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }

    public static void menu(Scanner scanner) {
        int scelta = -1;
        do {
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Rimuovi libro");
            System.out.println("3. Presta libro");
            System.out.println("4. Restituisci libro");
            System.out.println("5. Elenco libri disponibili");
            System.out.println("6. Elenco libri in prestito");
            System.out.println("7. Elenco libri disponibili contati");
            System.out.println("0. Esci");
            System.out.println("Scegli un'opzione: ");
            scelta = leggiIntero(scanner);

            switch (scelta) {
                case 1:
                    biblioteca.addLibro(leggiLibro(scanner, " da aggiungere"));
                    System.out.println();
                    break;
                case 2:
                    biblioteca.removeLibro(leggiLibro(scanner, " da rimuovere"));
                    System.out.println();
                    break;
                case 3:
                    biblioteca.prestaLibro(leggiLibro(scanner, " da prestare"));
                    System.out.println();
                    break;
                case 4:
                    biblioteca.restituisciLibro(leggiLibro(scanner, " da restituire"));
                    System.out.println();
                    break;
                case 5:
                    biblioteca.elencoLibri();
                    System.out.println();
                    break;
                case 6:
                    biblioteca.elencoLibriInPrestito();
                    System.out.println();
                    break;
                case 7:
                    biblioteca.elencoLibricontati();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);

    }

    private static int leggiIntero(Scanner scanner) {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                return numero;
            } catch (Exception e) {
                System.out.println("Inserisci un numero intero");
            }
        }
    }

    private static Libro leggiLibro(Scanner scanner, String messaggio){
        System.out.println("\nInserisci i dettagli del libro" + messaggio+ ":");

        System.out.println("Titolo: ");
        String titolo = scanner.nextLine().trim();
        while(titolo.isEmpty()){
            System.out.println("Inserisci un titolo valido: ");
            titolo = scanner.nextLine().trim();
        }

        System.out.println("Autore: ");
        String autore = scanner.nextLine().trim();
        while(autore.isEmpty()){
            System.out.println("Inserisci un autore valido: ");
            autore = scanner.nextLine().trim();
        }   

        System.out.println("Anno: ");
        int anno = leggiIntero(scanner);
        while(anno < 0){
            System.out.println("Inserisci un anno valido: ");
            anno = leggiIntero(scanner);
        }

        return new Libro(titolo, autore, anno);
    }
}