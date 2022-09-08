<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">
<head>
    <title>Home Budget</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<main>
    <h1>Home Budget</h1>
    <section class="summary">
        <h2>Sum</h2>
        <p>income: ${requestScope.incomesSum}zł</p>
        <p>expenses: ${requestScope.expensesSum}zł</p>
        <p>Balance: ${requestScope.balance}zł</p>
    </section>
    <a href="${pageContext.request.contextPath}/add">add income or expense</a>
    <c:if test="${not empty requestScope.incomes}">
        <section>
            <h2>incomes</h2>
            <table>
                <thead>
                <tr>
                    <th>description</th>
                    <th>amount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="income" items="${requestScope.incomes}">
                    <tr>
                        <td><c:out value="${income.description}"/></td>
                        <td>${income.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
    </c:if>
    <c:if test="${not empty requestScope.expenses}">
        <section>
            <h2>expenses</h2>
            <table>
                <thead>
                <tr>
                    <th>description</th>
                    <th>amount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="expense" items="${requestScope.expenses}">
                    <tr>
                        <td><c:out value="${expense.description}"/></td>
                        <td>${expense.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
    </c:if>
</main>
</body>
</html>