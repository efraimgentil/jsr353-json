package br.com.efraimgentil.jsrjson.model;

import java.lang.reflect.Field;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Mensagem {
    
    private String mensagem;
    private String usuario;
    private String tipo;


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public JsonObject getAsJson() throws IllegalArgumentException, IllegalAccessException{
        //Criar um builder de um objeto Json
        JsonObjectBuilder jBuilder = Json.createObjectBuilder();
        //Reflection para pegar todos os campos do objeto
        Field[] fields = Mensagem.class.getDeclaredFields();
        for (Field field : fields) {
            //Aqui digo que os campos privados agora são acessiveis
            field.setAccessible(true);
            /*
             * field.getName() retorna o nome do campo
             * field.get(this) retorna o valor do campo da instancia atual de Mensagem
             */
            jBuilder.add( field.getName() , String.valueOf( field.get(this) ) );
        }
        //Por fim o build() para montar o JsonObject e retornalo para uso
        return jBuilder.build();
    }

}
