<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">
<head>
    <title>Add New</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<main>
    <h1>Add New</h1>
    <form action="${pageContext.request.contextPath}/add" method="post">
        <fieldset>
            <legend>Add New/legend>
            <label class="keyboard-inputs">
                Desription
                <input name="description" placeholder="np. Abonament Netflix">
            </label>
            <label class="keyboard-inputs">
                Amount (zł)
                <input name="value" type="number" step="0.01" placeholder="np. 10.5">
            </label>
            <section>
                <label>
                    INCOME
                    <input name="type" type="radio" value="INCOME">
                </label>
                <label>
                    EXPENSE
                    <input name="type" type="radio" value="EXPENSE">
                </label>
            </section>
            <button>Save</button>
        </fieldset>
    </form>
</main>
</body>
</html>