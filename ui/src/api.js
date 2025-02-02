// src/api.js
import axios from "axios";

// Set your backend URL
const API_URL = "http://localhost:8080/api/courses";  // Make sure this matches your Spring Boot backend URL

const api = axios.create({
  baseURL: API_URL,
});

export default api;

