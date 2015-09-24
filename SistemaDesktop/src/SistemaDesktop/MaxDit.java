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
public class MaxDit extends Metrics
{
    private int maxDit;
    
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {
        maxDit = metrics.get(0).getDit();
        for (int i=1; i<metrics.size(); i++)
            if (maxDit < metrics.get(i).getDit())
                maxDit = metrics.get(i).getDit();
    }
    
    public int getMaxDit()
    {
        return maxDit;
    }
    
}
