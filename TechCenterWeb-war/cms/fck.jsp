<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<html>
<head>
<link rel="stylesheet" href="../scripts/lib/jquery-ui-1.9.2.custom/css/smoothness/jquery-ui-1.9.2.custom.min.css" type="text/css" />
<script src="../scripts/lib/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
<script src="../scripts/lib/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js"></script>
</head>
	<body>

		<form action="sample_posteddata.jsp" method="get">
			<p>
				<label for="editor1">Editor 1:</label>
				<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
			</p>
			<p>
				<input type="submit" value="Submit" />
			</p>
		</form>
	<ckeditor:replace replace="editor1" basePath="./ckeditor/" />
	</body>	
</html>