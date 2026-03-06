<%@ page import="java.util.List" %>
<%@ page import="in.cg.models.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>

<style>

*{
    box-sizing:border-box;
}

body{
    margin:0;
    font-family:'Segoe UI',sans-serif;
    background:linear-gradient(135deg,#667eea,#764ba2);
    min-height:100vh;
    padding:40px;
    color:white;
}

h2{
    text-align:center;
    margin-bottom:30px;
}

.table-container{
    max-width:1100px;
    margin:auto;
    background:rgba(255,255,255,0.15);
    backdrop-filter:blur(12px);
    border-radius:16px;
    padding:30px;
    box-shadow:0 15px 40px rgba(0,0,0,0.3);
}

table{
    width:100%;
    border-collapse:collapse;
    text-align:center;
}

th,td{
    padding:15px;
}

th{
    background:rgba(0,0,0,0.35);
    font-size:16px;
}

tr:nth-child(even){
    background:rgba(255,255,255,0.08);
}

tr:hover{
    background:rgba(255,255,255,0.15);
}

.price{
    color:#ffd369;
    font-weight:bold;
}

.remove-btn{
    padding:8px 14px;
    border:none;
    border-radius:20px;
    background:linear-gradient(135deg,#ff512f,#dd2476);
    color:white;
    cursor:pointer;
    transition:0.3s;
}

.remove-btn:hover{
    transform:scale(1.05);
    opacity:0.9;
}

.total-box{
    margin-top:25px;
    text-align:right;
    font-size:22px;
    font-weight:bold;
    color:#ffd369;
}

.actions{
    display:flex;
    justify-content:space-between;
    margin-top:30px;
    flex-wrap:wrap;
    gap:15px;
}

.actions a{
    text-decoration:none;
    padding:12px 22px;
    border-radius:30px;
    color:white;
    background:rgba(0,0,0,0.4);
    transition:0.3s;
}

.actions a:hover{
    background:rgba(0,0,0,0.6);
    transform:scale(1.05);
}

</style>
</head>

<body>

<h2>Your Shopping Cart</h2>

<div class="table-container">

<table>

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Action</th>
</tr>

<%
List<CartItem> cart = (List<CartItem>)request.getAttribute("cart");
for(CartItem c : cart){
%>

<tr>
    <td><%= c.getProduct().getId() %></td>
    <td><%= c.getProduct().getName() %></td>
    <td class="price">₹ <%= c.getProduct().getPrice() %></td>
    <td><%= c.getQuantity() %></td>
    <td class="price">
        ₹ <%= c.getProduct().getPrice() * c.getQuantity() %>
    </td>
    <td>
        <form action="remove" method="post">
            <input type="hidden" name="id" value="<%= c.getProduct().getId() %>" />
            <button class="remove-btn" type="submit">Remove</button>
        </form>
    </td>
</tr>

<%
}
%>

</table>

<div class="total-box">
    Total Amount : ₹ <%= request.getAttribute("total") %>
</div>

<div class="actions">
    <a href="products">Continue Shopping</a>
    <a href="#">Proceed to Checkout</a>
</div>

</div>

</body>
