package abelhinha;

import java.util.*;

public class Colmeia {
    private Abelha abelhinha;
    private int estoquedePolen;
    private int estoquedeMel;
    private int estoqueNectar;
    private int larvas;
    private int populacao;

    public Colmeia(){
        abelhinha = new Abelha();
        this.estoquedePolen = 50;
        this.estoquedeMel = 30;
        this.estoqueNectar = 50;
        this.larvas = 43;
        this.populacao = 20;
    }

    public Abelha getAbelha(){
        return this.abelhinha;
    }

    public int getEstoquedeMel() {
        return estoquedeMel;
    }

    public void setEstoquedeMel(int i){
        
        if(i > estoqueNectar){
            System.out.println("\nVALOR MAIOR QUE O ESTOQUE DE NECTAR"); 
        }else{
            estoquedeMel += i/4;
            estoqueNectar -= i;
            System.out.print("\n-------PARABENS\n" + i + " de nectar foram transformados em " + i/4 + " de mel!\n");
        }
    }

    public int getEstoqueNectar() {
        return estoqueNectar;
    }

    public void setEstoqueNectar(int estoqueNectar) {
        this.estoqueNectar = estoqueNectar;
    }

    //MEL
    public void SetorDoMel(){
        System.out.println("\n-------MEL-------\nAJUDA AS ABELHINHAS A SUPORTAREM CONDICOES DESFAVORAVEIS(USE-O PARA EVOLUIR)\n");
        String instrucao = "-------INSTRUCOES \ntransformar (espaco + quandidade) -> transforma nectar em mel \n";
        instrucao += "coletar (espaco + quandidade) -> coletar mel\nend -> para voltar";
        System.out.println(instrucao);
        
        try {
            while (true) {
            
                System.out.println("\nESTOQUE DE MEL : " + this.getEstoquedeMel() + "\nESTOQUE DE NECTAR : " + this.getEstoqueNectar() + "\n");

                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] cmd = line.split(" ");

                if(cmd[0].equals("transformar")){

                    this.setEstoquedeMel(Integer.parseInt(cmd[1]));
                }else if(cmd[0].equals("coletar")){

                    this.coletarMel(Integer.parseInt(cmd[1]));
                }else if(cmd[0].endsWith("end")){

                    break;
                }else{
                    System.out.println("fail: comando invalido");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
            

    }

    private void coletarMel(int valor) {

        if(valor > estoquedeMel){
            
            System.out.println("\nVALOR PEDIDO MAIOR QUE ESTOQUE DE MEL");
            
        }else{
            System.out.println("\n-------PARABENS");
            this.estoquedeMel -= valor;
            this.abelhinha.setMel(valor);
            System.out.println(valor + " de mel recebido!");
        }
    }

    //CRIACAO DE ABELHAS
    public void SetorCriacao(){
        System.out.println("\n-------POLEN-------\nALIMENTE AS LARVAS PARA MANTER A POPULACAO DA COLMEIA\n");
        String instr = "-------INSTRUCAO\nalimentar (espaco + quandidade) -> transforma larvas em abelhinhas\npopulacao -> abelhinhas geram larvas\nend -> voltar";
        System.out.println(instr);
        
        try{
            while (true) {
            
                System.out.println("ESTOQUE DE POLEN : " + this.estoquedePolen + "\nLARVAS: " + this.larvas + "\nPOPULACAO: " + this.populacao);

                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] cmd = line.split(" ");

                if(cmd[0].equals("end")){

                    break;
                }else if(cmd[0].equals("alimentar")){

                    this.Alimentar(Integer.parseInt(cmd[1]));
                }else if(cmd[0].equals("populacao")){

                    this.Reproduzir();
                }else{
                    System.out.println("\nfail: comando invalido\n");
                }

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        


    }

    public void Alimentar(int valor) {

        if(valor > this.estoquedePolen){
            System.out.println("\nVALOR PEDIDO MAIOR QUE ESTOQUE DE POLEN\n"); 
        }else{
            if(valor < this.larvas){
                
                this.populacao += valor;
                this.larvas -= valor;
                System.out.println("\n-------PARABENS\n" + valor + " larvas cresceram\n");
                this.estoquedePolen -= valor;
            }else if(valor == this.larvas){

                this.populacao += this.larvas;
                this.larvas = 0;
                this.estoquedePolen -= valor;
                System.out.println("\n-------PARABENS\n" + "TODAS AS LARVAR CRESCERAM\n");
            }else{
                
                this.populacao += this.larvas;
                this.larvas = 0;
                this.estoquedePolen -= valor;
                System.out.println("\n-------PARABENS\n" + "TODAS AS LARVAR CRESCERAM MAS ALGUNS GRAOS DE POLEN FORAM DESPERDIÇADOS...\n");
            }
        }
        
        
    }

    public void Reproduzir(){

        if(this.populacao <= 7){
            System.out.println("\nABELHINHAS INSUFICIENTES (ALIMENTE AS LARVAS)"); 
        }else{
            
            this.larvas += this.populacao / 2;
            this.populacao -= this.populacao / 5; // algumas abelhas morrem na aventura
            System.out.println("\n-------PARABENS\nFORAM GERADAS " + this.populacao/2 + " DE LARVAS MAS MORRERAM ALGUMAS DE ABELHINHAS NAS JORNADAS...\n");
        }
    }

    //SETOR DE ARMAZENAMENTO
    public void Armazenar(){
        System.out.println("\n-------ARMAZENAR-------\nARMAZENE POLEN E NECTAR PARA A COLMEIA\n");
        String instr = "-------INSTRUCAO\nnectar -> guarda todo o nectar do inventario\npolen -> guarda todo o polen do inventario\nend -> voltar";
        System.out.println(instr);

        while(true){

            System.out.println("\nESTOQUE DE NECTAR : " + this.estoqueNectar + "   ESTOQUE DE POLEN : " + this.estoquedePolen);
            System.out.print("\nITENS NO INVENTARIO:   NECTAR: " + this.abelhinha.valorInventario("Nectar"));
            System.out.println("    POLEN: " + this.abelhinha.valorInventario("Polen"));

            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] cmd = line.split(" ");

            if(cmd[0].equals("nectar")){
                if(this.abelhinha.valorInventario("Nectar") != 0){
                    this.estoqueNectar += this.abelhinha.valorInventario("Nectar");
                    System.out.println("\n-------PARABENS\nTODO O NECTAR FOI ARMAZENADO");
                    this.abelhinha.alteraInventario("Nectar", 0, true);
                }else{
                    System.out.println("\nABELHINHA NAO TEM NECTAR PARA GUARDAR!");
                }
            }else if(cmd[0].equals("polen")){
                if(this.abelhinha.valorInventario("Polen") != 0){
                    this.estoquedePolen += this.abelhinha.valorInventario("Polen");
                    System.out.println("\n-------PARABENS\nTODO O POLEN FOI ARMAZENADO");
                    this.abelhinha.alteraInventario("Polen", 0, true);
                }else{
                    System.out.println("\nABELHINHA NAO TEM POLEN PARA GUARDAR");
                }
            }else if(cmd[0].equals("end")){

                break;
            }else{

                System.out.println("\nfail: comando inavalido");
            }
        }
    }
    //SETOR DA EVOLUCAO
    public void Pesquisar(){
    
    System.out.println("\n-------EVOLUA-SE-------\nUSE O MEL PARA BUFFAR SEUS STATUS\n");
    String instr = "-------INSTRUCOES\nveneno -> para melhorar o veneno\ndefesa -> para melhorar a defesa\nferrao -> para melhorar o ferrao";
    instr += "\nguilde -> veja a receita para evoluir\nend -> para voltar";
    System.out.println(instr);

    while (true) {

        System.out.print("\nITENS NO INVENTARIO:\nMEL: " + this.abelhinha.valorInventario("Mel") + " GARRAS: " + this.abelhinha.valorInventario("Garras"));
        System.out.println(" ASAS: " + this.abelhinha.valorInventario("Asas") + " FERRAO: " + this.abelhinha.valorInventario("Ferrao"));
    

        String line = scanner.nextLine();
        System.out.println("$" + line);
        String[] cmd = line.split(" ");

        if(cmd[0].equals("end")){

            break;
        }else if(cmd[0].equals("veneno")){

            if(this.abelhinha.ChecarItens("Mel") && this.abelhinha.ChecarItens("Garras")){
                this.abelhinha.venenoMax();
                this.abelhinha.alteraInventario("Mel", -4, false);
                this.abelhinha.alteraInventario("Garras", -2, false);
                System.out.println("\n-------PARABENS\n" + "VENENO AUMENTADO PARA: " + this.abelhinha.getVeneno());
            }else{
                System.out.println("\nITENS INSUFICIENTES!");
            }

        }else if(cmd[0].equals("defesa")){

            if(this.abelhinha.ChecarItens("Mel") && this.abelhinha.ChecarItens("Asas")){
                this.abelhinha.defesaMax();
                this.abelhinha.alteraInventario("Mel", -4, false);
                this.abelhinha.alteraInventario("Asas", -2, false);
                System.out.println("\n-------PARABENS\n" + "DEFESA AUMENTADA PARA: " + this.abelhinha.getDefesa());
            }else{
                System.out.println("\nITENS INSUFICIENTES!");
            }

        }else if(cmd[0].equals("ferrao")){

            if(this.abelhinha.ChecarItens("Mel") && this.abelhinha.ChecarItens("Ferrao")){
                this.abelhinha.ferraoMax();
                this.abelhinha.alteraInventario("Mel", -6, false);
                this.abelhinha.alteraInventario("Ferrao", -4, false);
                System.out.println("\n-------PARABENS\n" + "FERRAO AUMENTADO PARA: " + this.abelhinha.getFerrao());
            }else{
                System.out.println("\nITENS INSUFICIENTES!");
            }

        }else if(cmd[0].equals("guilde")){
            System.out.println("\nPARA EVOLUIR A ABELHINHA PRECISA DE :\n4 mel e 2 garras para aumentar o VENENO");
            System.out.println("4 mel e 2 asas para aumentar a DEFESA\n6 mel e 4 ferroes para aumentar o FERRAO");
            
            System.out.print("\naperte qualquer tecla para voltar: ");
            line = scanner.nextLine();
        }else{

            System.out.println("\nfail: comando invalido!");
        }

            
    }
}

    @Override
    public String toString() {
        
        return abelhinha.toString();
    }

    public String verInventario(){

        return abelhinha.inventario();
    }
    private static Scanner scanner = new Scanner (System.in);
}
