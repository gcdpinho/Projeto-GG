/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classe abstrata, responsável por ser o ponto de partida da criação das
 * metricas em si.
 * 
 * @author Gustavo
 */
public abstract class Metrics 
{       
    public abstract void calculatesMetric(ArrayList<Class> metrics);
    
}
