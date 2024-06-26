public class Libro extends ElementoCatalogo {

    private String autore;
    private String genere;

    public Libro (String isbn, String titolo, Integer anno, Integer pagine, String autore, String genere) {
        super(isbn, titolo, anno, pagine, "Libro");
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return this.genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autore: " + autore + ", Genere: " + genere;
    }

}