/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class NumberOfAttributes extends Metrics
{
    private double average, standartDeviation;
    
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
    
    public double getAverage()
    {
        return average;
    }
    
    public double getStandartDeviation()
    {
        return standartDeviation;
    }
    
}
