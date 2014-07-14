<%@ page import="java.util.List" %>
<%@ page import="com.pordiversion.bean.Imagen" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PorDiversion</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  
  
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  
	
	
  </head>
  <body >
    

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://github.com/cdnjs/cdnjs/blob/master/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
    
    
     <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Navegacion</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="http://199.89.53.179:8080/PorDiversion/xd.html">Solo por Diversión</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#about">About</a>
                    </li>
                    <li><a href="#services">Services</a>
                    </li>
                    <li><a href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <br><br>
    <br>
 <div class="container-fluid">   
    
    
    <div class="panel panel-default"  style="width: 70%;margin: 0 auto;">
	  <div class="panel-body">
	
	
	<div class="bs-example bs-example-tabs">
    <ul id="myTab" class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">Esgag</a></li>
      <li><a href="#profile" data-toggle="tab">Que Jalada</a></li>
      <li><a href="#chistedia" data-toggle="tab">Asi pasa</a></li>
      <li><a href="#ND" data-toggle="tab">Nuevo y D</a></li>
      
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane fade in active" id="home">
      		<%
         		List<Imagen> imagenes = (List<Imagen>)request.getAttribute("imagenes");
				int nv=0;
				for(Imagen e : imagenes){
			    	if(nv==0){
			    		%>
              			<div class="row">
					<%}%>
		            		<div class="col-lg-6 col-md-6 portfolio-item">
		                		<a href="#project-one">
			    	                    <img class="img-responsive" style="width:100%; height:auto;" src="<%=e.getImg() %>" />
		        		        </a>
		                	</div>
					<%nv++;
					  if(nv==2){
					%>
						</div>
					<%nv=0; 
					}
					}//fin for
					  if(nv==1){
						%>
						</div>
					<% }
					%>
                
	  </div>
      <div class="tab-pane fade" id="profile">
        <%
         		List<Imagen> imagenesEsgag = (List<Imagen>)request.getAttribute("imagenesEsgag");
				nv=0;
				for(Imagen e : imagenesEsgag){
			    	if(nv==0){
			    		%>
              			<div class="row">
					<%}%>
		            		<div class="col-lg-6 col-md-6 portfolio-item">
		                		<a href="#project-one">
			    	                    <img class="img-responsive" style="width:100%; height:auto;" src="<%=e.getImg() %>" />
		        		        </a>
		                	</div>
					<%nv++;
					  if(nv==2){
					%>
						</div>
					<%nv=0; 
					}
					}//fin for
					  if(nv==1){
						%>
						</div>
					<% }
					%>

        
      </div>
      
       <div class="tab-pane fade" id="chistedia">
       
       <%
         		List<Imagen> imagenesChistedia = (List<Imagen>)request.getAttribute("imageneshistedeldia");
				nv=0;
				for(Imagen e : imagenesChistedia){
			    	if(nv==0){
			    		%>
              			<div class="row">
					<%}%>
		            		<div class="col-lg-6 col-md-6 portfolio-item">
		                		<a href="#project-one">
			    	                    <img class="img-responsive" style="width:100%; height:auto;" src="<%=e.getImg() %>" />
		        		        </a>
		                	</div>
					<%nv++;
					  if(nv==2){
					%>
						</div>
					<%nv=0; 
					}
					}//fin for
					  if(nv==1){
						%>
						</div>
					<% }
					%>
       
       
       
 
        
      </div>
      
      
          <div class="tab-pane fade" id="ND">
          
          
          
             <%
         		List<Imagen> imagenesND = (List<Imagen>)request.getAttribute("imagenesND");
				nv=0;
				for(Imagen e : imagenesND){
			    	if(nv==0){
			    		%>
              			<div class="row">
					<%}%>
		            		<div class="col-lg-6 col-md-6 portfolio-item">
		                		<a href="#project-one">
			    	                    <img class="img-responsive" style="width:100%; height:auto;" src="<%=e.getImg() %>" />
		        		        </a>
		                	</div>
					<%nv++;
					  if(nv==2){
					%>
						</div>
					<%nv=0; 
					}
					}//fin for
					  if(nv==1){
						%>
						</div>
					<% }
					%>
       
          
     
      </div>
      
      
    </div>
  </div>
	
	
	
	
	
	
	
	
	  </div>
	  </div>
    
    <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Por Diversion 2014</p>
                </div>
            </div>
        </footer>
    
</div>	
    
    
 		


  </body>
</html>

