package br.com.efraimgentil.jsrjson.servlet;

import java.io.IOException;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.efraimgentil.jsrjson.model.Mensagem;

@WebServlet("/objeto-para-json")
public class ObjetoParaJsonServlet extends HttpServlet {

    private static final long serialVersionUID = 6698389691657261116L;
    
    private static final String PAGINA = "/objeto-para-json.jsp";
    private static final Mensagem mensagem;
    
    static {
        mensagem = new Mensagem();
        mensagem.setMensagem("Olá essa é a mensagem");
        mensagem.setUsuario("usuarioqualquer");
        mensagem.setTipo("PADRAO");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("objMensagem", mensagem);
        req.getRequestDispatcher( PAGINA ).forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        req.setAttribute("objMensagem", mensagem);
        try {
            StringWriter writer = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(writer);
            jsonWriter.writeObject( mensagem.getAsJson() );
            req.setAttribute("resultadoJson", writer.toString() );
        } catch (Exception e) { 
            req.setAttribute("resultadoJson", "Não foi possivel traduzir o objeto para json" );
        }
        req.getRequestDispatcher( PAGINA ).forward(req, resp);
    }
    
}