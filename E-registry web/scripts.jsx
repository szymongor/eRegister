

var api;

function init()
{
	api = new ApiClient();		
}	

function tryLogin(data)
{
	if(data.status=="Security error")
		{
			console.log("zle dane")
		}
		else if(data.status=="Ok")
		{
			console.log(data.token)
			localStorage.eregistertoken = data.token;
            window.open("www.youraddress.com","_self")
		}
}

function logOut()
{
    localStorage.eregistertoken = "";
}

function CheckCredentials()
{	
	var log = document.getElementById('login').value;
	var pass = document.getElementById('password').value;
	api.login(log,pass);
}