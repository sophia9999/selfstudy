<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>oEmbed Test</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background: #eee;
}

header {
	background: #2eaab7;
	height: 160px;
	width: 100%
}

header h2 {
	width: 100%; 
	height: 100px; 
	line-height: 120px; 
	text-align: center; 
	color: white; 
	font-size: 30px;
	font-weight: bold;
	margin: 0;
}

.body-container {
	padding: 30px;
	margin: 0 auto;
	width: 90%;
	border: 1px solid #a1a1a1;
	background: white;
}
.input_box {
	margin: 0 auto;
	width: 700px;
}
.input_box button {
	width: 60px; 
	height: 50px; 
	font-size: 1em; 
	font-weight: bold;  
	border: none; 
	border-radius: 3px; 
	background-color: #ffcd45;
}

.userUrl {
	width: 85%; 
	height: 50px; 
	color: darkgray; 
	font-size: 1.2em; 
	border-radius: 3px; 
	text-indent: 1em;
}

.resultTable {
	width: 100%;
	border: none;
	border-spacing : 0;
}

.resultTable tr td{
	padding: 10px;
	font-size: 20px;
    font-weight: 500;
}

.resultTable tr:nth-child(2n) {
	background-color: #eee;
}
</style>
<script type="text/javascript">
function ajaxFun(url, method, query, dataType, fn) {
	$.ajax({
		type:method,
		url:url,
		data:query,
		dataType:dataType,
		success:function(data) {
			fn(data);
		},
		beforeSend:function(jqXHR) {
			jqXHR.setRequestHeader("AJAX", true);
		},
		error:function(jqXHR) {
			alert("요청 처리가 실패했습니다.");
			console.log(jqXHR.responseText);
		}
	});
}
function sendOk() {
	var user_url = $(".userUrl").val().trim();
	
	if(! user_url) {
		alert("URL을 입력해주세요.");
		return false;
	}
	
	var url = "${pageContext.request.contextPath}/oembed/resource";
	var query = "user_url="+user_url;
	var fn = function(data) {
		// console.log(data);
		
		$(".resultTable").empty();
		
		let result = data.result;		
		let out = "";
		$.each(result, function(index, item) {
			out += "<tr>";
			out += "	<td>"+index+"</td>";
			out += "	<td>"+item+"</td>";
			out += "</tr>";
		});
		
		$(".resultTable").append(out);
	};
	
	ajaxFun(url, "get", query, "json", fn);
}

</script>

<body>
<header>
	<div>
		<h2>oEmbed Test - 서버에 저장한 provider읽어서 보내기</h2>
	</div>
	<div class="input_box">
		<input type="url" name="url" class="userUrl">
		<button type="button" onclick="sendOk()">확인</button>
	</div>
</header>
<div class="body-container">
	<table class="resultTable">
	
	</table>
</div>
</body>

</html>

