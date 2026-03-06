<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="in.cart.entity.Cart" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">

<style>
*{margin:0;padding:0;box-sizing:border-box;font-family:'Poppins',sans-serif}

body{
    min-height:100vh;
    background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);
    color:white;
    padding-top:80px
}

nav{
    position:fixed;
    top:0;left:0;right:0;
    z-index:1000;
    display:flex;
    align-items:center;
    justify-content:space-between;
    padding:0 40px;
    height:70px;
    background:rgba(255,255,255,.07);
    backdrop-filter:blur(14px);
    border-bottom:1px solid rgba(255,255,255,.1);
    box-shadow:0 4px 20px rgba(0,0,0,.3)
}

.nav-logo{
    font-size:24px;
    font-weight:700;
    background:linear-gradient(135deg,#00f5a0,#00d9f5);
    -webkit-background-clip:text;
    -webkit-text-fill-color:transparent
}

.container{
    max-width:1100px;
    margin:auto;
    padding:40px
}

.heading{
    text-align:center;
    font-size:42px;
    font-weight:700;
    margin-bottom:40px
}

.cart-card{
    display:flex;
    gap:30px;
    background:rgba(255,255,255,.08);
    backdrop-filter:blur(12px);
    border-radius:20px;
    padding:25px;
    margin-bottom:30px;
    box-shadow:0 20px 50px rgba(0,0,0,.4)
}

.cart-card img{
    width:220px;
    height:170px;
    object-fit:cover;
    border-radius:15px
}

.cart-details{
    flex:1
}

.cart-details h3{
    font-size:24px;
    font-weight:600
}

.cart-details p{
    margin:12px 0;
    opacity:.85
}

.cart-details span{
    font-size:14px;
    opacity:.7
}

.actions{
    margin-top:20px;
    display:flex;
    gap:20px
}

.actions a{
    padding:10px 24px;
    border-radius:30px;
    text-decoration:none;
    font-weight:600;
    transition:.3s
}

.remove-btn{
    background:#ff4d4d;
    color:white
}

.remove-btn:hover{
    background:#ff1f1f
}

.back-btn{
    background:rgba(255,255,255,.15);
    color:white
}

.empty{
    text-align:center;
    margin-top:120px
}

.empty i{
    font-size:90px;
    opacity:.4
}

.empty h2{
    margin-top:20px;
    font-size:32px
}

.empty p{
    margin:15px 0 30px;
    opacity:.8
}

.empty a{
    padding:14px 35px;
    border-radius:35px;
    background:linear-gradient(135deg,#00f5a0,#00d9f5);
    color:black;
    font-weight:600;
    text-decoration:none
}
</style>
</head>

<body>

<%
    List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
%>

<nav>
    <div class="nav-logo"><i class="fas fa-store"></i> Luxe</div>
    <div>
        <a href="products" style="color:white;font-size:22px">
            <i class="fas fa-arrow-left"></i>
        </a>
    </div>
</nav>

<div class="container">

<% if(cartList != null && !cartList.isEmpty()) { %>

    <div class="heading">Your Cart</div>

    <% for(Cart c : cartList) { %>

        <div class="cart-card">
            <img src="<%= c.getProductImage() %>" alt="<%= c.getProductName() %>">

            <div class="cart-details">
                <h3><%= c.getProductName() %></h3>
                <p><%= c.getProductDesc() %></p>
                <span>Product ID: <%= c.getProductId() %></span>

                <div class="actions">
                    <a href="removeFromCart?productId=<%= c.getProductId() %>" class="remove-btn">
                        <i class="fas fa-trash"></i> Remove
                    </a>
                    <a href="products" class="back-btn">Continue Shopping</a>
                </div>
            </div>
        </div>

    <% } %>

<% } else { %>

    <div class="empty">
        <i class="fas fa-shopping-cart"></i>
        <h2>Your cart is empty</h2>
        <p>Add products to see them here</p>
        <a href="products">Shop Now</a>
    </div>

<% } %>

</div>

</body>
</html>