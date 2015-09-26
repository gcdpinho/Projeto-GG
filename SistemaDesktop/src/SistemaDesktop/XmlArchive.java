/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

/**
 * Classe responsável pela estruturação e geração do arquvo XML.
 * 
 * @author Projeto Fenix
 */
import Interface.Interface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class XmlArchive 
{
    private Element numOfChildrenSD,metrics,numOfChildren,numOfChildrenAverage,numOfMethods,numOfMethodsSD,numOfMethodsAverage,numOfAttributesSD,numOfAttributesAverage,numOfAttributes,projectMetrics,metricsByClass,numOfClasses,numOfInterfaces, maxDit,linesOfCode,classMetrics;
    private Document document;
    Random gerador;
    
    /**
     * Método construtor.
     * @param answer nome do projeto do usuário
     */
    public XmlArchive(String answer)
    {
        this.metrics = new Element(answer);
        this.document = new Document(metrics);
        this.projectMetrics = new Element ("ProjectMetrics");
        this.metricsByClass = new Element ("MetricsByClass");
        this.numOfClasses = new Element ("NumberOfClasses");
        this.numOfInterfaces = new Element ("NumberOfInterfaces");
        this.maxDit = new Element ("MaximumDIT");
        this.linesOfCode = new Element("LinesOfCode");
        this.classMetrics = new Element ("ClassMetrics");
        this.numOfAttributes = new Element ("NumberOfAttributes");
        this.numOfAttributesAverage = new Element ("Average");
        this.numOfAttributesSD = new Element ("StandartDeviation");
        this.numOfMethods = new Element("NumberOfMethods");
        this.numOfMethodsAverage = new Element ("Average");
        this.numOfMethodsSD = new Element ("StandartDeviation");
        this.numOfChildren = new Element ("NumberOfChildren");
        this.numOfChildrenAverage = new Element ("Average");
        this.numOfChildrenSD = new Element ("StandartDeviation");
        this.gerador = new Random();
    }
    
    /**
     * Método responsável pela geração do XML.
     * 
     * @param inter Interface - Corresponde à interface que contem as métricas.
     * 
     * @param projectName String - Corresponde ao nome do projeto.
     * 
     * @param file File - Corresponde ao arquivo a ser salvo.
     */
    public void generateXML(Interface inter, String projectName, File file)
    {
        numOfClasses.setText(Integer.toString(inter.getNumberOfClasses().getNumberOfClasses()));
        numOfInterfaces.setText(Integer.toString(inter.getNumberOfInterfaces().getNumberOfInterface()));
        maxDit.setText(Integer.toString(inter.getMaxDit().getMaxDit()));
        linesOfCode.setText(Integer.toString(inter.getLinesOfCode().getLinesOfCode()));
        projectMetrics.addContent(numOfClasses);
        projectMetrics.addContent(numOfInterfaces);
        projectMetrics.addContent(maxDit);
        projectMetrics.addContent(linesOfCode);
        metrics.addContent(projectMetrics);        
        numOfAttributesAverage.setText(Double.toString(inter.getNumberOfAttributes().getAverage()));
        numOfAttributesSD.setText(Double.toString(inter.getNumberOfAttributes().getStandartDeviation()));
        numOfMethodsAverage.setText(Double.toString(inter.getNumberOfMethods().getAverage()));
        numOfMethodsSD.setText(Double.toString(inter.getNumberOfMethods().getStandartDeviation()));
        numOfChildrenAverage.setText(Double.toString(inter.getNumberOfChildren().getAverage()));
        numOfChildrenSD.setText(Double.toString(inter.getNumberOfChildren().getStandartDeviation()));
        classMetrics.addContent(numOfAttributes);
        classMetrics.addContent(numOfMethods);
        classMetrics.addContent(numOfChildren);
        
        numOfAttributes.addContent(numOfAttributesAverage);
        numOfAttributes.addContent(numOfAttributesSD);
        numOfMethods.addContent (numOfMethodsAverage);
        numOfMethods.addContent (numOfMethodsSD);
        numOfChildren.addContent (numOfChildrenAverage);
        numOfChildren.addContent(numOfChildrenSD);
        metrics.addContent(classMetrics);
        XMLOutputter xOut = new XMLOutputter();
        try 
        {   FileWriter fw = new FileWriter(file +".xml");
            xOut.output(document, fw);
        }
        catch (IOException ex) 
        {   JOptionPane.showMessageDialog(null, "Não foi possível gerar o arquivo xml, tente novamente.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }    
    }
}



