/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercvinhos.src;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author vitorassis
 */
public class Vinho {

    private String tipo;
    private String marca;
    private double volume;
    private LocalDate ano;
    private double valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        tipo = tipo.toUpperCase();
        this.tipo = "BRANCO".equals(tipo) || "TINTO".equals(tipo) ? tipo : null;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor >= 0 ? valor : null;
    }

    public Vinho() {
    }

    public Vinho(String tipo, String marca, double volume, LocalDate ano, double valor) {
        this.setTipo(tipo); //  this.tipo = tipo;
        this.setMarca(marca); // this.marca = marca;
        this.setVolume(volume); // this.volume = volume;
        this.setAno(ano); // this.ano = ano;
        this.setValor(valor); // this.valor = valor;
    }

    public Vinho(String tipo, String marca) {
        this.setTipo(tipo); //  this.tipo = tipo;
        this.setMarca(marca); // this.marca = marca;
    }
    
    @Override
    public String toString(){
        String msg="";
        msg+="\t\tTipo: "+getTipo()+"\n";
        msg+="\t\tMarca: "+getMarca()+"\n";
        msg+="\t\tVolume: "+getVolume()+"\n";
        msg+="\t\tAno: "+getAno()+"\n";
        msg+="\t\tValor: "+getValor()+"\n";
        
        return msg;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vinho other = (Vinho) obj;
        if (Double.doubleToLongBits(this.volume) != Double.doubleToLongBits(other.volume)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        return true;
    }
    
    
}
