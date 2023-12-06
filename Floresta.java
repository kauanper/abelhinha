package abelhinha;

import java.util.*;
import java.util.Random;

public class Floresta {
    private Random random;
    private Bamburral bamburral;
    private Marmeleiro marmeleiro;
    private Sabia sabia;
    private Garfanhoto garfanhoto;
    private Borboleta borboleta;
    private Maribondo maribondo;

    public Floresta(){
        random = new Random();
        bamburral = new Bamburral();
        marmeleiro = new Marmeleiro();
        sabia = new Sabia();
        
        
        
    }
    

    public void explorar(Abelha abelhinha){

        System.out.println("\n-------FLORESTA-------\nmuitas plantas para farmar, porem cuidado com a concorrencia!\n");
        String instr = "-------INSTRUCOES\nbuscar -> proucura uma flor ou inseto\nstatus ->  ver status da abelhinha\nbag -> ver inventario\nend -> voltar";

        try{
            
            while(true){

                System.out.println(instr);

                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] cmd = line.split(" ");

                if(cmd[0].equals("end")){
                    
                    break;
                }else if(cmd[0].equals("buscar")){

                    this.sortearDesafio(abelhinha);
                }else if(cmd[0].equals("status")){

                    System.out.println("\n" + abelhinha);
                    System.out.print("\naperte qualquer tecla para voltar: ");
                    line = scanner.nextLine();
                }else if(cmd[0].equals("bag")){
                    System.out.print("\n" + abelhinha.inventario());
                    System.out.print("\naperte qualquer tecla para voltar: ");
                    line = scanner.nextLine();
                }else{

                    System.out.println("fail: comando invalido!");
                }

            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }




    }

    private void sortearDesafio(Abelha abelhinha){
        // 55 -> flor e 45 -> inseto
        int n = random.nextInt(100) + 1;

        if(n >= 1 && n <= 15){
            //BAMRRUBAL -> 15%
            System.out.println(bamburral);
            System.out.println("DESEJA COLETAR?\n(sim/nao)");
            String line = scanner.nextLine();
            System.out.println("$" + line);
            if(line.equals("sim")){
                this.bamburral.ColetarRecursos(abelhinha);
            }else{
                System.out.println("MARMELEIRO nao coletado");
            }

        }else if(n >= 16 && n <= 30){
            //SABIA -> 15%
            System.out.println(sabia);
            System.out.println("DESEJA COLETAR?\n(sim/nao)");
            String line = scanner.nextLine();
            System.out.println("$" + line);
            if(line.equals("sim")){
                this.sabia.ColetarRecursos(abelhinha);
            }else{
                System.out.println("SABIA nao coletado");
            }

        }else if(n >= 31 && n <= 55){
            //MARMELEIRO -> CHANCES DE APARECER 25%
            System.out.println(marmeleiro);
            System.out.println("DESEJA COLETAR?\n(sim/nao)");
            String line = scanner.nextLine();
            System.out.println("$" + line);
            if(line.equals("sim")){
                this.marmeleiro.ColetarRecursos(abelhinha);
            }else{
                System.out.println("MARMELEIRO nao coletado");
            }

        }else if(n >= 55 && n <=70){
            //garfanhoto apareceu
            garfanhoto = new Garfanhoto();
            garfanhoto.Batalha(abelhinha);
        
        }else if(n >= 71 && n <= 85){
            //borboleta apareceu
            borboleta = new Borboleta();
            borboleta.Batalha(abelhinha);

        }else{
            //maribondo aparece
            maribondo = new Maribondo();
            maribondo.Batalha(abelhinha);

        }

    }

    private static Scanner scanner = new Scanner (System.in);
}
