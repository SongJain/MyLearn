<%--
  Created by IntelliJ IDEA.
  User: JAIN
  Date: 2019/3/3
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${thirdMenuList }" var="thirdMenu">
    <a href="#" class="easyui-linkbutton" iconCls="${thirdMenu.icon}" onclick="${thirdMenu.url}" plain="true">${thirdMenu.name}</a>
</c:forEach>
