/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar as funcionalidades do sistema Desktop.
 * 
 * @author Gustavo
 */
public class Controller 
{
    /**
     * Método main.
     * 
     * @param args String[] - Corresponde aos argumentos de linha de comando.
     * 
     * @throws java.io.IOException - Corresponde à exceção vinculada à leitura
     * dos arquivos.
     */
    public static void main(String[] args) throws IOException 
    {
        Project p = new Project();
  
        p.getFilesProject();
        //p.getFilesFolder();
        p.firstStep();
        p.secondStep();
        p.thirdStep();
        
        ArrayList<Class> c = p.getMetrics();
        
        LinesOfCode l = new LinesOfCode();
        l.calculatesMetric(c);
        
        MaxDit m = new MaxDit();
        m.calculatesMetric(c);
        
        NumberOfAttributes noa = new NumberOfAttributes();
        noa.calculatesMetric(c);
        
        NumberOfChildren noc = new NumberOfChildren();
        noc.calculatesMetric(c);
        
        NumberOfClasses nocl = new NumberOfClasses();
        nocl.calculatesMetric(c);
        
        NumberOfInterfaces noi = new NumberOfInterfaces();
        noi.calculatesMetric(c);
        
        NumberOfMethods nom = new NumberOfMethods();
        nom.calculatesMetric(c);

            System.out.println("Classes: "+nocl.getNumberOfClasses());
            System.out.println("Interfaces: "+noi.getNumberOfInterface());
            System.out.println("Atributos:\nMédia: "+noa.getAverage()+"\nDesvio Padrão:"+noa.getStandartDeviation());
            System.out.println("Métodos: \nMédia: "+nom.getAverage()+"\nDesvio Padrão:"+nom.getStandartDeviation());;
            System.out.println("Dit: "+m.getMaxDit());
            //System.out.println("Possui pai: "+ c.get(i).isChildren());
            System.out.println("Filhos: \nMédia: "+noc.getAverage()+"\nDesvio Padrão:"+noc.getStandartDeviation());
            System.out.println("Linhas: "+l.getLinesOfCode());
         
    }
    
}
