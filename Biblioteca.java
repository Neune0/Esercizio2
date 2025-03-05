
import java.util.ArrayList;
import java.sql.*;

public class Biblioteca {

    private ArrayList<Libro> libri_in_prestito;
    private ArrayList<Libro> libri_disponibili;

    public Biblioteca() {
        libri_in_prestito = new ArrayList<Libro>();
        libri_disponibili = new ArrayList<Libro>();
    }
    
    public void elencoLibri() {
        System.out.println("Elenco libri disponibili:");
        for (Libro libro : libri_disponibili) {
            System.out.println("- " + libro.getTitolo() + " di " + libro.getAutore() + " (" + libro.getAnno() + ")");
        }
    }

    public void elencoLibriInPrestito() {
        System.out.println("Elenco libri in prestito:");
        for (Libro libro : libri_in_prestito) {
            System.out.println("- " + libro.getTitolo() + " di " + libro.getAutore() + " (" + libro.getAnno() + ")");
        }
    }

    public void removeLibro(Libro libro) {
        if (this.libri_disponibili.contains(libro)) {
            this.libri_disponibili.remove(libro);
            System.out.println("Rimozione avvenuta con successo.");
        } else {
            System.out.println("Errore: Libro non trovato.");
        }
    }

    public void addLibro(Libro libro) {
        this.libri_disponibili.add(libro);
    }

    public void prestaLibro(Libro libro_che_voglio) {
        for (Libro libro : libri_disponibili) {
            if (libro.equals(libro_che_voglio)) {
                libri_disponibili.remove(libro);
                libri_in_prestito.add(libro);
                System.out.println("Il libro '" + libro_che_voglio + "' è stato prestato.");
                return;
            }
        }
        System.out.println("Errore: Il libro '" + libro_che_voglio + "' non è disponibile per il prestito.");
    }

    public void restituisciLibro(Libro libro_che_restituisco) {
        for (Libro libro : libri_in_prestito) {
            if (libro.equals(libro_che_restituisco)) {
                libri_in_prestito.remove(libro);
                libri_disponibili.add(libro);
                System.out.println("Il libro '" + libro_che_restituisco + "' è stato restituito.");
                return;
            }
        }
        System.out.println("Errore: Il libro '" + libro_che_restituisco + "' non è stato prestato.");
    }

    public void elencoLibricontati() {
        if (libri_disponibili.isEmpty()) {
            System.out.println("Nessun libro disponibile.");
            return;
        }
    
        System.out.println("Elenco libri disponibili:");
    
        ArrayList<Libro> libriContati = new ArrayList<>();
    
        for (Libro libro : libri_disponibili) {
            boolean trovato = false;
    
            for (Libro l : libriContati) {
                if (libro.equals(l)) {
                    trovato = true;
                    break;
                }
            }
    
            if (!trovato) {
                int copie = 0;
                for (Libro l : libri_disponibili) {
                    if (libro.equals(l)) {
                        copie++;
                    }
                }
                libriContati.add(libro);
                System.out.println("- " + libro.getTitolo() + " di " + libro.getAutore() + " (" + libro.getAnno() + ") | Copie disponibili: " + copie);
            }
        }
    }


}