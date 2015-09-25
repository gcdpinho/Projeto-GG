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
public class LinesOfCode extends Metrics
{
    private int linesOfCode;
    
    public LinesOfCode()
    {
        linesOfCode = 0;
    }
    
    @Override
    public void calculatesMetric(ArrayList<Class> metrics)
    {   
        for (int i=0; i<metrics.size(); i++)
        {   linesOfCode += metrics.get(i).getLines();
            //System.out.println(metrics.get(i).getName()+"\n"+metrics.get(i).getLines());
        }
    }   
    
    public int getLinesOfCode() 
    {
        return linesOfCode;
    }
    
}
