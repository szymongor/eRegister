function ApiClient(){  	

	const IP="http://157.158.16.186:8090"

	  this.login = function(login,pass){
		$.ajax({
				type: 'POST',
				crossDomain: true,
				url: IP+'/auth',
				data: JSON.stringify({'login':login,'password':pass}),
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				success: function(data){
			//Tu co zrobić z wynikiem
			//Sprawdzić status i jeśli jest ok to zapisać token					
					tryLogin(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
	  	 this.getMyGrades = function(){
		$.ajax({
				type: 'GET',
				crossDomain: true,
				url: IP+"/Grades/myPartialGrades",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){	
					getMyGrades(data);		
					console.log(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }

		this.showUsers = function(){
		$.ajax({
				type: 'GET',
				crossDomain: true,
				url: IP+"/EregUsers",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){			
					console.log(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }

	  this.myStudentLessons = function(){
		$.ajax({
				type: 'GET',
				crossDomain: true,
				url: IP+"/Lessons/student/myLessons",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){			
					console.log(data.lessons);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
	  
	
	  this.getPersonalData = function(f)
	  {
		  $.ajax({
				type: 'GET',
				crossDomain: true,
				url: IP+"/People/myPersonalData",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){
					f(data);
					/*
					"idPerson": 4,
					"name": "Paweł",
					"surname": "Mamek",
					"dateOfBirth": "1966-08-14",
					"sex": "mężczyzna",
					"phone": "514847817",
					"mail": null,
					"expirationDate": "2019-08-31",
					"idAddress": 2,
					"street": "Zwycięstwa",
					"houseNumber": "68",
					"flatNumber": 3,
					"postalCode": "44-100",
					"city": "Gliwice",
					"country": "Polska"
					*/
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
	  this.postUpdatePhone = function(number)
	  {
		  $.ajax({
				type: 'POST',
				crossDomain: true,
				url: IP+"/People/updatePhone/",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data:
				JSON.stringify(
				{
					"idPerson":$scope.user.id,
					"phone":number,
				}),
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){
					console.log(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
	  this.postUpdateMail = function(mail)
	  {
		  $.ajax({
				type: 'POST',
				crossDomain: true,
				url: IP+"/People/updateMail/",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data:
				JSON.stringify(
				{
					"e-mail":mail,
				}),
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){
					console.log(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
	  this.postUpdateAddress = function(city,country,flatNumber,houseNumber,postalCode,street)
	  {
		  $.ajax({
				type: 'POST',
				crossDomain: true,
				url: IP+"/People/updateAddress",				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data:
				JSON.stringify(
				{
						"city": city,
						"country": country,
						"flatNumber": flatNumber,
						"houseNumber": houseNumber,
						"idAddress": 0,
						"postalCode": postalCode,
						"street": street
				}),
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){
					console.log(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
	  this.deleteUser = function(id)
	  {
		  $.ajax({
				type: 'DELETE',
				crossDomain: true,
				url: IP+"/People/Person/id="+id,				
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
				success: function(data){
					console.log(data);
				},
				error: function (request, status, error) {
					console.log(error);
				}
			});
	  }
}

