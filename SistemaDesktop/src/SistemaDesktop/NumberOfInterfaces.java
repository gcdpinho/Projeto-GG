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
public class NumberOfInterfaces extends Metrics
{
    private int numberOfInterface;
    
    public NumberOfInterfaces()
    {
        numberOfInterface = 0;
    }
    
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        for (int i=0; i<metrics.size(); i++)
            numberOfInterface += metrics.get(i).getInterfaces();
    }
    
    public int getNumberOfInterface()
    {
        return numberOfInterface;
    }
    
}
