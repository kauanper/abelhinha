package abelhinha;

import java.util.*;

public class Lobby {

    public static void main(String[] args){
        
        Colmeia colmeia = new Colmeia();
        Floresta floresta = new Floresta();

        String intro = "-------INTRUDUCAO-------\nA COLMEIA E ORGANIZADA EM DIFERENTES SETORES EM QUE CADA UM DESEMPENHA UM PAPEL ESPECIFICO NA SOBREVIVENCIA E PROSPERIDADE DA COLONIA\n";
        intro += "SAO ELES: \nPRODUCAO DE MEL: UMA SUBSTANCIA PODEROZA PARA AS ABELHAS \nCRIACAO DE ABELHAS: ALIMENTAR AS LARVAR COM POLEN \nESTACAO DE PESQUISA: EVOLUA-SE";
        System.out.println(intro);
        
        String comandos = "\n-------INSTRUCOES------- \nstatus -> ver status da abelhinha \nbag -> ver inventario da abelhinha\ncurar -> recupera energia da abelhinha\n";
        comandos += "produzir -> vai para o setor do mel\ncriar -> vai para o setor de criacao de lavar \narmazenar -> armazena polen e nectar\n";
        comandos += "pesquisar -> abelhinha pode se melhorar\nexplorar -> para explorar";

        

            while (true) {

                System.out.println(comandos);

                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] cmd = line.split(" ");
                
                if(cmd[0].equals("end")){
    
                    break;
                }else if(cmd[0].equals("status")){
    
                    System.out.println("\n" + colmeia);
                    System.out.print("\naperte qualquer tecla para voltar: ");
                    line = scanner.nextLine();

                }else if(cmd[0].equals("bag")){
                    
                    System.out.print("\n" + colmeia.verInventario());
                    System.out.print("\naperte qualquer tecla para voltar: ");
                    line = scanner.nextLine();

                }else if(cmd[0].equals("produzir")){

                    colmeia.SetorDoMel();
                }else if(cmd[0].equals("criar")){
                    
                    colmeia.SetorCriacao();
                }else if(cmd[0].equals("armazenar")){
    
                    colmeia.Armazenar();
                }else if(cmd[0].equals("pesquisar")){
    
                    colmeia.Pesquisar();
                }else if(cmd[0].equals("explorar")){

                    floresta.explorar(colmeia.getAbelha());
                }else if(cmd[0].equals("curar")){

                    colmeia.getAbelha().curar();
                    System.out.println("\nABELHINHA recuperou sua energia!");
                }else{

                    System.out.println("\nfail: comando invalido");
                }
                
            }
        
    }
    private static Scanner scanner = new Scanner (System.in);    
}
