<%@ page import="java.util.List" %>
<%@ page import="jp.ac.hal.entity.User" %>
<%@ page import="jp.ac.hal.entity.Order" %>
<%@ page import="jp.ac.hal.entity.OrderDetail" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<User> users = (List<User>)request.getAttribute("users");
  List<Order> orders = (List<Order>)request.getAttribute("orders");
%>
<html>
  <head>
    <title>$Title$</title>
    <style>
      * {
        box-sizing: border-box;
      }
      .tr {
        display: flex;
        align-content: stretch;
      }
      .tr * {
        flex: 1 0 2rem;
        border: solid 1px;
        margin: 0;
      }
      .v {
        display: flex;
        flex-direction: column;
        flex: 4;
      }
    </style>
  </head>
  <body>
    <p>user detail</p>
    <div>
      <div class="tr"><p>user_id<p>name<p>address</div>
      <%
        for(User u : users) {
          %>
      <div class="tr"><p><%=u.id%><p><%=u.name%><p><%=u.address%></div>
          <%
        }
      %>
    </div>

    <p>orders
    <div>
      <div class="tr"><p>order_id<p>user_id<p>order_date<p>no<p>product_id<p>qty</p></div>
      <%
        for(Order o : orders) {
          %><div class="tr"><p><%=o.id%><p><%=o.user_id%><p><%=o.date%><div class="v"><%
          int i = 0;
          for(OrderDetail od : o.details) {
            i++;
            %><div class="tr"><p><%=i%><p><%=od.product_id%><p><%=od.qty%></div><%
          }

          %></div></div><%
        }
      %>
    </div>
  </body>
</html>
