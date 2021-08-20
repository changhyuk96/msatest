<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
	<title>My Awesome SignUp Page</title>
<jsp:include page="../common/common.jsp"></jsp:include>	

	
	<script>
	
		function signUpAction(){
			
			if($('#u_id').val() == null || $('#u_id').val() ==''){
				alert('ID를 입력해주세요.');
				return;
			}
			if($('#u_name').val() == null || $('#u_name').val() ==''){
				alert('Name을 입력해주세요.');
				return;
			}
			else if($('#u_password').val() == null || $('#u_password').val() == ''){
				alert('Password를 입력해주세요.')
				return;
			}
					
			let params = $('#signUpForm').serialize();
			$.ajax({
				 url:'/signUpAction'
				,type:'post'
				,data:params
				,success:function(data,status,xhr){
					
					alert(data);
					if(data.includes('가입'))
						location.href='/login';
				}
				,error: function(error){
					console.log(error);
				}
			});
		}
	</script>
</head>
<!--Coded with love by Mutiullah Samim-->
<body>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center" style="text-align: center;margin: 50px 0 50px 0;">
					<div class="brand_logo_container">
						<img src="https://cdn.freebiesupply.com/logos/large/2x/pinterest-circle-logo-png-transparent.png" class="brand_logo" alt="Logo" style=width:10%>
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form name=signUpForm id=signUpForm method="post" action='/signUpAction'>
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="u_id" id=u_id class="form-control input_user" value="" placeholder="userId">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="u_name" id=u_name class="form-control input_user" value="" placeholder="username">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="u_password" id=u_password class="form-control input_pass" value="" placeholder="password">
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
				 			<button type="button" name="button" class="btn login_btn" onclick="signUpAction()">SignUp</button>
				   		</div>
					</form>
				</div>
		
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Do you have an account? <a href="/login" class="ml-2">login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
