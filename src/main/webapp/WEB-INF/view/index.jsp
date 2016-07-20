<html>
<head lang="en">

<title>Welcome to SAMZON WEBSITE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="icon" href="resources/images/fav.jpg">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<body style="background-color: lightblue;">

	<div class="jumbotron">
		<h1 align="center" style="color: red">WELCOME TO SAMAZON</h1>
		<h4 align="center">sale get discount upto 50%</h4>
	</div>



	<!-- Partition for NAV BAR -->
	<nav class="navbar navbar-default  navbar-fixed-top">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">category <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="cat1.jsp">Analog Watches</a></li>
						<li><a href="cat2.jsp">Digital Watches</a></li>
						<li><a href="cat3.jsp">Smart Watches</a></li>
					</ul></li>
				<li><a href="login">Login</a></li>
				<li><a href="register">Registration</a></li>
			</ul>
		</div>
	</nav>


	<!-- PARTITION FOR CAROUSEL -->

	<div class="row-md-4" style="background-color: lavenderblush;">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active">
				</li>
				<li data-target="#myCarousel" data-slide-to="slide1.jpg"></li>
				<li data-target="#myCarousel" data-slide-to="slide2.jpg"></li>
				<li data-target="#myCarousel" data-slide-to="slide3.jpg"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="img-responsive" src="resources/images/slide1.png"
						alt="Images">
				</div>

				<div class="item">
					<img class="img-responsive" src="resources/images/slide2.png"
						alt="Images">
				</div>

				<div class="item">
					<img class="img-responsive" src="resources/images/slide3.jpg"
						alt="Images">
				</div>
			</div>





		</div>

		<!-- PARTITION FOR CAT CONTENT TEXT -->
		<div class="row-lg-4" style="background-color: lavender;">

			<br /> <br />
			<div class="col-lg-4">
				<h4>DIGITAL WATCHES</h4>

				<img class="img-responsive" s src="resources/images/cat4.JPG"
					alt="Images">
			</div>
			<div class="col-lg-4">
				<h4>ANALOG WATCHES</h4>
				<img class="img-responsive " src="resources/images/cat5.JPG">
			</div>
			<div class="col-lg-4">
				<h4>SMART WATCHES</h4>

				<img class="img-responsive" src="resources/images/cat6.jpg"
					alt="Images">
			</div>

		</div>

		<!-- row partition ends here -->
</body>
</html>
