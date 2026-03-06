<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>LUXE | Home</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

<style>
*{
  margin:0;
  padding:0;
  box-sizing:border-box;
  font-family:'Poppins',sans-serif
}
	
body{
  height:100vh;
  background:radial-gradient(circle at top left,#1f4037,#0f2027);
  overflow:hidden;
  color:white
}

.ambient{
  position:absolute;
  inset:0;
  background:
    radial-gradient(circle at 20% 30%,rgba(0,255,200,.12),transparent 40%),
    radial-gradient(circle at 80% 70%,rgba(255,0,150,.1),transparent 40%);
  animation:float 10s infinite alternate
}

@keyframes float{
  from{transform:translateY(0)}
  to{transform:translateY(-40px)}
}

.navbar{
  position:relative;
  z-index:2;
  display:flex;
  justify-content:space-between;
  align-items:center;
  padding:30px 70px
}

.logo{
  font-size:30px;
  font-weight:700;
  letter-spacing:3px;
  background:linear-gradient(90deg,#00f5a0,#00d9f5);
  -webkit-background-clip:text;
  color:transparent
}

.nav-btn{
  padding:14px 36px;
  border-radius:40px;
  border:1px solid rgba(255,255,255,.2);
  background:rgba(255,255,255,.1);
  backdrop-filter:blur(10px);
  color:white;
  font-weight:600;
  cursor:pointer;
  transition:.4s
}

.nav-btn:hover{
  background:linear-gradient(135deg,#00f5a0,#00d9f5);
  color:black;
  box-shadow:0 15px 40px rgba(0,255,200,.5)
}

.hero{
  position:relative;
  z-index:2;
  height:80vh;
  display:flex;
  flex-direction:column;
  justify-content:center;
  align-items:center;
  text-align:center
}

.hero h1{
  font-size:64px;
  font-weight:700;
  line-height:1.1;
  animation:reveal 1.2s ease forwards
}

.hero p{
  margin:25px 0 40px;
  font-size:18px;
  max-width:520px;
  opacity:.85;
  animation:reveal 1.6s ease forwards
}

.hero-btn{
  padding:18px 55px;
  border-radius:50px;
  border:none;
  background:linear-gradient(135deg,#00f5a0,#00d9f5);
  color:black;
  font-size:16px;
  font-weight:700;
  cursor:pointer;
  box-shadow:0 20px 60px rgba(0,255,200,.5);
  transition:.4s;
  animation:reveal 2s ease forwards
}

.hero-btn:hover{
  transform:translateY(-6px) scale(1.05)
}

@keyframes reveal{
  from{
    opacity:0;
    transform:translateY(40px)
  }
  to{
    opacity:1;
    transform:translateY(0)
  }
}

</style>
</head>

<body>

<div class="ambient"></div>

<div class="navbar">
  <div class="logo">LUXE</div>
  <form action="products">
    <button class="nav-btn">Products</button>
  </form>
</div>

<div class="hero">
  <h1>Luxury Meets Innovation</h1>
  <p>Experience shopping with refined elegance, fluid motion, and modern design.</p>
  <form action="products">
    <button class="hero-btn">Discover Products</button>
  </form>
</div>

</body>
</html>