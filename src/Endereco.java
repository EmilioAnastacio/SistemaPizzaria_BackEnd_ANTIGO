public class Endereco {

    private String nomeRua;
    private int numero;

    public Endereco(String nomeRua, int numero) {
        this.nomeRua = nomeRua;
        this.numero = numero;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
