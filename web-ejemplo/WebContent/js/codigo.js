// Ya que el c�digo est� separado (en otro fichero fuera del html)
// Lo voy a separar todo
// Y voy a poner los eventos desde aqu�

function testAjax(){
	ajax = new XMLHttpRequest();
	
	// abro conexi�n
	ajax.open(
			"POST",
			"http://localhost:8080/web-ejemplo/rest/adios/Oliver", 
			true);
	//pero como la petici�n y la respuesta son as�ncronas =true
	// la respuesta hay que preparla antes del env�o (ser� un evento)
	ajax.onreadystatechange = responder;
	//tengo que hacer la petici�n
	ajax.send();
}

function responder(){
	if (ajax.readyState == 4 && ajax.status == 200) {
		var resultado = ajax.responseText;
		alert(resultado);
	}
}

// me invento una funci�n main
function main(){
	//Aqu� voy a enlazar todos los eventos
	var boton1 = document.getElementById("probarAJAX");
	boton1.onclick = testAjax;
}
// La funci�n main se ejecuta cuando se cargue la p�gina.
// document.onreadystatechange = main;
window.onload = main;