<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>Movie Cruiser</title>
    <link rel="icon" type="image/ico" href="./images/logo.png" />
    <link rel="stylesheet" type="text/css" href="./style/style.css">
    <script src="./js/script.js"></script>
</head>

<body class="xyz">
    <header>
        <span class="header-title">Movie Cruiser</span> <img class="header-logo" src="./images/logo.png"
            alt="Movie Cruiser Logo"></img>
        <nav>
            <a class="nav-link" href="./show-movie-list-admin">Movies</a>
        </nav>
    </header>
    <article>
        <h2 class="article-heading">Edit Movie</h2>
        <form:form name="editMovieForm" onsubmit="return validateForm();" action="/edit-movie" method="post"
            modelAttribute="movie">
            <c:set var="movie" value="${movie}"></c:set>
            <form:hidden path="id"/>
            <table class="form-table">
                <tr>
                    <td colspan="4">
                        <form:label path="title" class="form-item" for="field-title">Title</form:label>
                        <form:input path="title" class="form-input" type="text" name="title" id="title" />
                        <p class="form-error-message" id="title-error"></p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="boxOffice" class="form-item" for="field-boxOffice">Box
                            Office ($)</form:label>
                        <form:input path="boxOffice" class="form-input form-input-right" type="text" name="boxOffice"
                            id="boxOffice" />
                        <p class="form-error-message" id="boxOffice-error"></p>
                    </td>
                    <th>
                        <form:label path="active" class="form-item" for="field-yes">Active</form:label><br>
                        <form:radiobutton path="active" name="active" value="Yes" id="active" />
                        <form:label class="form-item" path="active" for="field-yes">Yes</form:label>
                        <form:radiobutton path="active" name="active" value="No" />
                        <form:label path="active" class="form-item" for="field-no">No</form:label>
                    </th>
                    <td>
                        <form:label path="dateOfLaunch" class="form-item" for="field-dateOfLaunch">Date
                            of Launch</form:label>
                        <form:input type="date" class="form-control" id="dateOfLaunch"
										path="dateOfLaunch" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <form:label path="genre" class="form-item" for="field-genre">Genre</form:label>
                        <form:select class="form-input" name="genre" id="field-genre" path="genre">
                            <form:option value="Science Fiction">Science Fiction</form:option>
                            <form:option value="Superhero">Superhero</form:option>
                            <form:option value="Romance">Romance</form:option>
                            <form:option value="Comedy">Comedy</form:option>
                            <form:option value="Adventure">Adventure</form:option>
                            <form:option value="Thriller">Thriller</form:option>
                        </form:select>
                    </td>
                </tr>
                <tr colspan=4>
                    <td><form:label class="form-item" for="field-hasTeaser" path="hasTeaser"><form:checkbox class="form-check-input" id="hasTeaser"
										name="hasTeaser" path="hasTeaser" value="Yes" />Has Teaser</form:label>
                    </td>
                </tr>
                <tr colspan=4>
                    <td><input class="form-button" type="submit" name="submit" value="Save"></input></td>
                </tr>
            </table>
        </form:form>
    </article>
    <footer>
        <p>Copyright &copy; 2019</p>
    </footer>
</body>

</html>