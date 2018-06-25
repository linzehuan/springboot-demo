<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.pic{
		position:absolute;
		height: 240px;
		width: 200px;
		left: 50%;
		transform: translateX(-50%);
		top: 20%;
	}
</style>
</head>
<body>

	<img class="pic" alt="停车二维码" src="./static/img/park.png">

	<script type="text/javascript" src="./static/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		var items = document.getElementsByClassName('pic');
		var itemsLength = items.length;
		var mask = document.getElementById('mask');
		for(var i=0; i<itemsLength; i++){
		  items[i].addEventListener('touchstart', function(){
		    var _self = this;
		    var clnQrImg = this.querySelector('img').cloneNode(true);
		    mask.appendChild(clnQrImg);
		    mask.style.display = 'block';
		    mask.querySelector('img').addEventListener('touchend', function(){
		      mask.style.display = 'none';
		      mask.innerHTML = '';
		    },false);
		  },false);
		}	
	</script>
</body>
</html>