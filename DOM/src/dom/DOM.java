/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import java.io.BufferedReader;
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
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        pruebas.Lienzo.main(args);
        //pruebas.webScrapper.main(args);
        
        /*
        URL url = new URL("https://www.eltiempo.com");
        BufferedReader bs = new BufferedReader(new InputStreamReader(url.openStream()));
        String txt;
        while ((txt = bs.readLine()) != null) System.out.print(txt.contains("<") ||txt.contains("</")||txt.contains("/>")? txt+"\n": "\n");
        */
        
    }
    
}
