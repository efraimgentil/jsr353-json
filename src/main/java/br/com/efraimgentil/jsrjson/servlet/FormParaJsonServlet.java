package br.com.efraimgentil.jsrjson.servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Enumeration;

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
@WebServlet("/form-para-json")
public class FormParaJsonServlet extends HttpServlet {
    
    private static final long serialVersionUID = -517065700344155070L;
    private final String PAGINA  = "/form-para-json.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher( PAGINA ).forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //Trata os parametos como UTF-8
        req.setCharacterEncoding("UTF-8");
        StringWriter writer = new StringWriter();
        //Criando o generator para escrever em uma String atraves do StringWriter
        JsonGenerator generator = Json.createGenerator( writer );
        //Inicia o objeto json
        generator.writeStartObject();
        //Pega todos os parametros do request
        Enumeration<String> params = req.getParameterNames();
        while( params.hasMoreElements() ){
            //Percorre os parametros, para cada parametro será escrito um atributo no objeto JSON
            String paramName =  params.nextElement();
            generator.write( paramName , req.getParameter( paramName )  );
        }
        // Fecha o objeto e sinaliza para escrito no writer
        generator.writeEnd().flush();
        //Retornar o objeto json que agora está contido no writer para a tela como parametro
        req.setAttribute("resultadoJson", writer.toString() );
        req.getRequestDispatcher( PAGINA ).forward(req, resp);
    }
    
}
