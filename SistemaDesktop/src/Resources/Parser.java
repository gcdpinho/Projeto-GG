/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author João Pedro Bretanha
 */
public class Parser {
    String path = "C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\Sistema Desktop\\src\\SistemaDesktop", testaLinha=null;
    int numeroDeLinhas, atributos;
    
    
    ArrayList <String> classes = new ArrayList();
    
    public Parser() throws FileNotFoundException, IOException{
        FileReader arq = new FileReader("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\SistemaDesktop\\src\\SistemaDesktop\\Project.java");
        numeroDeLinhas =0;
        
        String linha;
        BufferedReader lerArq = new BufferedReader(arq);
        while(lerArq.ready()){
            
            linha = lerArq.readLine().toLowerCase();
            
            
            linha = removeComment(linha, -1, -1, lerArq, true);
System.out.println(linha);            
//testClass(linha, 0);
            
            testaLinha = verificaClasse(linha);
            if(linha.length()>1 && (linha.charAt(linha.length()-1) != ')' && linha.charAt(linha.length()-1) != '{') && !linha.contains("(") && !linha.contains("."))
                atributos += verificaAtributos(linha);
            if(testaLinha!=null){
                //System.out.println(testaLinha);

                classes.add(testaLinha);
            }
            numeroDeLinhas++;
        }
        System.out.println(classes);
        System.out.println("Número de linhas: " + numeroDeLinhas);
        System.out.println("numero de atributos: " + atributos);
        arq.close();
    }
    
    private static String  removeComment(String line, int begin, int end, BufferedReader br, boolean flag) throws IOException
    {           
        for (int i=0; i<line.length()-1; i++)
        {   if (begin == -1 && line.charAt(i) == '/' && line.charAt(i+1) == '*')
            {    begin = i;
                //System.out.println (begin);
            }
            if (begin != -1 && line.charAt(i) == '*' && line.charAt(i+1) == '/')
            {    end = i+1;
                
            }
        }
        if (flag && begin == -1)
        {   
            return line;
        
        }
        if (begin != -1 && end == -1)
        {   flag = false;
            line = br.readLine();
            removeComment(line, begin, end, br, flag);
        }
        char[] temp = new char[line.length()-(end-begin+1)];
        if (flag)
        {   //System.out.println(begin); 
            for (int i=0; i<begin; i++)
                temp[i] = line.charAt(i);
        }
        for (int i=end+1; i<line.length(); i++)
            temp[i] = line.charAt(i);
        
        System.out.println (new String(temp));
        return new String(temp);
           
    }
    
    
    public String verificaClasse(String entrada){
       String publiC="public", protecteD="protected", privatE = "private", aux[], clasS ="";
       aux = entrada.split("\\t+|\\s+|\\n");
       if((aux.length>2) &&(aux[0].equals(publiC) || aux[0].equals(privatE) || aux[0].equals(protecteD)) && ("class".equals(aux[1]))){
           clasS = aux[2];
           return clasS;
       }else{
            return null;
       }
    }
    
    public int verificaAtributos(String entrada){
        //public File diretorio = fc.getSelectedFile();
        int numAtributos=0, j=0, m=0;
        String []aux;
        entrada = entrada.replaceAll("\\s+", " ");
        entrada = entrada.replaceAll("^\\s+", "");
        aux = entrada.split("\\s+|\\t+|,");
        
        //Pattern pattern = Pattern.compile("^[^<](\\w.+)");
        Pattern pattern = Pattern.compile("^[^<](\\w+)");
       // Pattern pattern2 = Pattern.compile("\\w+"); (\\w)(\\s+)([\\.,])
        Matcher matcher;
        /*for(int i=0; i<aux.length; i++){
            System.out.println(aux[i]);
        }*/
        //System.out.println(entrada);
        
        if(aux.length>1){
           // System.out.println(aux[0]);
            //matcher = pattern.matcher(aux[0]);
            
            if(aux[0].equals("private") || aux[0].equals("public") || aux[0].equals("protected")){
                if(aux[1].equals("class")){
                        return 0;
                }
                m=2;
                //System.out.println("aqui");
                //System.out.println(aux.length);
                while(m<aux.length){
                    matcher = pattern.matcher(aux[m]);
                    //System.out.println(aux[m]);
                    if(matcher.find() && aux[m].charAt(aux[m].length()-1) != '{' && aux[m].charAt(aux[m].length()-1) != ')' ){
                        //System.out.println(aux[m]);
                       // System.out.println(aux[m].charAt(0));
                        System.out.println(aux[m]);
                        numAtributos++;
                        m++;
                        
                    }else
                        m++;
                }
                return numAtributos;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
    }
    
}
