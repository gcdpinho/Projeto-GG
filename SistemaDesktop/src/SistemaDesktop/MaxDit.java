/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar e calcular o dit máximo do projeto.
 * 
 * @author Projeto Fenix
 */
public class MaxDit extends Metrics
{
    private int maxDit;
    
     /**
     * Método responsável por calcular o dit máximo do projeto.
     * 
     * @param metrics ArrayList - Corresponde à lista com as métricas de cada
     * arquivo.
     */
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        maxDit = metrics.get(0).getDit();
        for (int i=1; i<metrics.size(); i++)
            if (maxDit < metrics.get(i).getDit())
                maxDit = metrics.get(i).getDit();
    }
    
    /**
     * Método getter, responsável por retornar o dit máximo do projeto.
     * 
     * @return int - Corresponde ao dit máximo do projeto.
     */
    public int getMaxDit()
    {
        return maxDit;
    }
    
}
