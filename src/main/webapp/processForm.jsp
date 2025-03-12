<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Form Submission Result</title>
</head>
<body>
<h2>Form Submission Result</h2>
<%
  // Retrieve form data
  String nom = request.getParameter("nom");
  String prenom = request.getParameter("prenom");
  String dateNaissance = request.getParameter("dateNaissance");
  String email = request.getParameter("email");
  String motDePasse = request.getParameter("motDePasse");
  String role = request.getParameter("role");
  String sport = request.getParameter("sport");



  // You can now process the data (e.g., save to a database)
%>
</body>
</html>