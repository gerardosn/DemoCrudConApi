// Obtener el elemento tbody de la tabla
const cuerpoTabla = document.getElementById('cuerpo-tabla');

// Función para renderizar los datos en la tabla
function renderizarDatos(datos) {
    // Limpiar el contenido del tbody
    cuerpoTabla.innerHTML = '';

    // Recorrer los datos y renderizar cada fila
    datos.forEach((dato) => {
        const fila = document.createElement('tr');
        fila.innerHTML = `
            <td>${dato.id}</td>
            <td>${dato.nombre}</td>
            <td>${dato.habilitadoParaIngresar ? 'Sí' : 'No'}</td>
            <td>${dato.habilitadoHastaLaFecha}</td>
        `;
        cuerpoTabla.appendChild(fila);
    });
}

// Realizar la solicitud GET al endpoint /api/mostrarDatos
fetch('/api/mostrarDatos')
    .then((respuesta) => respuesta.json())
    .then((datos) => renderizarDatos(datos))
    .catch((error) => console.error('Error al obtener los datos:', error));