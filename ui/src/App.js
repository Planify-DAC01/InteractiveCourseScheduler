import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { useState } from 'react';
import SignIn from './Components/SignIn';
import './App.css';
import Main from './Components/Main';
import Footer from './Components/Footer';
import Navbar from './Components/Navbar';
import SignUp from './Components/SignUp';
import { library } from "@fortawesome/fontawesome-svg-core";
import { faCoffee, faHome, faPeopleGroup } from "@fortawesome/free-solid-svg-icons";

// Adding FontAwesome icons to the library
library.add(faCoffee, faHome, faPeopleGroup);

function App() {
  // State to store the current user
  const [user, setUser] = useState(null);

  return (
    <div>
      <div className="App">
        <header className="App-header">
          {/* Add any logo or header image if required */}
          <h1>Planify</h1>
        </header>
      </div>

      <section>
        <div className='Main'>
          <Router>
            <Navbar />  {/* Navbar is rendered globally */}
            <Routes>
              <Route path="/" element={<Main />} />
              <Route 
                path="/signup" 
                element={<SignUp setUser={setUser} />}  // Pass setUser function to SignUp
              />
              <Route 
                path="/Signin" 
                element={<SignIn setUser={setUser} />}  // Pass setUser function to SignIn
              />
            </Routes>
          </Router>
        </div>
      </section>

      <div id="footer">
        <Footer />  {/* Footer is rendered globally */}
      </div>
    </div>
  );
}

export default App;
