/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar e calcular a média e desvio padrão dos 
 * atributos por classe.
 * 
 * @author Projeto Fenix
 */
public class NumberOfAttributes extends Metrics
{
    private double average, standartDeviation;
    
    /**
     * Método responsável por calcular a média e desvio padrão dos atributos
     * por classe.
     * 
     * @param metrics ArrayList - Corresponde à lista com as métricas de cada
     * arquivo.
     */
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        double total = 0, variance = 0;
        
        for (int i=0; i<metrics.size(); i++)
            total += metrics.get(i).getAttributes();
        
        average = total/metrics.size();
        
        for (int i=0; i<metrics.size(); i++)
            variance += Math.pow(metrics.get(i).getAttributes()-average, 2);
        
        variance = variance/metrics.size();
        
        standartDeviation = Math.sqrt(variance);
    }
    
    /**
     * Método getter, responsável por retornar a média dos atributos por classe.
     * 
     * @return double - Corresponde à media dos atributos por classe.
     */
    public double getAverage()
    {
        return average;
    }
    
    /**
     * Método getter, responsável por retornar o desvio padrão dos atributos por
     * classe.
     * 
     * @return double - Corresponde ao desvio padrão dos atributos por classe.
     */
    public double getStandartDeviation()
    {
        return standartDeviation;
    }
    
}
