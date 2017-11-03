

var api;

/*
	#############################

	API ODWOLUJACE SIE DO FUNKCJI

	#############################
*/

var tmp=1;

function tryLogin(data)
{
	if(data.status=="Security error")
		{
			alert("Bledne dane");
		}
		else if(data.status=="Ok")
		{
			console.log(data.token)
			localStorage.eregistertoken = data.token;
			loginPassed();
            //window.open("www.youraddress.com","_self")
		}
		else
		{
			alert("Inny blad, prawdopodobnie rowniez haslo");
		}
}

/*
	####################################

	Funkcje ogolne

	####################################
*/

function init()
{
	api = new ApiClient();		
}

function initMain()
{
	api.getPersonalData(setWelcomeNameSurname);
	api.getPersonalData(setWelcomeRole);	
}	

function parseJwt (token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace('-', '+').replace('_', '/');
            return JSON.parse(window.atob(base64));
        };

/*
	###########################

	FUNKCJE WYWOLYWANE PRZEZ JS

	###########################
*/

//przekazuje dane do zalogowania do odpowiedniej funkcji w API i sprawdza czy sie powiodlo
function CheckCredentials()
{	
	var log = document.getElementById('login').value;
	var pass = document.getElementById('password').value;
	api.login(log,pass);
	document.getElementById('password').value="";
}
//udalo sie zalogowac, co ma zrobic?
function loginPassed()
{
	window.open("Main.html","_self");
}

//wylogowuje uzytkownika - kasuje token oraz zmienia strone
function logOut()
{
    localStorage.eregistertoken = "";
	window.open("index.html","_self");
}

function updatePhone()
{
	var number = document.getElementById('input_phone').value;
	api.postUpdatePhone(number);
}
function updateMail()
{
	var mail = document.getElementById('input_mail').value;
	api.postUpdateMail(mail);
}
function updateAddress()
{
	var city = document.getElementById('input_city').value;
	var country = document.getElementById('input_country').value;
	var flatNumber = document.getElementById('input_flatNumber').value;
	var houseNumber = document.getElementById('input_houseNumber').value;
	var postalCode = document.getElementById('input_postalCode').value;
	var street = document.getElementById('input_street').value;
	api.postUpdateMail(city,country,flatNumber,houseNumber,postalCode,street);
}

/*
	########################

	FUNKCJE ODBIERAJACE DANE

	########################
*/

function getPersonalData(func)
{
	api.getPersonalData(func);	
}

/*
	###################################

	FUNKCJE USTAWIAJACE DANE NA STRONIE

	###################################
*/

//ustawia witajaca imie i nazwisko
function setWelcomeNameSurname(data)
{
	document.getElementById("welcome_nameSurname").innerHTML = data.personalData.name + " " + data.personalData.surname;
}

//ustawia witajaca role
function setWelcomeRole(data)
{
	document.getElementById("welcome_role").innerHTML = parseJwt(localStorage.eregistertoken).roles;
}

function getMyGrades(data)
{
	console.log(data.grades[0]);
}
function setMyData(data)
{
	document.getElementById("name").value=data.personalData.name;
}


/*

#############

   blank.htm

#############

*/

function welcome(data)
{
	document.getElementById("tekst").innerHTML = "Witaj " + data.personalData.name + " " + data.personalData.surname;
}


/*

#############

   ANGULAR

#############

*/

var app = angular.module('myApp', ["ngRoute"]);
app.controller('menuCtrl', function($scope) 
	 {		
	var whom = parseJwt(localStorage.eregistertoken).roles;
	if 		(whom=="STUDENT"){ 
		$scope.U_oceny=1;
	}
	else if (whom=="TEACHER"){
		// $scope.A_uzytkownicy=1;
		$scope.A_osoby=1;
		// $scope.A_nauczyciele=1;
		// $scope.A_opiekunowie=1;
		// $scope.A_uczniowie=1;
		//$scope.A_grupy=1;
		$scope.A_osoby=1;

		$scope.T_mojaKlasa=1;
		$scope.T_zajecia=1;
	}
	else if (whom=="GUARDIAN"){
		$scope.G_uczniowie=1;
	}
	else alert("BŁĄD?");
});

