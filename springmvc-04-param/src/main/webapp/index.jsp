<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
	</head>
	<body>
		<h2>测试数组传参</h2>
		<form enctype="application/x-www-form-urlencoded" action="${pageContext.request.contextPath }/complex/array" method="post">
			爱好:
				<input type="checkbox" name="hobby" value="踢球">踢球
				<input type="checkbox" name="hobby" value="听音乐">听音乐
				<input type="checkbox" name="hobby" value="看书">看书
			<br><br>
			<input type="submit" value="测试数组传参">
		</form>
		<h2>测试list传参</h2>
		<form enctype="application/x-www-form-urlencoded" action="${pageContext.request.contextPath }/complex/list" method="post">
			爱好:
				<input type="checkbox" name="hobbyList" value="踢球">踢球
				<input type="checkbox" name="hobbyList" value="听音乐">听音乐
				<input type="checkbox" name="hobbyList" value="看书">看书
			<br><br>                                  
			<input type="submit" value="测试list传参">
		</form><br><hr>
		<button id="testMap" type="button">测试map传参</button><br><br>
		<button onclick="jsonToMap()" type="button">测试json传参</button><br><br>
		<button onclick="jsonToList()" type="button">测试jsonToList传参</button><br><br>
		<button onclick="jsonToBean()" type="button">测试jsonToBean传参</button><br><br>
		
		<script type="text/javascript"
		 src="${pageContext.request.contextPath }/static/js/jquery.min.js"></script>
		<script type="text/javascript">
			const path = "${pageContext.request.contextPath }";
			$(function(){
				//alert(path);
				$('#testMap').click(()=>{
					$.ajax({
						url:path + '/complex/map',
						type:'post',
						dataType:'text',
						data:"stuMap['id']=1&stuMap['name']=zs",
						success:function(data){
							alert(data);
						}
					})
				})
			})
			
			function jsonToMap(){
				//js对象
				let obj = {id:1,name:"zs"};
				$.ajax({
					url:path + "/json/jsonToMap",
					type:'post',
					dataType:'json',
					data:JSON.stringify(obj),//将js对象转换成json字符串
					contentType:'application/json;charset=UTF-8',
					success:function(data){
						alert(data.msg);
					}
				})	
				
			}
			
			function jsonToList(){
				let array = [{id:2,name:"et1910",age:22}];
				let user = {id:1,name:"et1911",age:20};
				array.push(user);
				$.ajax({
					url:path + '/json/jsonToList',
					type:'post',
					data:JSON.stringify(array),
					dataType:'json',
					contentType:'application/json;charset=UTF-8',
					success:function(data){
						alert(data.code + ":" + data.msg);
					}
				})
			}
			
			function jsonToBean(){
				let obj = {
						id:1,
						name:"et1911",
						age:20,
						hobbyList:['看书','听音乐'],
						stuMap:{id:2,score:120}
				};
				$.ajax({
					url:path + '/json/jsonToBean',
					type:'post',
					data:JSON.stringify(obj),
					dataType:'json',
					contentType:'application/json;charset=UTF-8',
					success:function(data){
						alert(data.code + "-" + data.msg);
					}
				})
			}
					
		</script>
			
	</body>
	
</html>
