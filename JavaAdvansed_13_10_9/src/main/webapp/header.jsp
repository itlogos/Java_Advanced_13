<link rel="stylesheet" href="css/header.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


  <div id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
      <span class="navbar-toggler-icon leftmenutrigger"></span>
      <a class="navbar-brand" href="#">DailyShop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav animate side-nav">
          <li class="nav-item">
             <a class="nav-link" href="${pageContext.request.contextPath}/cabinet.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item create-magazine-option">
            <a class="nav-link" href="${pageContext.request.contextPath}/createMagazine.jsp">add Periodical</a>
          </li>
          <li class="nav-item user-subscribe-option">
            <a class="nav-link" href="${pageContext.request.contextPath}/subscribe.jsp">Subscribe</a>
          </li>
        </ul>
        <ul class="navbar-nav ml-md-auto d-md-flex">
          <li class="nav-item">
            <button class="nav-link magazine-logout">LogOut</button>
          </li>
        </ul>
      </div>
    </nav>
  
  </div>
  
