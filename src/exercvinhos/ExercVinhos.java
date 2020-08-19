/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercvinhos;

import exercvinhos.src.*;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author vitorassis
 */
public class ExercVinhos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Adega adega = new Adega();
        adega.addVinho(new Vinho("tinto", "Casillero Del Diablo", 1000, LocalDate.of(1989, Month.JANUARY, 1), 1500), 0, 0);
        adega.addVinho(new Vinho("branco", "Viapiana", 1000, LocalDate.of(2020, Month.JANUARY, 1), 500), 1, 7);
        adega.addVinho(new Vinho("branco", "Viapiana", 1000, LocalDate.of(2020, Month.JANUARY, 1), 500), 19, 0);

        
        System.out.println(adega);
        
        System.out.println("Mais Antigo:\n"+adega.getMaisAntigo());
        System.out.println("Valor agregado: "+ adega.getValorAgregado());
        
        System.out.println("Quantidade de Tintos: "+adega.getQuantidadeVinhos("tinto"));
        System.out.println("Quantidade de Brancos: "+adega.getQuantidadeVinhos("branco"));
    }
    
}
