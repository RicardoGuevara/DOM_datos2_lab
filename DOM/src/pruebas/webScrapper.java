package pruebas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;



//clase auxiliar
public class webScrapper {

	public static void main(String[] args)  {
		try {
			URL my_url = new URL("https://www.eltiempo.com");
			
                        rastrear(my_url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
        public static void rastrear(URL url){
            try {
                boolean esValida;
                try {
                  URLConnection connection = url.openConnection();
                  connection.connect();
                  if ( (connection.getContentType()!=null) && !connection.getContentType().toLowerCase().startsWith("text/") ) {
                    esValida=false;
                  }else{
                    esValida=true;
                  }
                } catch ( IOException e ) {
                  esValida=false;
                }

                if(esValida){
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    HTMLEditorKit.Parser parse = new HTMLParse().getParser();
                    //escribir enlaces de una página
                    parse.parse(br,new Parser(url),true);

                }else{
                    System.out.println("No es una página válida");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}       
 class HTMLParse extends HTMLEditorKit {

  public HTMLEditorKit.Parser getParser()
  {
    return super.getParser();
  }
}
//clase auxiliar
class Parser
  extends HTMLEditorKit.ParserCallback {
    protected URL url;

    public Parser(URL base)
    {
      this.url = base;
    }

    public void handleStartTag(HTML.Tag t, MutableAttributeSet a,int pos)
    {
      System.out.println("<"+t+"> pvto el que lo lea v:");

    }

    
  }