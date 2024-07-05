import axios from 'axios';

// URL base de tu API de Spring Boot
const API_URL = 'http://localhost:8080/futbolista';    
export const fetchFutbolistas = async () => {
    try {
      const response = await axios.get(API_URL);
      return response.data;
    } catch (error) {
      console.error('Error al obtener los futbolista:', error);
      return [];
    }
  };