app.config(function($routeProvider) {
    $routeProvider
   .when("/", {
        templateUrl : "blank.htm",
   })
   .when("/dane_osobiste", {
        templateUrl : "dane_osobiste.htm",
   })
   //
   .when("/a_uzytkownicy", {
        templateUrl : "a_uzytkownicy.htm",
   })
   .when("/a_uczniowie", {
        templateUrl : "a_uczniowie.htm",
   })
   .when("/a_nauczyciele", {
        templateUrl : "a_nauczyciele.htm",
   })
   .when("/a_opiekunowie", {
        templateUrl : "a_opiekunowie.htm",
   })
   .when("/a_osoby", {
        templateUrl : "a_osoby.htm",
   })
   .when("/a_grupy", {
        templateUrl : "a_grupy.htm",
   })
   //
   .when("/u_oceny", {
        templateUrl : "u_oceny.htm",
   })
   //
   .when("/g_uczniowie", {
        templateUrl : "g_uczniowie.htm",
   })
   //
   .when("/t_mojaKlasa", {
        templateUrl : "t_mojaKlasa.htm",
   })
   .when("/t_zajecia", {
        templateUrl : "t_zajecia.htm",
   })
   .when("cc_nowyUzytkownik", {
        templateUrl : "cc_nowyUzytkownik.htm",
   })
   .when("/t_klasa/:param", {
	    controller : function($scope , $routeParams)
		{
			$scope.klasa = $routeParams.param
		},
        templateUrl : "t_klasa.htm",
   })
   .when("/cc_addGrade/:param2/:param3", {
	    controller : function($scope , $routeParams)
		{
			$scope.lekcja	= $routeParams.param2;
			$scope.uczen 		= $routeParams.param3;
		},
        templateUrl : "cc_addGrade.htm",
   })
    .when("/cc_addSemifinalGrade/:param2/:param3", {
	    controller : function($scope , $routeParams)
		{
			$scope.lekcja	= $routeParams.param2;
			$scope.uczen 	= $routeParams.param3;
		},
        templateUrl : "cc_addSemifinalGrade.htm",
   })
       .when("/cc_addFinalGrade/:param2/:param3", {
	    controller : function($scope , $routeParams)
		{
			$scope.lekcja	= $routeParams.param2;
			$scope.uczen 	= $routeParams.param3;
		},
        templateUrl : "cc_addFinalGrade.htm",
   })
   .when("/cc_updatePartialGrade/:param/", {
	    controller : function($scope , $routeParams)
		{
			$scope.id	= $routeParams.param;
		},
        templateUrl : "cc_updatePartialGrade.htm",
   })
   .when("/cc_ocenyUcznia/:param", {
	    controller : function($scope , $routeParams)
		{
			$scope.id = $routeParams.param
		},
        templateUrl : "cc_uczenOceny.htm",
   })
      .when("/cc_changePersonalData/:param", {
	    controller : function($scope , $routeParams)
		{
			$scope.id = $routeParams.param
		},
        templateUrl : "cc_changePersonalData.htm",
   })



});


const IP="http://157.158.16.186:8090"

