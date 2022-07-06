
document.getElementById("mostrarLista").addEventListener("click", mostrarListaAutores);
document.getElementById("editarAutor").addEventListener("click", cargarDatosAutorModal)


function mostrarListaAutores()
{
    let tablaUsuario= document.getElementById("tablaUsuario");
    tablaUsuario.style.display = "";
}

function cargarDatosAutorModal(this)
{
    console.log("hola mundo");
}