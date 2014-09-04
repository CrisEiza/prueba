// Ya que el código está separado (en otro fichero fuera del html)
// Lo voy a separar todo
// Y voy a poner los eventos desde aquí

function testAjax(){
	ajax = new XMLHttpRequest();
	
	// abro conexión
	ajax.open(
			"POST",
			"http://localhost:8080/web-ejemplo/rest/adios/Oliver", 
			true);
	//pero como la petición y la respuesta son asíncronas =true
	// la respuesta hay que preparla antes del envío (será un evento)
	ajax.onreadystatechange = responder;
	//tengo que hacer la petición
	ajax.send();
}

function responder(){
	if (ajax.readyState == 4 && ajax.status == 200) {
		var resultado = ajax.responseText;
		alert(resultado);
	}
}

// me invento una función main
function main(){
	//Aquí voy a enlazar todos los eventos
	var boton1 = document.getElementById("probarAJAX");
	boton1.onclick = testAjax;
}
// La función main se ejecuta cuando se cargue la página.
// document.onreadystatechange = main;
window.onload = main;