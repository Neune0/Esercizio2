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
            scelta = scanner.nextInt();

            switch(scelta){
                case 1:
                    System.out.println("Inserisci il titolo del libro: ");
                    String titolo = scanner.next();
                    System.out.println("Inserisci l'autore del libro: ");
                    String autore = scanner.next();
                    System.out.println("Inserisci l'anno del libro: ");
                    int anno = scanner.nextInt();
                    biblioteca.addLibro(new Libro(titolo, autore, anno));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Inserisci il titolo del libro da rimuovere: ");
                    String titoloRimuovi = scanner.next();
                    System.out.println("Inserisci l'autore del libro da rimuovere: ");
                    String autoreRimuovi = scanner.next();
                    System.out.println("Inserisci l'anno del libro da rimuovere: ");
                    int annoRimuovi = scanner.nextInt();
                    biblioteca.removeLibro(new Libro(titoloRimuovi, autoreRimuovi, annoRimuovi));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Inserisci il titolo del libro da prestare: ");
                    String titoloPresta = scanner.next();
                    System.out.println("Inserisci l'autore del libro da prestare: ");
                    String autorePresta = scanner.next();
                    System.out.println("Inserisci l'anno del libro da prestare: ");
                    int annoPresta = scanner.nextInt();
                    biblioteca.prestaLibro(new Libro(titoloPresta, autorePresta, annoPresta));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Inserisci il titolo del libro da restituire: ");
                    String titoloRestituisci = scanner.next();
                    System.out.println("Inserisci l'autore del libro da restituire: ");
                    String autoreRestituisci = scanner.next();
                    System.out.println("Inserisci l'anno del libro da restituire: ");
                    int annoRestituisci = scanner.nextInt();
                    biblioteca.restituisciLibro(new Libro(titoloRestituisci, autoreRestituisci, annoRestituisci));
                    System.out.println();
                    break;
                case 5:
                    biblioteca.elencoLibri();
                    break;
                case 6:
                    biblioteca.elencoLibriInPrestito();
                    break;
                case 7:
                    biblioteca.elencoLibricontati();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);

    }

}