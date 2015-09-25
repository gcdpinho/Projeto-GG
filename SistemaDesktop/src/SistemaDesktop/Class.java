/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

/**
 * Classe responsável por armazenar as métricas de cada arquivo encontrado.
 * 
 * @author Projeto Fenix
 */
public class Class 
{   
    private String name;
    private int classes, interfaces, children, dit, methods, attributes, lines;
    private boolean isChildren;
    
    /**
     * Método construtor.
     */
    public Class()
    {
        name = "";
        classes = 0;
        interfaces = 0;
        children = 0;
        dit = 0;
        methods = 0;
        attributes = 0;
        lines = 0;
        isChildren = false;
    }
    
    /**
     * Método getter, responsável por retornar se a classe possui ou não pai.
     * 
     * @return boolean - Corresponde ao fato da classe ter ou não pai.
     */
    public boolean isChildren() 
    {
        return isChildren;
    }
    
    /**
     * Método setter, responsável por alterar o estado de possuir ou não pai.
     * 
     * @param isChildren boolean - Corresponde ao valor a ser alterado. 
     */
    public void setIsChildren(boolean isChildren) 
    {
        this.isChildren = isChildren;
    }
    
    /**
     * Método getter, responsável por retornar o nome da classe.
     * 
     * @return String - Corresponde ao nome da classe.
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Método setter, responsável por alterar o nome da classe.
     * 
     * @param name String - Corresponde ao valor a ser alterado. 
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * Método getter, responsável por retornar o número de classes que a própria
     * possui.
     * 
     * @return int - Corresponde ao número de classes da classe.
     */
    public int getClasses() 
    {
        return classes;
    }
    
    /**
     * Método setter, responsável por alterar o número de classes da classe.
     * 
     * @param classes int - Corresponde ao valor a ser alterado. 
     */
    public void setClasses(int classes) 
    {
        this.classes = classes;
    }
    
    /**
     * Método getter, responsável por retornar o número de interfaces que a
     * própria possui.
     * 
     * @return int - Corresponde ao número de interfaces dela.
     */
    public int getInterfaces() 
    {
        return interfaces;
    }
    
    /**
     * Método setter, responsável por alterar o número de interfaces.
     * 
     * @param interfaces int - Corresponde ao valor a ser alterado.
     */
    public void setInterfaces(int interfaces) 
    {
        this.interfaces = interfaces;
    }
    
    /**
     * Método getter, responsável por retornar o número de filhos da classe.
     * 
     * @return int - Corresponde ao número de filhos da classe.
     */
    public int getChildren() 
    {
        return children;
    }
    
    /**
     * Método setter, responsável por alterar o número de filhos da classe.
     * 
     * @param children int - Corresponde ao valor a ser alterado. 
     */
    public void setChildren(int children) 
    {
        this.children = children;
    }
    
    /**
     * Método getter, responsável por retornar a distância dela até a classe 
     * Object.
     * 
     * @return int - Corresponde ao dit da classe.
     */
    public int getDit() 
    {
        return dit;
    }
    
    /**
     * Método setter, responsável por alterar a distância dela até a classe
     * Object.
     * 
     * @param dit int - Corresponde ao valor a ser alterado. 
     */
    public void setDit(int dit) 
    {
        this.dit = dit;
    }
    
    /**
     * Método getter, responsável por retornar o número de métodos da classe.
     * 
     * @return int - Corresponde ao número de métodos da classe. 
     */
    public int getMethods() 
    {
        return methods;
    }
    
    /**
     * Método setter, responsável por alterar o número de métodos da classe.
     * 
     * @param methods int - Corresponde ao valor a ser alterado.
     */
    public void setMethods(int methods) 
    {
        this.methods = methods;
    }
    
    /**
     * Método getter, responsável por retornar o número de atributos da classe.
     * 
     * @return int - Corresponde ao número de atributos da classe.
     */
    public int getAttributes() 
    {
        return attributes;
    }
    
    /**
     * Método setter, responsável por alterar o número de atributos da classe.
     * 
     * @param attributes int - Corresponde ao valor a ser alterado.
     */
    public void setAttributes(int attributes) 
    {
        this.attributes = attributes;
    }
    
    /**
     * Método getter, responsável por retornar o número de linhas da classe.
     * 
     * @return int - Corresponde ao número de linhas da classe.
     */
    public int getLines() 
    {
        return lines;
    }
    
    /**
     * Método setter, responsável por alterar o número de linhas da classe.
     * 
     * @param lines int - Corresponde ao valor a ser alterado.
     */
    public void setLines(int lines) 
    {
        this.lines = lines;
    }
    
}