app.controller("dane", function($scope,$http){
	$scope.mojeDane = function(){
		$http({
			url: IP+"/People/myPersonalData",
			method: "GET",
			//data: "json",
			headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
					},
		}).then(function(data, status, headers, config) {
			$scope.data = data;
			$scope.user = data.data.personalData;
			$scope.name = data.data.personalData.name;
			$scope.surname = data.data.personalData.surname;
			$scope.dateOfBirth = data.data.personalData.dateOfBirth;
			$scope.sex = data.data.personalData.sex;
			$scope.phone = data.data.personalData.phone;
			$scope.mail = data.data.personalData.mail;
			$scope.idAddress = data.data.personalData.street + " " + data.data.personalData.houseNumber + " " + data.data.personalData.flatNumber +  " ," + data.data.personalData.city + " " +data.data.personalData.postalCode;
		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$scope.daneOsobowe = function(){
		$http({
			url: IP+"/People/Person/id="+$scope.id,
			method: "GET",
			//data: "json",
			headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
					},
		}).then(function(data, status, headers, config) {
			$scope.data = data;
			$scope.user = data.data.person;
			$scope.name = data.data.person.name;
			$scope.surname = data.data.person.surname;
			$scope.dateOfBirth = data.data.person.dateOfBirth;
			$scope.sex = data.data.person.sex;
			$scope.phone = data.data.person.phone;
			$scope.mail = data.data.person.mail;
			// $scope.idAddress = data.data.person.street + " " + data.data.person.houseNumber + " " + data.data.person.flatNumber +  " ," + data.data.person.city + " " +data.data.person.postalCode;
		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$scope.updatePhone = function()
	{
		$http({
			url: IP+"/People/updatePhone",
			method: "POST",
			//data: "json",
			headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
			data:
			{
				 	// "idPerson": $scope.data.data.personalData.idPerson,
  					// "phone": document.getElementById("phone").value
					"idPerson": $scope.data.data.personalData.idPerson,
  					"phone": document.getElementById("phone").value
			},
		}).then(function(data, status, headers, config) {
			console.log(data);

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$scope.updateMail = function()
	{
		$http({
			url: IP+"/People/updateMail",
			method: "POST",
			//data: "json",
			headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
				},
			data:
			{
				 	// "idPerson": $scope.data.data.personalData.idPerson,
  					// "phone": document.getElementById("phone").value
					"idPerson": $scope.data.data.personalData.idPerson,
  					"mail": document.getElementById("mail").value
			},
		}).then(function(data, status, headers, config) {
			console.log(data);

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
});

app.controller("a_opiekunowie", function($scope,$http){
	$http({
		url: IP+"/EregUsers/guardians",
		method: "GET",
		//data: "json",
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.data = data.data.usersList;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("a_osoby", function($scope,$http){
	$scope.deleteUser = function(param)
	{
			$http({
			url: IP+"/People/Person/id="+param,
			method: "DELETE",
			//data: "json",
			headers: {
					"Content-Type":"application/json",
					"Authorization":localStorage.eregistertoken,
					},
		}).then(function(data, status, headers, config) {
			alert(data.data.message);

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$http({
		url: IP+"/People",
		method: "GET",
		//data: "json",
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.data = data.data.people;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("u_przedmioty", function($scope,$http){
	$http({
		url: IP+"/Lessons/student/myLessons",
		method: "GET",
		//data: "json",
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.lessons = data.data.lessons;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("u_oceny", function($scope,$http,$attrs){
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		url: IP+"/Grades/myPartialGrades/"+$scope.sectionIndex,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.grades = data.data.grades;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});



app.controller("u_semiGrade", function($scope,$http,$attrs){	
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		url: IP+"/Grades/mySemifinalGrades/"+$scope.sectionIndex,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.semifinalGrade = data.data.grades;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});



app.controller("t_zajecia", function($scope,$http,$attrs){
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		url: IP+"/Lessons/teacher/myLessons",
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.data = data.data.lessons;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

// app.controller("t_zajecia", function($scope,$http,$attrs){
// 	$http({
// 		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
// 		url: IP+"/Groups/teacher/myGroups/",
// 		method: "GET", 
// 		headers: {
// 				"Content-Type":"application/json",
// 				"Authorization":localStorage.eregistertoken,
// 				},
// 	}).then(function(data, status, headers, config) {
// 		$scope.data = data.data.groups;

// 	}),(function(data, status, headers, config) {
// 		$scope.status = status;
// 	});
// });




app.controller("g_uczniowie", function($scope,$http,$attrs){
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		url: IP+"/People/myChildren",
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.data = data.data.people;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});


app.controller("t_klasa", function($scope,$http){
	$http({
		url: IP+"/Groups/attendingStudents/"+$scope.klasa,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.data = data.data.people;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
	$http({
		url: IP+"/Groups/myClass/",
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.dataClass = data.data.groupClass;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("cc_przedmiotyUcznia", function($scope,$http){
	$http({
		url: IP+"/Lessons/student/lessons/userId="+$scope.id,
		method: "GET",
		//data: "json",
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.lessons = data.data.lessons;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("cc_ocenyUcznia", function($scope,$http){
	$http({
		url: IP+"/Grades/userPartialGrades/"+$scope.sectionIndex+"/lesson/"+$scope.id,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.grades = data.data.grades;	

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("cc_finalGrade", function($scope,$http,$attrs){	
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		// url: IP+"/Grades/userFinalGrades/"+$scope.id+"/lesson/"+$scope.sectionIndex,
		url: IP+"/Grades/userFinalGrades/"+$scope.sectionIndex+"/lesson/"+$scope.id,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.finalGrade = data.data.grades;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("cc_semiGrade", function($scope,$http,$attrs){	
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		url: IP+"/Grades/userSemifinalGrades/"+$scope.sectionIndex+"/lesson/"+$scope.id,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.semifinalGrade = data.data.grades;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("t_mojaKlasa", function($scope,$http,$attrs){	
	$http({
		// url: IP+"/Grades/myPartialGrades/"+$attrs.model,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.semifinalGrade = data.data.grades;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("cc_userClass", function($scope,$http){	
	$http({
		 url: IP+"/Groups/userClass/userId="+$scope.id,
		method: "GET", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
				},
	}).then(function(data, status, headers, config) {
		$scope.groupClass = data.data;

	}),(function(data, status, headers, config) {
		$scope.status = status;
	});
});

app.controller("newGrade", function($scope,$http){		
	// $http({
	// 	url: IP+"/Grades/userPartialGrades/"+$scope.uczen+"/lesson/"+$scope.lekcja,
	// 	method: "GET", 
	// 	headers: {
	// 			"Content-Type":"application/json",
	// 			"Authorization":localStorage.eregistertoken,
	// 			},
	// }).then(function(data, status, headers, config) {
	// 	$scope.input_mark = data.data.grades.mark;	

	// }),(function(data, status, headers, config) {
	// 	$scope.status = status;
	// });
	$scope.addFinalGrade = function()
		{
		$http({
		url: IP+"/Grades/newFinalGrade/",
		method: "POST", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
			},
		data:
			{
				    "date": new Date().toJSON().slice(0,10).replace(/-/g,'/'),
					"idLesson": $scope.lekcja,
					"idStudent": $scope.uczen,
					"mark": document.getElementById("input_mark").value,
			},
		}).then(function(data, status, headers, config) {
			// $scope.groupClass = data.data;
			alert(data.data.message)

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$scope.addSemifinalGrade = function()
		{
		$http({
		url: IP+"/Grades/newSemifinalGrade/",
		method: "POST", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
			},
		data:
			{
				    "date": new Date().toJSON().slice(0,10).replace(/-/g,'/'),
					"idLesson": $scope.lekcja,
					"idStudent": $scope.uczen,
					"mark": document.getElementById("input_mark").value,
			},
		}).then(function(data, status, headers, config) {
			// $scope.groupClass = data.data;
			alert(data.data.message)

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$scope.addPartialGrade = function()
		{
		$http({
		url: IP+"/Grades/newPartialGrade/",
		method: "POST", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
			},
		data:
			{
				    "date": new Date().toJSON().slice(0,10).replace(/-/g,'/'),
					"description": document.getElementById("input_description").value,
					"idLesson": $scope.lekcja,
					"idStudent": $scope.uczen,
					"mark": document.getElementById("input_mark").value,
					"weight": document.getElementById("input_weight").value
			},
		}).then(function(data, status, headers, config) {
			// $scope.groupClass = data.data;
			alert(data.data.message)

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
	$scope.updatePartialGrade = function()
		{
			$http({
		url: IP+"/Grades/updatePartialGrade/"+$scope.id,
		method: "POST", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
			},
		data:
			{
				    "date": new Date().toJSON().slice(0,10).replace(/-/g,'/'),
					"description": document.getElementById("input_description").value,
					"idLesson": $scope.lekcja,
					"idStudent": $scope.uczen,
					"mark": document.getElementById("input_mark").value,
					"weight": document.getElementById("input_weight").value
			},
		}).then(function(data, status, headers, config) {
			// $scope.groupClass = data.data;
			console.log(data.data.message);

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
		$scope.deletePartialGrade = function()
		{
			$http({
		url: IP+"/Grades/partialGradeId="+$scope.id,
		method: "DELETE", 
		headers: {
				"Content-Type":"application/json",
				"Authorization":localStorage.eregistertoken,
			},
		}).then(function(data, status, headers, config) {
			// $scope.groupClass = data.data;
			console.log(data.data.message);

		}),(function(data, status, headers, config) {
			$scope.status = status;
		});
	}
});

