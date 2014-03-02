package br.com.efraimgentil.jsrjson.model;

import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MensagemTest {
    
    private Mensagem mensagem;
    
    @Before
    public void setup(){
        mensagem = new Mensagem();
        mensagem.setMensagem("Mensagem");
        mensagem.setUsuario("Usuario");
        mensagem.setTipo("Tipo");
    }
    
    @Test
    public void dadoUmaMensagemDeveRetornarValoresEmJson() throws IllegalArgumentException, IllegalAccessException{
        JsonObject jObject =  mensagem.getAsJson();
        
        assertNotNull(jObject);
        assertEquals("Mensagem", jObject.getString("mensagem") );
        assertEquals("Usuario", jObject.getString("usuario") );
        assertEquals("Tipo", jObject.getString("tipo") );
    }
    
}