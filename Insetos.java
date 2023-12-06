package abelhinha;

import java.util.Scanner;

public class Insetos {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int drop;
    
    public Insetos(String nome, int ataque, int defesa, int drop) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.drop = drop;
        this.vida = 10;
    }

    
    protected void Batalha(Abelha abelhinha){

        System.out.println("\n" + this.nome + " ESTAVA NA FLOR\n-------BATALHA INICIADA");

        if(abelhinha.ChecarFerrao()){

            while(true){
                System.out.println("\n-------INSTRUCOES\natacar -> use seu veneno\nferroar -> um golpe poderoso mas que usa todo o ferrao");
                System.out.println("\nABELHINHA : HP " + abelhinha.getVida() + " vs " + this.nome + " : HP " + this.vida);
                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] cmd = line.split(" ");
                
                if(cmd[0].equals("atacar")){
                    
                    System.out.println("\nABELHINHA atacou!\n"); //sempre ataca primeiro
                    
                    if(this.danoRecebido(abelhinha.getVeneno())){ //checar se o inseto morre ao receber dano

                        this.receberDano(abelhinha.getVeneno()); //inseto recebe o dano
                        System.out.println(this.nome + " atacou!"); // inceto ataca
                        abelhinha.dano(ataque); // abelhinha recebe o dano

                        if(abelhinha.checarVida()){ //caso abelhinha morra
                            abelhinha.zerarInventario(); //abelha perde tudo
                            throw new MsgException("\nABELHINHA morreu e perdeu todos os itens!(cure-se)");
                        }

                    }else{
                        //caso o inceto morra sem poder atacar
                        System.out.println(this.nome + " morreu!");
                        this.drop(abelhinha);
                        break;
                    }

                }else if(cmd[0].equals("ferroar")){
                    
                    System.out.println("\nABELHINHA USOU TODOS OS FERROES EM UM ATAQUE PODEROSO!\n");
                    abelhinha.zerarFerrao();
                    System.out.println(this.nome + " nao resistiu a ferroada!");
                    this.drop(abelhinha);
                    break;
                }else{
                    System.out.println("fail: comando invalido");
                }
                
            }
            
        }else{
            //abelha perde por falta de ferrao para lutar
            System.out.println("\n---ABELHINHA ESGOTOU SEU FERRAO E NAO PODE MAIS BATALHAR\n");
            abelhinha.zerarInventario();
            abelhinha.setVida(0);
            throw new MsgException("DERROTA: todos os itens perdidos");
        }
        
        abelhinha.setFerrao();
    }
                
    //checar se inseto morrer na hora batalha do ataque
    private boolean danoRecebido(int dano){

        dano = dano / this.defesa;
        if(dano >= vida){

            return false; // inseto morre sem atacar
        }
        
        return true; // inseto nao morre, ent pode atacar
    }
    //coletar drop
    private void drop(Abelha abelhinha){

        if(this.nome.equals("GARFANHOTO")){
            System.out.println("\n-------PARABENS\nABELHINHA ganhou e recebeu 2 garras\n");
            abelhinha.alteraInventario("Garras", 2, false);
        }else if(this.nome.equals("BORBOLETA")){
            System.out.println("\n-------PARABENS\nABELHINHA ganhou e recebeu 2 asas\n");
            abelhinha.alteraInventario("Asas", 2, false);
        }else{
            System.out.println("\n-------PARABENS\nABELHINHA ganhou e recebeu 1 ferrao\n");
            abelhinha.alteraInventario("Ferrao", 1, false);
        }


    }

    private void receberDano(int dano){
        this.vida -= dano / this.defesa;
    }

    @Override
    public String toString() {
        
        String s = "---" + this.nome + "---\nHP : " + this.vida;

        return s;
    }
    private static Scanner scanner = new Scanner (System.in);
}

class Garfanhoto extends Insetos {

    public Garfanhoto(){
        super("GARFANHOTO", 20, 2, 2);
    }

    @Override
    protected void Batalha(Abelha abelhinha) {

        super.Batalha(abelhinha);
    }

    @Override
    public String toString() {
        
        return super.toString();
    }
}

class Borboleta extends Insetos {

    public Borboleta(){
        super("BORBOLETA", 10,2,2);
    }

    @Override
    protected void Batalha(Abelha abelhinha) {
        
        super.Batalha(abelhinha);
    }

    @Override
    public String toString() {
        
        return super.toString();
    }
}

class Maribondo extends Insetos {

    public Maribondo(){
        super("MARIBONDO",15,2,1);
    }

    @Override
    protected void Batalha(Abelha abelhinha) {
        
        super.Batalha(abelhinha);
    }

    @Override
    public String toString() {
        
        return super.toString();
    }
}