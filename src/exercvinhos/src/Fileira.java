/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercvinhos.src;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author vitorassis
 */
public class Fileira {

    private ArrayList<Vinho> vinhos;
    int max;
    private int count;
    
    public Fileira() {
        this(10);
    }
    
    public Fileira(int max) {
        vinhos = new ArrayList<Vinho>();
        this.max = max;
        
        for (int i = 0; i < max; i++) {
            vinhos.add(new Vinho());
        }
        
        count = 0;
    }
    
    public boolean addVinho(Vinho vinho, int posicao) {
        if (this.isPosicaoValida(posicao) && !isPosicaoOcupada(posicao)) {
            this.vinhos.set(posicao, vinho);
            return true;
        }
        return false;
    }
    
    public void addVinho(Vinho vinho) {
        count += this.addVinho(vinho, count) ? 1 : 0;
    }
    
    public Vinho getVinho(int posicao) {
        return this.isPosicaoValida(posicao)
                ? this.vinhos.get(posicao)
                : null;
    }
    
    public boolean removeVinho(int posicao) {
        if (this.isPosicaoValida(posicao) && this.vinhos.get(posicao) != null) {
            this.vinhos.remove(posicao);
            return true;
        }        
        return false;
    }
    
    public boolean isPosicaoValida(int posicao) {
        return posicao >= 0 && posicao < max && this.vinhos.size() <= max;
    }
    
    public int getQuantidadeVinhos() {
        return this.vinhos.size();
    }
    
    public int getQuantidadeVinhos(String tipo) {
        tipo = tipo.toUpperCase();
        if (!"BRANCO".equals(tipo) && !"TINTO".equals(tipo)) {
            return 0;
        }
        
        int qtd = 0;
        for (Vinho vinho : this.vinhos) {
            if (!vinho.equals(new Vinho())) {
                qtd += vinho.getTipo().equals(tipo) ? 1 : 0;
            }
        }
        
        return qtd;
    }
    
    public double getValorAgregado() {
        double valor = 0;
        for (Vinho vinho : vinhos) {
            valor += vinho.getValor();
        }
        
        return valor;
    }
    
    public Vinho getMaisAntigo() {
        LocalDate menorAno = LocalDate.MAX;
        Vinho maisAntigo = new Vinho();
        for (Vinho vinho : vinhos) {
            if (vinho.getAno() != null) {
                if (vinho.getAno().compareTo(menorAno) < 0) {
                    menorAno = vinho.getAno();
                    maisAntigo = vinho;
                }
            }
        }
        
        return maisAntigo;
    }
    
    public boolean isPosicaoOcupada(int posicao) {
        if (!this.isPosicaoValida(posicao)) {
            return true;
        }
        if (this.vinhos.get(posicao).equals(new Vinho())) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        String msg = "";
        int cont = 1;
        for (Vinho vinho : vinhos) {
            msg += "\tPOSIÇÃO " + (cont++) + "***********\n";
            msg += vinho.toString();
        }
        
        return msg;
    }
}
