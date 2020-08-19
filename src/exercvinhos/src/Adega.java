/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercvinhos.src;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vitorassis
 */
public class Adega {
    private ArrayList <Fileira> fileiras;
    
    public Adega(){
        fileiras = new ArrayList<Fileira>();
        for(int i = 0; i < 20; i++)
            fileiras.add(new Fileira());
    }
    
    public boolean addVinho(Vinho vinho, int fileira, int posicao){
        boolean posicaoValida = false;
        if(this.isFileiraValida(fileira) && !posicaoValida){
            posicaoValida = fileiras.get(fileira).addVinho(vinho, posicao);
        }
        
        return posicaoValida;
    }
    
    public boolean addVinho(Vinho vinho){
        boolean inserido = false;
        int fileira;
        int posicao;
        Random random = new Random();
        while(!inserido && !this.isAdegaCheia()){
            fileira = random.nextInt(20);
            posicao = random.nextInt(10);
            
            inserido = this.addVinho(vinho, fileira, posicao);
        }
        
        return inserido;
    }
    
    public Vinho getVinho(int fileira, int posicao){
        return this.getFileira(fileira) != null ?
                this.getVinho(fileira, posicao) :
                null;
    }
    
    public Fileira getFileira(int fileira){
        return isFileiraValida(fileira) ? 
                this.fileiras.get(fileira) : 
                null;
    }
    
    public boolean removeVinho(int fileira, int posicao){
        if(this.isFileiraValida(fileira) && this.fileiras.get(fileira) != null){
            return this.fileiras.get(fileira).removeVinho(posicao);
        }
        return false;
    }
    
    public boolean isFileiraValida(int fileira){
        return fileira < 20 && fileira >= 0;
    }
    
    public int getQuantidadeVinhos(){
        int qtd = 0;
        for(Fileira fileira : this.fileiras)
            qtd+= fileira.getQuantidadeVinhos();
        return qtd;
    }
    
    public boolean isAdegaCheia(){
        return this.getQuantidadeVinhos() == 200;
    }
    
    public int getQuantidadeVinhos(String tipo){
        tipo = tipo.toUpperCase();
        if(!"BRANCO".equals(tipo) && !"TINTO".equals(tipo))
            return 0;
        
        int qtd = 0;
        for(Fileira fileira : this.fileiras)
            qtd += fileira.getQuantidadeVinhos(tipo);
        
        return qtd;
    }
    
    public double getValorAgregado(){
        double valor = 0;
        for(Fileira fileira : fileiras)
            valor += fileira.getValorAgregado();
        
        return valor;
    }
    
    public Vinho getMaisAntigo(){
        Fileira maisAntigos = new Fileira(20); //JÁ TEM O MÉTODOS
        for(Fileira fileira : fileiras)
            maisAntigos.addVinho(fileira.getMaisAntigo());
        
        return maisAntigos.getMaisAntigo();
    }
    
    @Override
    public String toString(){
        String msg = "";
        int cont = 1;
        for(Fileira fileira : fileiras){
            msg+="FILEIRA "+(cont++) + "====================\n";
            msg+=fileira.toString();
        }
        return msg;
    }
}
