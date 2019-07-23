<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.EnqBeans"%>
<%
	EnqBeans Udon = (EnqBeans) application.getAttribute("Udon");
	EnqBeans Soba = (EnqBeans) application.getAttribute("Soba");
	EnqBeans Nodle = (EnqBeans) application.getAttribute("Nodle");
	int inAll = Udon.getCount() + Soba.getCount() + Nodle.getCount();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.Coments {
	border-collapse: collapse;
}

.Coments tr td {
	border: solid 1px #000000;
}
</style>
</head>
<body>
	<h1>アンケート</h1>
	<h2>どれが食べたい？</h2>
	<form action="" method="get">
		<div>
			<p>
				<input type="radio" name="Men" value="Udon" checked="checked">うどん
			</p>
			<p>
				<input type="radio" name="Men" value="Soba">そば
			</p>
			<p>
				<input type="radio" name="Men" value="Nodle">ラーメン
			</p>
			<p>
				コメント:<input type="text" name="Coment">
			</p>
			<input type="submit" value="投票">
		</div>
	</form>

	<div>
		<h3>投票結果</h3>
		<table>
			<tr>
				<td>うどん</td>
				<td><%=Udon.getCount()%>票(<%=(int) ((double) Udon.getCount() / inAll * 100)%>%)</td>
				<td><div
						style="background-color: red; width: <%=(int) ((double) Udon.getCount() / inAll * 100) * 10%>px;">&#160;</div></td>
			</tr>
			<tr>
				<td>そば</td>
				<td><%=Soba.getCount()%>票(<%=(int) ((double) Soba.getCount() / inAll * 100)%>%)</td>
				<td><div
						style="background-color: blue; width: <%=(int) ((double) Soba.getCount() / inAll * 100) * 10%>px;">&#160;</div></td>
			</tr>
			<tr>
				<td>ラーメン</td>
				<td><%=Nodle.getCount()%>票(<%=(int) ((double) Nodle.getCount() / inAll * 100)%>%)</td>
				<td><div
						style="background-color: yellow; width: <%=(int) ((double) Nodle.getCount() / inAll * 100) * 10%>px;">&#160;</div></td>
			</tr>
		</table>
	</div>

	<div>
		<p>コメント</p>
		<table class="Coments">
			<tr>
				<td>うどん</td>
				<td style="width: 200px;"><%=Udon.getComent()%></td>
			</tr>
			<tr>
				<td>そば</td>
				<td style="width: 200px;"><%=Soba.getComent()%></td>
			</tr>
			<tr>
				<td>ラーメン</td>
				<td style="width: 200px;"><%=Nodle.getComent()%></td>
			</tr>
		</table>
	</div>

</body>
</html>