/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.util.ArrayList;

/**
 * Classe abstrata, responsável por ser o ponto de partida da criação das
 * métricas em si.
 * 
 * @author Projeto Fenix
 */
public abstract class Metrics 
{   
    /**
     * Método abstrato que será implementado nas classes das métricas que
     * implementarão esta.
     * 
     * @param metrics ArrayList - Corresponde à lista com as métricas de cada
     * arquivo.
     */
    public abstract void calculatesMetric(ArrayList<Class> metrics);
    
}
