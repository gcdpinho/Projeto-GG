/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDesktop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Classe responsável por percorrer o diretório e retornar os arquivos .java
 * encontrados em uma lista.
 * 
 * @author Gustavo
 */
public class Project 
{
    private ArrayList<File> files;
    private ArrayList<Class> metrics;
    private ArrayList<String> filesNoComment;
    
    /**
     * Método construtor.
     */
    public Project()
    {
        files = new ArrayList<>();
        metrics = new ArrayList<>();
        filesNoComment = new ArrayList<>();
    }
    
    /**
     * Método responsável por percorrer uma pasta e encontrar os arquivos .java.
     */
    public void getFilesFolder() 
    {  
        JFileChooser fc;
        fc = new JFileChooser();  
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(null);  
  
        if(res == JFileChooser.APPROVE_OPTION)
        {   File diretory = fc.getSelectedFile();
            File folders[] = diretory.listFiles();
             for (int i=0; i<folders.length; i++)
                searchJava(folders[i]);
        }
        else
            JOptionPane.showMessageDialog(null, "Você não escolheu nenhum diretório."); 
    }
    
    /**
     * Método responsável por percorrer o raiz do projeto e encontrar os
     * arquivos .java.
     */
    public void getFilesProject() 
    {       
        JFileChooser fc;
        fc = new JFileChooser();  
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(null);  
        if(res == JFileChooser.APPROVE_OPTION)
        {   File diretory = fc.getSelectedFile();
            File[] folders = diretory.listFiles();
            boolean flag = false;
            for (int i=0; i<folders.length; i++)
            {   File subPaste = folders[i];
                //pasta src do projeto, raiz da arvore
                if(subPaste.getName().equals("src"))
                {   searchJava(subPaste);
                    flag = true;
                }
            }
            if(!flag)
                JOptionPane.showMessageDialog(null, "Você não selecionou um projeto Java."); 
            
       }
       else
            JOptionPane.showMessageDialog(null, "Você não escolheu nenhum diretório."); 
    }
    
    /**
     * Método responsável por auxiliar o getFilesProject na busca pelos arquivos
     * .java na pasta raiz do projeto.
     * 
     * @param diretory File - Corresponde ao diretório a ser percorrido.
     */
    private void searchJava(File diretory)
    {           
        if(diretory.isDirectory())
        {   String[] tree = diretory.list();
            for(int i=0; i<tree.length; i++)
            {   File tempFile = new File(diretory, tree[i]);
                if(tempFile.isFile())
                {   if(tempFile.getName().toLowerCase().endsWith(".java"))
                    {   files.add(tempFile);
                        Class classTemp = new Class();
                        classTemp.setName(tempFile.getName());
                        metrics.add(classTemp);
                    }   
                }
                else 
                    if(tempFile.isDirectory()) 
                        searchJava(tempFile);     
            }
        }
        else
            if(diretory.getName().toLowerCase().endsWith(".java"))
            {   files.add(diretory);     
                Class classTemp = new Class();
                classTemp.setName(diretory.getName());
                metrics.add(classTemp);
            }
    }
    
    private String fileToString(File file, int i) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int countLine = 1;
        
        while(br.ready())
        {   line += "\n" + br.readLine();
            countLine++;
        }
        
        metrics.get(i).setLines(countLine);
        
