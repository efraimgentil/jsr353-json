<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="/menu.jsp" />

    <form action="" method="post">
        <div>
            <label>Nome</label> <input type="text" name="nome" />
        </div>
        <div>
            <label>E-mail</label> <input type="text" name="email" />
        </div>
        <div>
            <label>Telefone</label> <input type="text" name="telefone" />
        </div>
        <div>
            <label>Observação</label>
            <textarea name="observacao" rows="3" cols="6"></textarea>
        </div>
        <div>
            <button type="submit">Para JSON</button>
            <button type="reset">Limpar</button>
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