<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Movie Cruiser</title>
<link rel="icon" type="image/ico" href="./images/logo.png" />
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header>
		<span class="header-title">Movie Cruiser</span> <img
			class="header-logo" src="./images/logo.png" alt="Movie Cruiser Logo"></img>
		<nav>
			<a class="nav-link" href="./show-movie-list-admin">Movies</a>
		</nav>
	</header>
	<article>
		<h2 class="article-heading">Movies</h2>
		<table>
			<tr>
				<th class="col-left">Title</th>
				<th class="col-right">Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td class="col-left">${movie.title}</td>
					<td class="col-right">${movie.boxOffice}</td>
					<td>${movie.active}</td>
					<td><fmt:formatDate value="${movie.dateOfLaunch}" type="date"
							pattern="dd/MM/yyyy" /></td>
					<td>${movie.genre}</td>
					<td>${movie.hasTeaser}</td>
					<td><a class="action-link"
						href="./edit-movie?movieId=${movie.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</article>
	<footer>
		<p>Copyright &copy; 2019</p>
	</footer>
</body>
</html>