/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classes responsável por armazenar e calcular o número de interfaces do
 * projeto.
 * 
 * @author Projeto Fenix
 */
public class NumberOfInterfaces extends Metrics
{
    private int numberOfInterface;
    
    /**
     * Método construtor.
     */
    public NumberOfInterfaces()
    {
        numberOfInterface = 0;
    }
    
    /**
     * Método responsável por calcular o número de interfaces do projeto.
     * 
     * @param metrics ArrayList - Corresponde à lista com as métricas de cada
     * arquivo.
     */
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        for (int i=0; i<metrics.size(); i++)
            numberOfInterface += metrics.get(i).getInterfaces();
    }
    
    /**
     * Método getter, responsável por retornar o número de interfaces do
     * projeto.
     * 
     * @return int - Corresponde ao número de interfaces do projeto.
     */
    public int getNumberOfInterface()
    {
        return numberOfInterface;
    }
    
}
