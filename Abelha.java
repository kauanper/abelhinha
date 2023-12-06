package abelhinha;

import java.util.*;

public class Abelha {
    private int vida;
    private int veneno;
    private int defesa;
    private int ferrao;
    private TreeMap<String, Integer> inventario;
    private int venenoMax;
    private int defesaMax;
    private int ferraoMax;

    public Abelha(){
        this.vida = 10;
        this.veneno = 10;
        this.defesa = 10;
        this.ferrao = 5;
        this.inventario = new TreeMap<>();
        this.venenoMax = 10;
        this.defesaMax = 10;
        this.ferraoMax = 5;

        this.inventario.put("Garras", 4); //ata drop garfanhoto
        this.inventario.put("Asas", 4); //def drop borboleta
        this.inventario.put("Ferrao", 4); // drop maribomdo
        this.inventario.put("Polen", 0);
        this.inventario.put("Nectar", 0);
        this.inventario.put("Mel", 0);
    }    

    public int getVida() {
        return vida;
    }

    public int getVeneno() {
        return veneno;
    }

    public int getFerrao(){
        return ferrao;
    }    

    public int getDefesa() {
        return defesa;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFerrao() {
        
        if(this.ferrao != 0){
            this.ferrao--;
        }

    }

    public int valorInventario(String key){

        int i = this.inventario.get(key);

        return i;
    }

    public void alteraInventario(String key, int valor, boolean k){

        if(k){
            this.inventario.put(key, valor);
        }else{
            
            int novoValor = this.inventario.get(key) + valor;
            this.inventario.put(key, novoValor);

        }

    }

    public void setMel(int i){

        int k = this.inventario.get("Mel") + i;
        this.inventario.put("Mel", k);
    }

    public void setInventario(String item){

        int k = this.inventario.get(item) + 2;

        this.inventario.put(item, k);
        
    }

    public boolean ChecarFerrao(){

        if(this.ferrao == 0){
            return false; // não pode batalhar
        }

        return true; // pode batalhar
    }

    public boolean ChecarItens(String item){

        if(this.inventario.get(item) >= 2){

            return true; //quantidade suficiente para upar
        }else{

            return false; //insuficiente
        }

    }

    //BATALHA
    public void dano(int dano){ //abelhinha recebe dano
        dano = dano / this.defesa;
        this.vida -= dano;
    }

    public boolean checarVida(){

        if(this.vida <= 0){
            return true; //abelhinha morreu
        }

        return false; //abelhinha nao morreu
    }

    public void zerarInventario(){

        for(String key : this.inventario.keySet()){
            this.inventario.put(key, 0);
        }

    }

    public void zerarFerrao(){
        this.ferrao = 0;
    }

    //UPAR ABELHINHA
    public void venenoMax(){
        this.venenoMax++;
        this.veneno = this.venenoMax;
    }

    public void defesaMax(){
        this.defesaMax++;
        this.defesa = this.defesaMax;
    }

    public void ferraoMax(){
        this.ferraoMax++;
        this.ferrao = ferraoMax;
    }

    //CURAR ABELHINHA
    public void curar(){
        this.veneno = this.venenoMax;
        this.defesa = this.defesaMax;
        this.ferrao = ferraoMax;
        this.vida = 10;
    }

    @Override
    public String toString() {
        
        String s = "";

        s += "Vida: " + this.getVida() + "\n";
        s += "Veneno: " + this.getVeneno() + "\n";
        s += "Defesa: " + this.getDefesa() + "\n";
        s += "Ferrao : " + this.getFerrao();
        return s;
    }

    public String inventario(){

        String s ="";

        for(String key : this.inventario.keySet()){

            s += key + " : " + this.inventario.get(key) + "\n";
        }

        return s;
    }


}
