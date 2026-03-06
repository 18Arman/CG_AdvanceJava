<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="in.cart.entity.Products" %>
<%@ page import="in.cart.entity.Cart" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">

<style>
/* === YOUR EXISTING CSS (UNCHANGED) === */
*{margin:0;padding:0;box-sizing:border-box;font-family:'Poppins',sans-serif}
body{min-height:100vh;background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);color:white;padding-top:80px}
/* NAVBAR */
nav{position:fixed;top:0;left:0;right:0;z-index:1000;display:flex;align-items:center;justify-content:space-between;padding:0 40px;height:70px;background:rgba(255,255,255,.07);backdrop-filter:blur(14px);border-bottom:1px solid rgba(255,255,255,.1);box-shadow:0 4px 20px rgba(0,0,0,.3)}
.nav-logo{font-size:24px;font-weight:700;background:linear-gradient(135deg,#00f5a0,#00d9f5);-webkit-background-clip:text;-webkit-text-fill-color:transparent}
.nav-links{display:flex;gap:30px;list-style:none}
.nav-links a{color:rgba(255,255,255,.85);text-decoration:none;font-size:15px;font-weight:500;transition:.3s}
.nav-links a:hover{color:#00f5a0}
.nav-right{display:flex;align-items:center;gap:20px}
.cart-icon{position:relative;cursor:pointer;font-size:24px;color:white}
.cart-badge{position:absolute;top:-8px;right:-8px;background:linear-gradient(135deg,#00f5a0,#00d9f5);color:black;font-size:11px;font-weight:700;width:20px;height:20px;border-radius:50%;display:flex;align-items:center;justify-content:center}
.main{padding:40px}
.heading{text-align:center;font-size:42px;font-weight:700;margin-bottom:50px}
.products-container{display:grid;grid-template-columns:repeat(auto-fit,minmax(280px,1fr));gap:30px}
.card{background:rgba(255,255,255,.08);backdrop-filter:blur(12px);border-radius:20px;padding:20px;box-shadow:0 20px 50px rgba(0,0,0,.4);transition:.4s}
.card:hover{transform:translateY(-10px);box-shadow:0 30px 70px rgba(0,255,200,.4)}
.card img{width:100%;height:200px;object-fit:cover;border-radius:15px}
.card h3{margin-top:15px;font-size:20px;font-weight:600}
.card p{margin:10px 0 20px;font-size:14px;opacity:.85}
.card button{width:100%;padding:12px;border:none;border-radius:30px;background:linear-gradient(135deg,#00f5a0,#00d9f5);color:black;font-weight:600;cursor:pointer}
</style>
</head>

<body>

<%
    List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
    int cartCount = cartList == null ? 0 : cartList.size();
%>

<!-- NAVBAR -->
<nav>
    <div class="nav-logo"><i class="fas fa-store"></i> Luxe</div>

    <ul class="nav-links">
        <li><a href="#"><i class="fas fa-home"></i> Home</a></li>
        <li><a href="products"><i class="fas fa-box"></i> Products</a></li>
        <li><a href="#"><i class="fas fa-tags"></i> Offers</a></li>
        <li><a href="#"><i class="fas fa-envelope"></i> Contact</a></li>
    </ul>

    <div class="nav-right">
        <a href="cart" style="text-decoration:none">
            <div class="cart-icon">
                <i class="fas fa-shopping-cart"></i>
                <span class="cart-badge"><%= cartCount %></span>
            </div>
        </a>
    </div>
</nav>

<!-- MAIN -->
<div class="main">
    <div class="heading">Our Products</div>

    <div class="products-container">

    <%
        List<Products> list = (List<Products>) request.getAttribute("products");
        for(Products p : list){
    %>

        <div class="card">
            <img src="<%= p.getProductImage() %>" alt="<%= p.getProductName() %>">
            <h3><%= p.getProductName() %></h3>
            <p><%= p.getProductDesc() %></p>

         <form action="addToCart" method="post">
    <input type="hidden" name="productId" value="<%= p.getProductId() %>">
    <button type="submit">
        <i class="fas fa-cart-plus"></i> Add to Cart
    </button>
</form>
        </div>

    <%
        }
    %>

    </div>
</div>

</body>
</html>