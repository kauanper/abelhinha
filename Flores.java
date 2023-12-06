package abelhinha;

public class Flores {
    protected String nome;
    protected int quandidadePolen;
    protected int quandidadeNectar;

    public Flores(String nome, int quandidadePolen, int quandidadeNectar){
        this.nome = nome;
        this.quandidadePolen = quandidadePolen;
        this.quandidadeNectar = quandidadeNectar;
    }

    protected void ColetarRecursos(Abelha abelhinha){

        if(abelhinha.valorInventario("Polen") < 200){

            if(abelhinha.valorInventario("Nectar") < 200){
                //manipular
                abelhinha.alteraInventario("Nectar", quandidadeNectar, false);
                abelhinha.alteraInventario("Polen", quandidadePolen, false);

                System.out.println("\n------PARABENS\nABELHINHA coletou " + this.quandidadeNectar + " de nectar e " + this.quandidadePolen + " de POLEN\n");

            }else{
                throw new MsgException("fail: quantidade de nectar em excesso(armazene-o)"); //AQUI    
            }
        }else{

            throw new MsgException("fail: quantidade de polen em excesso(armazene-o)"); //AQUI
        }

    }

    @Override
    public String toString() {
        
        String s = "\n-------FLOR ENCONTRADA\n";
        s += this.nome + " : " + this.quandidadeNectar + " de NECTAR e " + this.quandidadePolen + " de POLEN\n";
        return s;
    }
    

}

class Bamburral extends Flores{

    public Bamburral(){
        super("BAMBURRAL", 10, 30);
    }

    
    @Override
    protected void ColetarRecursos(Abelha abelhinha) {
        
        super.ColetarRecursos(abelhinha);
    }

    @Override
    public String toString() {
        
        return super.toString();
    }

}

class Sabia extends Flores {

    public Sabia(){
        super("SABIA", 30, 10);
    }

    @Override
    protected void ColetarRecursos(Abelha abelhinha) {
        
        super.ColetarRecursos(abelhinha);
    }

    @Override
    public String toString() {
        
        return super.toString();
    }
}

class Marmeleiro extends Flores{

    public Marmeleiro(){
        super("MARMELEIRO", 15, 15);
    }

    @Override
    protected void ColetarRecursos(Abelha abelhinha) {
        
        super.ColetarRecursos(abelhinha);
    }

    @Override
    public String toString() {
        
        return super.toString();
    }
}
