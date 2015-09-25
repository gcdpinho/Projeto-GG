/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar e calcular as linhas de código do projeto.
 * 
 * @author Projeto Fenix
 */
public class LinesOfCode extends Metrics
{
    private int linesOfCode;
    
    /**
     * Método construtor.
     */
    public LinesOfCode()
    {
        linesOfCode = 0;
    }
    
    /**
     * Método responsável por calcular o número de linhas do projeto.
     * 
     * @param metrics ArrayList - Corresponde à lista com as métricas de cada
     * arquivo.
     */
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {   
        for (int i=0; i<metrics.size(); i++)
        {   linesOfCode += metrics.get(i).getLines();
            //System.out.println(metrics.get(i).getName()+"\n"+metrics.get(i).getLines());
        }
    }   
    
    /**
     * Método getter, responsável por retornar as linhas de código do projeto.
     * 
     * @return int - Corresponde ao número de linhas do projeto.
     */
    public int getLinesOfCode() 
    {
        return linesOfCode;
    }
    
}
