 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <a class="navbar-brand" href="#">JOBS</a>
              <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Aboutus.jsp">About Us </a>
                  </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="#">Services</a>
                  </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="#">Contact Us</a>
                  </li>
              </ul>
              

<!--              <a href="showLogin">  <button type="button"  class="btn btn-primary my-2 my-sm-0" > -->
<!--                     Login -->
<!--                   </button> -->
<!--                  </a> -->
            
<!--             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; -->
<!--            <a href="showReg">   <button type="button" class="btn btn-success my-2 my-sm-0" > -->
<!--                Sign Up -->
<!--               </button> -->
<!--               </a> -->






         
              
              
              <%
request.getSession(false);            
              if (session != null) {
      			if (session.getAttribute("username") != null) {
              
              %>

<a href="/jobmanagement/showLogout">  <button type="button" onclick="call()" class="btn btn-primary my-2 my-sm-0" >   
                    Logout
                  </button>
     
              </a>
<%

      			}
              }
              else{
%>

             <a href="showLogin">  <button type="button"  class="btn btn-primary my-2 my-sm-0" >
                    Login
                  </button>
                 </a>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
           <a href="showReg">   <button type="button" class="btn btn-success my-2 my-sm-0" >
               Sign Up
              </button>
              </a>
              
              
              <%
              
              
              }
              %>










            </div>
          </nav>