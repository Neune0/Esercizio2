public class Libro {
    String titolo; 
    String autore;
    int anno;
    
    public Libro(String titolo, String autore, int anno){
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Libro){
            Libro libro = (Libro) obj;
            return libro.getTitolo().equals(this.getTitolo()) && libro.getAutore().equals(this.getAutore()) && libro.getAnno() == this.getAnno();
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getTitolo() + " di " + this.getAutore() + " (" + this.getAnno() + ")";
    }
}
