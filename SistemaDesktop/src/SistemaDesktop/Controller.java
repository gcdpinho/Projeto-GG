package SistemaDesktop;

import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe responsável por gerenciar as funcionalidades do sistema Desktop.
 * 
 * @author Gustavo
 */
public class Controller 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        Project p = new Project();
        
        //TESTE PASTA
  
        p.getFilesProject();
        //p.getFilesFolder();
        p.firstStep();
        p.secondStep();
        
        ArrayList<Class> c = p.getMetrics();
        
        for (int i=0; i<c.size(); i++)
        {   System.out.println("Nome: "+c.get(i).getName());
            System.out.println("Classes: "+c.get(i).getClasses());
            System.out.println("Interfaces: "+c.get(i).getInterfaces());
            System.out.println("Atributos: "+c.get(i).getAttributes());
            System.out.println("Métodos: "+c.get(i).getMethods());
            //System.out.println("Possui pai: "+ c.get(i).isIsChildren());
            System.out.println("Filhos: "+c.get(i).getChildren());
            System.out.println("Linhas: "+c.get(i).getLines());
            System.out.println();
        }
        
    }
    
}
