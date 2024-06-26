public class Personagem {
    private String nomeTipo;
    private double saude;
    private double forca;
    private double destreza;
    private Arma arma;

    public Personagem(String nomeTipo, double saude, double forca, double destreza, Arma arma){
        this.nomeTipo = nomeTipo;
        this.saude = saude;
        this.forca = forca;
        this.destreza = destreza;
        this.arma = arma;
    }

    public void printStatus(){
        if(estaMorto()){
            System.out.printf("%s [Morreu, Forca: %.1f, Destreza: %.1f, %s]\n",nomeTipo,forca,destreza,arma.getNome());
        }else{
            System.out.printf("%s [Saude: %.1f, Forca: %.1f, Destreza: %.1f, %s]\n",nomeTipo,saude,forca,destreza,arma.getNome());
        }
    }

    // Método de ataque de this(A) contra inimigo(B)
    public void atacar(Personagem inimigo){
        // Verificação se o atacante está vivo
        if(this.estaMorto()){
            System.out.printf("O %s não consegue atacar, pois está morto.\n", this.nomeTipo);        
        }else{
            System.out.printf("O %s ataca o %s com %s.\n", this.nomeTipo, inimigo.nomeTipo, this.arma.getNome());        

            // Verificação se o defensor está vivo
            if(inimigo.estaMorto()){
                System.out.printf("Pare! O %s já está morto!\n", inimigo.nomeTipo);

            // Caso ataque bem sucedido
            }else if(this.destreza > inimigo.destreza){   
                inimigo.recebeDano(this.calculaDano());
                System.out.printf("O ataque foi efetivo com %.1f pontos de dano!\n", this.calculaDano());

            // Caso ataque mal sucedido
            }else if(this.destreza < inimigo.destreza){   
                this.recebeDano(inimigo.calculaDano());
                System.out.printf("O ataque foi inefetivo e revidado com %.1f pontos de dano!\n", inimigo.calculaDano());

            // Caso ataque defendido
            }else if(this.destreza == inimigo.destreza){ 
                System.out.printf("O ataque foi defendido, ninguem se machucou!\n");
            }            
        }
        // Impressao de Status pós ataque
        this.printStatus();
        inimigo.printStatus();
    }

    private double calculaDano(){
        return forca * arma.getModificadorDano();
    }

    private void recebeDano(double pontosDano){
        saude -= pontosDano;
    }

    private boolean estaMorto(){
        return saude < 1.0f ? true:false;        
    }
}
