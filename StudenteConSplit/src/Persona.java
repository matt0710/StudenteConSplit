public class Persona {
    protected String nome;
    protected String cognome;

    public Persona(){}
    public Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "nome=" + this.nome +
                ", cognome=" + this.cognome;
    }
}
