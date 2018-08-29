/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author rpayan
 */
public class DOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UserGUI.main(args);
        
    }
    
    public static void getCode(String urlstr, String FileName){
        try{
            java.net.URL url = new java.net.URL(urlstr);
            BufferedReader bs = new BufferedReader(new java.io.InputStreamReader(url.openStream()));
            BufferedWriter doc = new BufferedWriter(new FileWriter(FileName));
            String txt;
            while ((txt = bs.readLine()) != null){
                while(txt.contains(">"))
                {
                    if(!txt.startsWith("<")){
                        if(txt.startsWith("<=")) txt = txt.substring(1);
                        txt = txt.substring(txt.indexOf("<"));
                    }
                    //doc.write(txt.substring(0,txt.indexOf(">")+1));
                    doc.write(get_label(txt.substring(0,txt.indexOf(">")+1)));
                    txt = txt.substring(txt.indexOf(">")+1);
                    doc.newLine();
                }
            }
            bs.close();
            doc.close();
        }
        catch(java.net.MalformedURLException mue){
            System.out.println("Error de formato de url");
            mue.printStackTrace();
        }
        catch(java.io.IOException ioe){
            System.out.println("Error de archivo");
            ioe.printStackTrace();
        }
        catch(Throwable t)
        {
            System.out.println("no fué posible establecer la conexión");
            t.printStackTrace();
        }
    }
    
    public static String get_label(String txt){
        if(txt.contains("   ")){
            txt.replace("   "," ");
        }
        
        if( (!(txt.contains(" "))) || txt.startsWith("</") ){
            return txt.substring(1,txt.length()-1);
        }
        
        boolean retpar = txt.endsWith("/>");
        txt = txt.substring(0,txt.indexOf(" "));
        
        while(txt.startsWith(" ")){
            txt = txt.substring(1);
        }
        
        //return (retpar)? txt.substring(1)+"/" : txt.substring(1);
        if(txt.contains("meta") || txt.contains("link") || txt.contains("img")){
            return txt.substring(1)+"/";    
        }
        return txt.substring(1);
    }
    
    public static void rewrite(String input_file, String output_file){
        try{
            BufferedReader bs = new BufferedReader(new java.io.FileReader(input_file));
            BufferedWriter doc = new BufferedWriter(new FileWriter(output_file));
            String txt;
            while ((txt = bs.readLine()) != null){
                if(txt.endsWith("/")){
                    doc.write(txt.substring(0,txt.length()-1)); 
                    doc.newLine();
                    doc.write("/"+txt.substring(0,txt.length()-1)); 
                    doc.newLine();
                }
                else{
                    doc.write(txt);
                    doc.newLine();
                }
            }
            bs.close();
            doc.close();
        }
        catch(Exception e){
            System.out.println("Error de archivo:");
            e.printStackTrace();
        }
    }
    
    
}
