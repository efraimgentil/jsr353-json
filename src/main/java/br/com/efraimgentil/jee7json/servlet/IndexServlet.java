package br.com.efraimgentil.jee7json.servlet;

import java.io.IOException;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Efraim Gentil (efraim.gentil@gmail.com)
 */
@WebServlet("/hello")
public class IndexServlet extends HttpServlet {
    
    private static final long serialVersionUID = -4762828336024255786L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
         * Para escrever diretamente no response passamos o printWriter para
         * o JsonGenerator, assim quando for realizado o flush ele ira escrever
         * no stream e passara para a tela.
        */
        JsonGenerator generator = Json.createGenerator( resp.getWriter() );
        try {
            /*
             * Para iniciar a escrita de um objeto json é necessário
             * escrever o inicio do objeto para isso o writeStartObject()  
             */
            generator
                .writeStartObject()
                .write("hello", "Hellow World")
                .writeEnd();
            //Ao finalizar o objeto é necessário fechado com o writeEnd()
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Sinaliza o final da escrita passando as informações para o writer
        // que ira "escrever" ná tela.
        generator.flush();
    }
    
}