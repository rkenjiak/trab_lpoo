public abstract class Arma {
    private String nome;
    private double modDano; 
    
    public Arma(String nome, double modDano){
        this.nome = nome;
        this.modDano = modDano;
    }

    public final String getNome(){
        return nome;
    }

    public final double getModificadorDano(){
        return modDano;
    }
    
}
