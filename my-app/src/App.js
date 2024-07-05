
import 'bootstrap/dist/css/bootstrap.min.css';

import React, { useState, useEffect } from 'react';

function App() {
  const [futbolistas, setFutbolistas] = useState([]);
  const [idBuscar, setIdBuscar] = useState('');
  const [futbolistaEncontrado, setFutbolistaEncontrado] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/futbolista')
      .then(response => response.json())
      .then(data => setFutbolistas(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);
  
  const handleBuscar = () => {
    fetch(`http://localhost:8080/futbolista/${idBuscar}`)
      .then(response => response.json())
      .then(data => {
        if (data) {
          setFutbolistas([data]); // Mostrar solo el futbolista encontrado
          setFutbolistaEncontrado(data); // Actualizar el estado del futbolista encontrado
        } else {
          setFutbolistas([]); // Limpiar la lista si no se encuentra ningún futbolista
          setFutbolistaEncontrado(null); // Limpiar el estado del futbolista encontrado
        }
      })
      .catch(error => console.error('Error fetching futbolista by ID:', error));
  };

  const handleChangeIdBuscar = (event) => {
    setIdBuscar(event.target.value);
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center mb-4">Futbolistas</h1>
      
      {/* Formulario de búsqueda por ID */}
      <div className="input-group mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Buscar por ID"
          value={idBuscar}
          onChange={handleChangeIdBuscar}
        />
        <div className="input-group-append">
          <button className="btn btn-outline-primary" type="button" onClick={handleBuscar}>Buscar</button>
        </div>
      </div>

      {/* Tabla de futbolistas */}
      <table className="table table-striped">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Fecha de Nacimiento</th>
            <th>Posicion</th>
            <th>Característica</th>
          </tr>
        </thead>
        <tbody>
          {futbolistas.map(futbolista => (
            <tr key={futbolista.idFutbolista}>
              <td>{futbolista.idFutbolista}</td>
              <td>{futbolista.nombres}</td>
              <td>{futbolista.apellidos}</td>
              <td>{new Date(futbolista.fechaNacimiento).toLocaleDateString()}</td>
              <td>{futbolista.posicion.descripcion}</td>
              <td>{futbolista.caracteristica}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
