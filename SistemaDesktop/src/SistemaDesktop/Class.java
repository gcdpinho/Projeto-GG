/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

/**
 *
 * @author Gustavo
 */
public class Class 
{   
    private String name;
    private int classes, interfaces, children, dit, methods, attributes, lines;
    
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
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getClasses() 
    {
        return classes;
    }

    public void setClasses(int classes) 
    {
        this.classes = classes;
    }

    public int getInterfaces() 
    {
        return interfaces;
    }

    public void setInterfaces(int interfaces) 
    {
        this.interfaces = interfaces;
    }

    public int getChildren() 
    {
        return children;
    }

    public void setChildren(int children) 
    {
        this.children = children;
    }

    public int getDit() 
    {
        return dit;
    }

    public void setDit(int dit) 
    {
        this.dit = dit;
    }

    public int getMethods() 
    {
        return methods;
    }

    public void setMethods(int methods) 
    {
        this.methods = methods;
    }

    public int getAttributes() 
    {
        return attributes;
    }

    public void setAttributes(int attributes) 
    {
        this.attributes = attributes;
    }

    public int getLines() 
    {
        return lines;
    }

    public void setLines(int lines) 
    {
        this.lines = lines;
    }
    
}
