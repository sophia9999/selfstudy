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
	
	var url = "${pageContext.request.contextPath}/oembed2/resource";
	var query = "user_url="+user_url;
	var fn = function(data) {
		// console.log(data);
		$(".resultTable").empty();
		
		let result = data.result;
		let out = "";
		if(result.title != null) {
			out += "<tr>";
			out += "	<td>title</td>";
			out += "	<td><h3>"+result.title+"</h3></td>";
			out += "</tr>";
		}
		if(result.type != null) {
			out += "<tr>";
			out += "	<td>type</td>";
			out += "	<td>"+result.type+"</td>";
			out += "</tr>";
		} 
		if(result.version != null) {
			out += "<tr>";
			out += "	<td>version</td>";
			out += "	<td>"+result.version+"</td>";
			out += "</tr>";
		} 
		if(result.provider_name != null) {
			out += "<tr>";
			out += "	<td>provider_name</td>";
			out += "	<td>"+result.provider_name+"</td>";
			out += "</tr>";
		} 
		if(result.provider_url != null) {
			out += "<tr>";
			out += "	<td>provider_url</td>";
			out += "	<td>"+result.provider_url+"</td>";
			out += "</tr>";
		} 
		if(result.author_name != null) {
			out += "<tr>";
			out += "	<td>author_name</td>";
			out += "	<td>"+result.author_name+"</td>";
			out += "</tr>";
		} 
		if(result.author_url != null) {
			out += "<tr>";
			out += "	<td>author_url</td>";
			out += "	<td>"+result.author_url+"</td>";
			out += "</tr>";
		} 
		if(result.is_plus != null) {
			out += "<tr>";
			out += "	<td>is_plus</td>";
			out += "	<td>"+result.is_plus+"</td>";
			out += "</tr>";
		} 
		if(result.html != null) {
			out += "<tr>";
			out += "	<td>html<br>("+result.width+"/"+result.height+")</td>";
			out += "	<td><div style='width: 95%'>"+result.html+"</div></td>";
			out += "</tr>";
		} 
		if(result.width != null) {
			out += "<tr>";
			out += "	<td>width</td>";
			out += "	<td>"+result.width+"</td>";
			out += "</tr>";
		} 
		if(result.height != null) {
			out += "<tr>";
			out += "	<td>height</td>";
			out += "	<td>"+result.height+"</td>";
			out += "</tr>";
		} 
		if(result.duration != null) {
			out += "<tr>";
			out += "	<td>duration</td>";
			out += "	<td>"+result.duration+"</td>";
			out += "</tr>";
		} 
		if(result.description != null) {
			out += "<tr>";
			out += "	<td>description</td>";
			out += "	<td>"+result.description+"</td>";
			out += "</tr>";
		} 
		if(result.thumbnail_url != null) {
			out += "<tr>";
			out += "	<td>thumbnail_url<br>("+result.thumbnail_width+"/"+result.thumbnail_height+")</td>";
			out += "	<td><a href='"+result.thumbnail_url+"'>"+result.thumbnail_url+"</a><br><div style='width: 95%'><img src='"+result.thumbnail_url+"'><div></td>";
			out += "</tr>";
		} 
		if(result.thumbnail_width != null) {
			out += "<tr>";
			out += "	<td>thumbnail_width</td>";
			out += "	<td>"+result.thumbnail_width+"</td>";
			out += "</tr>";
		} 
		if(result.thumbnail_height != null) {
			out += "<tr>";
			out += "	<td>thumbnail_height</td>";
			out += "	<td>"+result.thumbnail_height+"</td>";
			out += "</tr>";
		} 
		if(result.thumbnail_url_with_play_button != null) {
			out += "<tr>";
			out += "	<td>thumbnail_url_with_play_button</td>";
			out += "	<td><a href='"+result.thumbnail_url_with_play_button+"'>"+result.thumbnail_url_with_play_button+"</a></td>";
			out += "</tr>";
		} 
		if(result.upload_date != null) {
			out += "<tr>";
			out += "	<td>upload_date</td>";
			out += "	<td>"+result.upload_date+"</td>";
			out += "</tr>";
		} 
		if(result.video_id != null) {
			out += "<tr>";
			out += "	<td>video_id</td>";
			out += "	<td>"+result.video_id+"</td>";
			out += "</tr>";
		} 
		if(result.uri != null) {
			out += "<tr>";
			out += "	<td>uri</td>";
			out += "	<td>"+result.uri+"</td>";
			out += "</tr>";
		}
		
		$(".resultTable").append(out);
	};
	
	ajaxFun(url, "get", query, "json", fn);
}

</script>

<body>

<header>
	<div>
		<h2>oEmbed Test2 - 웹사이트에서 provider json 받아오기</h2>
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

