<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title>Sambatech Projeto 1</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="content">
        <h1>Sambatech Projeto 1</h1>
        <div class="paging">
          <c:if test="${!registerList.firstPage}">
            <a href="index.html?page=previous"><b>&lt;&lt; Prev</b></a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </c:if>
          <c:if test="${!registerList.lastPage}">
            <a href="index.html?page=next"><b>Next &gt;&gt;</b></a>
          </c:if>
        </div>
        <div class="data">
            <table border="0" cellpadding="4" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Twitter</th>
                    <th></th>
                </tr>
              <c:forEach var="register" items="${registerList.pageList}">
                <tr>
                    <td>${register.id}</td>
                    <td>${register.name}</td>
                    <td>${register.phone}</td>
                    <td>${register.email}</td>
                    <td>${register.twitter}</td>
                    <td>
                        <a href="view.html?registerId=${register.id}" class="view">view</a>
                        <a href="update.html?registerId=${register.id}" class="update">update</a>
                        <a href="delete.html?registerId=${register.id}" class="delete">delete</a>
                    </td>
                </tr>
              </c:forEach>
              <c:if test="${registerList.nrOfElements == 0}">
                <tr><td colspan="5">No Register Data</td></tr>
              </c:if>
            </table>
        </div>
        
        <div class="data">
            <table border="0" cellpadding="4" cellspacing="0">
                <tr>
                    <th>@sambatech1's posts</th>
                </tr>
              <c:forEach var="tweet" items="${tweetsList}">
                <tr>
                    <td>${tweet}</td>
                </tr>
              </c:forEach>
              <c:if test="${empty tweetsList}">
                <tr><td colspan="5">No Tweets Data</td></tr>
              </c:if>
            </table>
        </div>
        
        <br />
        <a href="add.html" class="add">add new register</a>
    </div>
</body>
</html>