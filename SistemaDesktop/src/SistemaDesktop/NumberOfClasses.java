/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar e calcular o número de classes do projeto.
 * 
 * @author Projeto Fenix
 */
public class NumberOfClasses extends Metrics
{
    private int numberOfClasses;
    
    /**
     * Método construtor.
     */
    public NumberOfClasses()
    {
        numberOfClasses = 0;
    }
    
    /**
     * Método responsável por calcular o número de classes do projeto.
     * 
     * @param metrics ArrayList - Corresponde à lista com as métricas de cada
     * arquivo.
     */
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        for (int i=0; i<metrics.size(); i++)
            numberOfClasses += metrics.get(i).getClasses();
    }
    
    /**
     * Método getter, responsável por retornar o número de classes do projeto.
     * 
     * @return int - Corresponde ao número de classes do projeto.
     */
    public int getNumberOfClasses()
    {
        return numberOfClasses;
    }
    
}
