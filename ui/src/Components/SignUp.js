import React, { useState } from 'react';
import axios from 'axios';

const RegistrationForm = () => {
  // Step 1: Set up state for form fields
  const [formData, setFormData] = useState({
      firstname: "",
      lastname: "",
      email: "",
      password: "",
      mobilenumber: "",
      category: "",
  });

  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);

  // Step 2: Handle form input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // Step 3: Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Step 3.1: Basic client-side validation
    if (!formData.firstname || !formData.lastname || !formData.email || !formData.password || !formData.mobilenumber || !formData.category) {
      setError('All fields are required!');
      return;
    }

    // Step 3.2: Clear previous error/success messages
    setError(null);
    setSuccess(false);
    setLoading(true);

    try {
      // Step 4: Send POST request to API with form data
      const response = await axios.post('http://localhost:8080/api/signup', formData);

      // Step 5: Handle the response (on success)
      if (response.status === 201) { // Check if the status code is 201 (Created)
        setSuccess(true);
        setFormData({
          firstname: "",
          lastname: "",
          email: "",
          password: "",
          mobilenumber: "",
          category: "",
        });
      } else {
        setError('Registration failed. Please try again.');
      }
    } catch (err) {
      // Step 5.1: Handle errors (e.g., network errors)
      setError('An error occurred. Please try again later.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="registration-form">
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        {/* First Name */}
        <div>
          <label htmlFor="firstname">First Name</label>
          <input
            type="text"
            id="firstname"
            name="firstname"
            value={formData.firstname}
            onChange={handleChange}
          />
        </div>

        {/* Last Name */}
        <div>
          <label htmlFor="lastname">Last Name</label>
          <input
            type="text"
            id="lastname"
            name="lastname"
            value={formData.lastname}
            onChange={handleChange}
          />
        </div>

        {/* Email */}
        <div>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
        </div>

        {/* Password */}
        <div>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
        </div>

        {/* Mobile Number */}
        <div>
          <label htmlFor="mobilenumber">Mobile Number</label>
          <input
            type="text"
            id="mobilenumber"
            name="mobilenumber"
            value={formData.mobilenumber}
            onChange={handleChange}
          />
        </div>

        {/* Category */}
        <div>
          <label htmlFor="category">Category</label>
          <select
            id="category"
            name="category"
            value={formData.category}
            onChange={handleChange}
          >
            <option value="">Select Category</option>
            <option value="Student">Student</option>
            <option value="Coordinator">Coordinator</option>
            <option value="Faculty">Faculty</option>
          </select>
        </div>

        {/* Submit Button */}
        <div>
          <button type="submit" disabled={loading}>
            {loading ? 'Registering...' : 'Register'}
          </button>
        </div>
      </form>

      {/* Error & Success Messages */}
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {success && <p style={{ color: 'green' }}>Registration successful!</p>}
    </div>
  );
};

export default RegistrationForm;
