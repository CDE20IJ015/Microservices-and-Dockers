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
        <span class="header-title">Movie Cruiser</span> <img class="header-logo" src="./images/logo.png"
            alt="Movie Cruiser Logo"></img>
        <nav>
            <a class="nav-link" href="./show-movie-list-customer">Movies</a> <a class="nav-link"
                href="./favorites">Favorites</a>
        </nav>
    </header>
    <article>
        <h2 class="article-heading">Favorites</h2>
        <table>
            <tr>
                <th class="col-left">Title</th>
                <th class="col-right">Box Office</th>
                <th>Genre</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${favorites}" var="favorite">
                <tr>
                    <td class="col-left">${favorite.movie.title}</td>
                    <td class="col-right">${favorite.movie.boxOffice}</td>
                    <td>${favorite.movie.genre}</td>
                    <td><a class="action-link" href="./delete?favId=${favorite.id}">Delete</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" class="col-left">
                    <p class="table-message">
                        <strong>No. of Favorites:</strong> ${total}
                    </p>
                </td>
            </tr>
        </table>
    </article>
    <footer>
        <p>Copyright &copy; 2019</p>
    </footer>
</body>

</html>