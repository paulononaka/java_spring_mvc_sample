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
        <h1><c:out value="${title}" default="Add New Register"/></h1>
        <form method="post" action="save.html">
        <div class="data">
            <table>
                <tr>
                    <td width="30%">ID</td>
                    <td><input type="text" name="id" disabled="disable" class="text" value="${register.id}"/></td>
                        <input type="hidden" name="id" value="${register.id}"/>
                </tr>
                <tr>
                    <td valign="top">Name</td>
                    <td><input type="text" name="name" class="text" value="${register.name}"/>
                    </td>
                </tr>
                <tr>
                    <td valign="top">Phone</td>
                    <td><input type="text" name="phone" class="text" value="${register.phone}"/>
                    </td>
                </tr>
                <tr>
                    <td valign="top">Email</td>
                    <td><input type="text" name="email" class="text" value="${register.email}"/>
                    </td>
                </tr>
                <tr>
                    <td valign="top">Twitter</td>
                    <td><input type="text" name="twitter" class="text" value="${register.twitter}"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </div>
        </form>
        <br />
        <a href="index.html" class="back">back</a>
    </div>
</body>
</html>