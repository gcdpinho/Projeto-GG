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
    
    /**
     * Método construtor.
     */
    public Project()
    {
        files = new ArrayList<>();
        metrics = new ArrayList<>();
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
    
    private ArrayList<String> removeComment() throws IOException
    {
        ArrayList<String> fileNoComment = new ArrayList<>();
        
        for (int i=0; i<files.size(); i++)
        {   String file = fileToString (files.get(i), i);
            int index = 0;
            char[] temp = new char[file.length()];
            //System.out.println(file);
        
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
            fileNoComment.add(stringTemp);
        }
        
        return fileNoComment;
    }
    
    public void parser() throws IOException
    {   
        ArrayList<String> filesNoComment = removeComment();
        String[] splitSpace;
        int atrib, countComma, methods;
        boolean flagClass, flagMethod;
        
        for (int i=0; i<filesNoComment.size(); i++)
        {   atrib = 0;
            methods = 0;
            flagClass = false;
            flagMethod = false;
            //System.out.println(filesNoComment.get(i));
            splitSpace = filesNoComment.get(i).split(" ");
            for (int j=0; j<splitSpace.length; j++)
            {   if ((splitSpace[j].contains("public") || splitSpace[j].contains("protected") || splitSpace[j].contains("private")) && !splitSpace[j].contains("\""))
                {   countComma = 0;
                    //Classe
                    for (int t=j+1; t<splitSpace.length; t++)
                        if (splitSpace[t].equals("class"))
                        {   flagClass = true;
                            break;
                        }
                    //Método
                    if (!flagClass)
                        for (int t=j+1; t<splitSpace.length; t++)
                        {   if (splitSpace[t].contains(";"))
                                break;
                            if (splitSpace[t].contains("("))
                            {   flagMethod = true;
                                methods++;
                                //System.out.println(splitSpace[t]);
                                break;
                            }
                        }
                    //Atributos
                    if (!flagClass && !flagMethod)
                    {   for (int t=j+1; t<splitSpace.length; t++)
                        {   if (splitSpace[t].contains(",") && !splitSpace[t].contains("\""))
                            {   countComma += splitSpace[t].length() - splitSpace[t].replaceAll(",", "").length();
                                //System.out.println(splitSpace[j]);
                            }
                            if (splitSpace[t].contains(";"))
                                break;
                        }
                        if (countComma != 0)
                            atrib += countComma+1;
                        else
                            if (!splitSpace[j].contains("\""))
                            {   atrib++;
                                //System.out.println (splitSpace[j+1]);
                            }
                    }
                    flagClass = false;
                    flagMethod = false;
                }
            }
            metrics.get(i).setAttributes(atrib);
            metrics.get(i).setMethods(methods);
        }
    }
    
    public ArrayList<Class> getMetrics()
    {
        return metrics;
    }
}
