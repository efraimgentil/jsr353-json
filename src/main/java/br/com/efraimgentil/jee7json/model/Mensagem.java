package br.com.efraimgentil.jee7json.model;

import java.lang.reflect.Field;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.json.spi.JsonProvider;

public class Mensagem {
    
    private String mensagem;
    private String usuario;
    private String type;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
