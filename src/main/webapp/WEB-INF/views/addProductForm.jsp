<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="./base.jsp" %>
	<%@ page isELIgnored = "false" %>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


</head>
<body>

	<div class="container mt-3">


		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Fill the Product Details</h1>

				<form action="handle-form" method="post">

					<div class="form-group">

						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter the product name here">

					</div>

					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea name="description" id="description" rows="5"
							class="form-control" placeholder="Enter the product description"></textarea>
					</div>

					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							placeholder="Enter the Product Price" name="price"
							class="form-control" id="price">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger"> Back </a>
						<button type="submit" class="btn btn-primary">Add</button>

					</div>


				</form>

			</div>
		</div>

	</div>

</body>
</html>
