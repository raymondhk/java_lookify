<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lookify</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>

	<body>
		<div class="container">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="/dashboard">Lookify</a>
					</div>
						<ul class="nav navbar-nav">
							<li class="active"><a href="/songs/new/">Add New</a></li>
							<li><a href="/search/topTen">Top Songs</a></li>
						</ul>
						<form method="POST" action="/search" class="navbar-form navbar-left pull-right">
							<div class="form-group">
								<input type="text" id="searchText" class="form-control" placeholder="Artist Name" name="artist">
							</div>
							<button type="submit" class="btn btn-default">Search Artist</button>
						</form>
				</div>
			</nav>
			<div class="row main-header">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h5>Songs by Artist: <c:out value="${artist}"/></h5>
				</div>
				<div class="col-md-2"></div>
			</div>
			<br>
			<div class="row main">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<table class="table">
						<thead>
							<tr>
								<th>Name</th>
								<th>Rating</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${songs}" var="song">
								<tr>
									<td>${song.title}</td>
									<td>${song.rating}</td>
									<td><a href="/songs/delete/${song.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</body>
</html>