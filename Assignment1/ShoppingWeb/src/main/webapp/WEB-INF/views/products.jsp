<%@ page import="java.util.List" %>
<%@ page import="in.cg.models.Product" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<style>

*{
    box-sizing:border-box;
}

body{
    margin:0;
    font-family:'Segoe UI',sans-serif;
    background:linear-gradient(135deg,#667eea,#764ba2);
    min-height:100vh;
}

h1{
    text-align:center;
    color:white;
    padding:30px 0;
    letter-spacing:1px;
}

.container{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(260px,1fr));
    gap:30px;
    padding:40px;
    max-width:1200px;
    margin:auto;
}

.card{
    background:rgba(255,255,255,0.15);
    backdrop-filter:blur(12px);
    border-radius:16px;
    padding:25px;
    text-align:center;
    color:white;
    box-shadow:0 10px 30px rgba(0,0,0,0.25);
    transition:all 0.3s ease;
}

.card:hover{
    transform:translateY(-10px) scale(1.02);
    box-shadow:0 20px 40px rgba(0,0,0,0.35);
}

.card h3{
    margin:0;
    font-size:22px;
}

.price{
    font-size:20px;
    margin:15px 0;
    color:#ffd369;
    font-weight:bold;
}

input[type=number]{
    width:70px;
    padding:8px;
    border-radius:8px;
    border:none;
    outline:none;
    text-align:center;
    font-size:16px;
}

button{
    margin-top:15px;
    width:100%;
    padding:12px;
    border:none;
    border-radius:25px;
    background:linear-gradient(135deg,#ff512f,#dd2476);
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    opacity:0.9;
    transform:scale(1.03);
}

.cart-link{
    display:block;
    text-align:center;
    margin:30px auto 50px;
    font-size:18px;
    color:white;
    text-decoration:none;
    background:rgba(0,0,0,0.3);
    width:200px;
    padding:12px;
    border-radius:30px;
    transition:0.3s;
}

.cart-link:hover{
    background:rgba(0,0,0,0.5);
    transform:scale(1.05);
}

</style>
</head>

<body>

<h1>Available Products</h1>

<div class="container">

<%
List<Product> list = (List<Product>)request.getAttribute("products");
for(Product p : list){
%>

<div class="card">

<form action="add" method="post">

    <h3><%= p.getName() %></h3>

    <div class="price">₹ <%= p.getPrice() %></div>

    Quantity
    <br><br>

    <input type="number" name="qty" value="1" min="1"/>

    <input type="hidden" name="id" value="<%= p.getId() %>" />

    <button type="submit">Add To Cart</button>

</form>

</div>

<%
}
%>

</div>

<a class="cart-link" href="cart">View Cart</a>

</body>
</html>