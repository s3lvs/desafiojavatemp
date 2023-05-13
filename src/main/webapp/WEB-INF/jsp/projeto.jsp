<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Projeto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Cadastro de Projeto</h1>
    <form:form method="post" action="/projetos/salvar-projeto" modelAttribute="projeto" class="form-horizontal" enctype="application/json">
    <div class="form-group">
        <label for="nome" class="col-sm-2 control-label">Nome:</label>
        <div class="col-sm-10">
            <form:input path="nome" id="nome" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="dataInicio" class="col-sm-2 control-label">Data de Início:</label>
        <div class="col-sm-10">
            <form:input type="date" path="dataInicio" id="dataInicio" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="gerente" class="col-sm-2 control-label">Gerente Responsável:</label>
        <div class="col-sm-10">
            <form:select path="gerente" id="gerente" class="form-control">
                <c:forEach var="gerente" items="${gerentes}">
                    <form:option value="${gerente.id}" label="${gerente.nome}"/>
                </c:forEach>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="dataPrevisaoFim" class="col-sm-2 control-label">Previsão de Término:</label>
        <div class="col-sm-10">
            <form:input type="date" path="dataPrevisaoFim" id="dataPrevisaoFim" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="dataFim" class="col-sm-2 control-label">Data Real de Término:</label>
        <div class="col-sm-10">
            <form:input type="date" path="dataFim" id="dataFim" class="form-control"/>
        </div>
    </div>

        <div class="form-group">
            <label for="orcamento" class="col-sm-2 control-label">Orçamento:</label>
            <div class="col-sm-10">
                <form:input path="orcamento" id="orcamento" class="form-control"/>
            </div>
        </div>

    <div class="form-group">
        <label for="descricao" class="col-sm-2 control-label">Descrição:</label>
        <div class="col-sm-10">
            <form:textarea path="descricao" id="descricao" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="status" class="col-sm-2 control-label">Status:</label>
        <div class="col-sm-10">
            <form:select path="status" id="status" class="form-control">
                <form:option value="EA" label="Em Análise"/>
                <form:option value="AR" label="Análise Realizada"/>
                <form:option value="AP" label="Análise Aprovada"/>
                <form:option value="IN" label="Iniciado"/>
                <form:option value="PL" label="Planejado"/>
                <form:option value="AN" label="Em Andamento"/>
                <form:option value="EN" label="Encerrado"/>
                <form:option value="CA" label="Cancelado"/>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="risco" class="col-sm-2 control-label">Risco:</label>
        <div class="col-sm-10">
            <form:select path="risco" id="risco" class="form-control">
                <form:option value="baixo" label="Baixo Risco"/>
                <form:option value="medio" label="Médio Risco"/>
                <form:option value="alto" label="Alto Risco"/>
            </form:select>
        </div>
    </div>



    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Cadastrar" class="btn btn-primary"/>
        </div>
    </div>
    </form:form>

</div>
</body>
</html>