        return line;
    }
    
    private void removeComment() throws IOException
    {        
        for (int i=0; i<files.size(); i++)
        {   String file = fileToString (files.get(i), i);
            int index = 0;
            char[] temp = new char[file.length()];
        
            for (int j=0; j<file.length()-1; j++)
            {   if (file.charAt(j) == '/' && file.charAt(j+1) == '*')
                {   j+=2;
                    while(file.charAt(j) != '*' || file.charAt(j+1) != '/')
                        j++;
                    j+=2;
                }
                if (file.charAt(j) == '/' && file.charAt(j+1) == '/')
                {   j+=2;
                    while (file.charAt(j) != '\n')
                        j++;
                    j++;
                }
                temp[index] = file.charAt(j);
                index++;
            }
            temp[index] = file.charAt(file.length()-1);
            String stringTemp = new String(temp);
            stringTemp = stringTemp.replaceAll("\\s+|\\t+", " ");
            stringTemp = stringTemp.replaceAll("^\\s", "");
            filesNoComment.add(stringTemp);
        }
    }
    
    public void firstStep() throws IOException
    {   
        removeComment();
        String[] splitSpace;
        int atrib, countComma, methods, classes, interfaces;
        boolean flagClass, flagMethod, flagInterface;
        
        for (int i=0; i<filesNoComment.size(); i++)
        {   atrib = 0;
            methods = 0;
            classes = 0;
            interfaces = 0;

            splitSpace = filesNoComment.get(i).split(" ");
            for (int j=0; j<splitSpace.length; j++)
            {   flagClass = false;
                flagMethod = false;
                flagInterface = false;
                if ((splitSpace[j].contains("public") || splitSpace[j].contains("protected") || splitSpace[j].contains("private")) && !splitSpace[j].contains("\""))
                {   countComma = 0;
                    //Classe
                    for (int t=j+1; t<splitSpace.length; t++)
                    {   if (splitSpace[t].contains(";"))
                            break;
                        if (splitSpace[t].equals("class"))
                        {   flagClass = true;
                            classes++;
                            for (int w=t+1; w<splitSpace.length; w++)
                                if ((splitSpace[w].contains("extends") || splitSpace[w].contains("implements")) && !splitSpace[w].contains("\""))
                                {   metrics.get(i).setIsChildren(true);
                                    break;
                                }
                            break;
                        }
                    }
                    //Interface
                    if (!flagClass)
                        for (int t=j+1; t<splitSpace.length; t++)
                        {   if (splitSpace[t].contains(";"))
                                break;
                            if (splitSpace[t].equals("interface"))
                            {   flagInterface = true;
                                interfaces++;
                                for (int w=t+1; w<splitSpace.length; w++)
                                    if (splitSpace[w].contains("extends") || splitSpace[w].contains("implements"))
                                    {   metrics.get(i).setIsChildren(true);
                                        break;
                                    }
                                break;
                            }
                        }
                    //Método
                    if (!flagClass && !flagInterface)
                        for (int t=j+1; t<splitSpace.length; t++)
                        {   if (splitSpace[t].contains(";"))
                                break;
                            if (splitSpace[t].contains("("))
                            {   flagMethod = true;
                                methods++;
                                break;
                            }
                        }
                    //Atributos
                    if (!flagClass && !flagMethod && !flagInterface)
                    {   for (int t=j+1; t<splitSpace.length; t++)
                        {   if (splitSpace[t].contains(",") && !splitSpace[t].contains("\""))
                                countComma += splitSpace[t].length() - splitSpace[t].replaceAll(",", "").length();
                            if (splitSpace[t].contains(";"))
                                break;
                        }
                        if (countComma != 0)
                            atrib += countComma+1;
                        else
                            if (!splitSpace[j].contains("\""))
                                atrib++;
                    }
                }
            }
            metrics.get(i).setClasses(classes);
            metrics.get(i).setAttributes(atrib);
            metrics.get(i).setMethods(methods);
            metrics.get(i).setInterfaces(interfaces);
        }
    }
    
    public void secondStep()
    {   
        String[] splitSpace;
        String temp;
        char[] aux;
        int index;
        
        for (int i=0; i<metrics.size(); i++)
        {   temp = "";
            index = 0;
            if (metrics.get(i).isIsChildren())
            {   splitSpace = filesNoComment.get(i).split(" ");
                for (int j=0; j<splitSpace.length; j++)
                {   if ((splitSpace[j].contains("public") || splitSpace[j].contains("protected") || splitSpace[j].contains("private")) && !splitSpace[j].contains("\""))
                    {   //Classe
                        for (int t=j+1; t<splitSpace.length; t++)
                        {   if (splitSpace[t].contains(";"))
                                break;
                            if (splitSpace[t].equals("class") || splitSpace[t].endsWith("interface"))
                            {   for (int w=t+1; w<splitSpace.length; w++)
                                    if ((splitSpace[w].contains("extends") || splitSpace[w].contains("implements")) && !splitSpace[w].contains("\""))
                                    {   if (splitSpace[w+1].contains("{"))
                                        {   aux = new char[splitSpace[w+1].length()];
                                            for (int x=0; x<splitSpace[w+1].length(); x++)
                                            {   if (splitSpace[w+1].charAt(x) == '{')
                                                    break;
                                                aux[index] = splitSpace[w+1].charAt(x);
                                                index++;
                                            }
                                            temp = new String(aux, 0, index);
                                        }
                                        else
                                            temp = splitSpace[w+1];
                                        break;
                                    }
                                break;
                            }
                        }
                        if (!temp.equals(""))
                            for (int t=0; t<metrics.size(); t++)
                                if (metrics.get(t).getName().contains(temp+".java"))
                                {   metrics.get(t).setChildren(metrics.get(t).getChildren()+1);
                                    break;
                                }
                    }                
                }
            }    
        }
    }
    
    public ArrayList<Class> getMetrics()
    {
        return metrics;
    }
}
