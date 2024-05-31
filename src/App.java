import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Personagem jogadores[] = new Personagem[2];
        int i, classe, arma;
        double saude, forca, destreza;      
        int a, b;  

        for(i=0; i<2; i++){
            classe = input.nextInt();
            saude = input.nextFloat();
            forca = input.nextFloat();
            destreza = input.nextFloat();
            arma = input.nextInt();

            switch (classe) {
            case 1:
                if(arma == 1)
                jogadores[i] = new Mago(saude, forca, destreza, new Transmutacao());
                else if(arma == 2)
                jogadores[i] = new Mago(saude, forca, destreza, new Psikappa());                
                break;
            case 2:
                if(arma == 1)
                jogadores[i] = new Paladino(saude, forca, destreza, new Espada());
                else if (arma == 2)
                jogadores[i] = new Paladino(saude, forca, destreza, new Lança());
                break;
            case 3:
                if(arma == 1)
                jogadores[i] = new Clerigo(saude, forca, destreza, new Martelo());
                else if(arma == 2)
                jogadores[i] = new Clerigo(saude, forca, destreza, new Maca());
                break;
            }
        }
        jogadores[0].printStatus();
        jogadores[1].printStatus();

        a = input.nextInt();
        while(a != 0){
            b = input.nextInt();
            jogadores[a-1].atacar(jogadores[b-1]);

            a = input.nextInt();
        }     
        
        input.close();
    }
}
