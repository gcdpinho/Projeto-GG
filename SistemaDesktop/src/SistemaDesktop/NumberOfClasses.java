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
public class NumberOfClasses extends Metrics
{
    private int numberOfClasses;
    
    public NumberOfClasses()
    {
        numberOfClasses = 0;
    }
    
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        for (int i=0; i<metrics.size(); i++)
            numberOfClasses += metrics.get(i).getClasses();
    }
    
    public int getNumberOfClasses()
    {
        return numberOfClasses;
    }
    
}
