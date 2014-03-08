<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Objeto para Json</title>
</head>
<body>
    <jsp:include page="/menu.jsp" />

    <form action="" method="post">
        <fieldset>
            <legend>Mensagem</legend>
            <div>
                <label>Mensagem</label> <input type="text" name="mensagem" value="${objMensagem.mensagem}"  disabled/>
            </div>
            <div>
                <label>Usuário</label> <input type="text" name="usuario" value="${objMensagem.usuario}" disabled />
            </div>
            <div>
                <label>Tipo</label> <input type="text" name="tipo" value="${objMensagem.tipo}" disabled />
            </div>
        </fieldset>
        <div>
            <button type="submit">Para JSON</button>
        </div>
    </form>
    
    <div>
        <h2>Resultado JSON</h2>
        <hr/>
        <div>
        ${resultadoJson}
        </div>
    </div>
    
</body>
</html>