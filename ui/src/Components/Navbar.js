import React from 'react'; //rafce
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHome } from '@fortawesome/free-solid-svg-icons'; // Import the correct icon
import '../styles/Navbar.css';

const Navbar = () => {
  return (
    <div>
        <nav className="navbar">
            <ul className="nav-list">
                <li className="nav-item">
                     <Link to="/" className="nav-link">
                        <span>
                            <FontAwesomeIcon icon={faHome} /> {/* Correctly reference the imported icon */}
                        </span>
                        Home
                    </Link>
                </li>

                <li className="nav-item">
                     <Link to="/signup" className="nav-link"> {/* Use full route path */}
                        SignUp
                    </Link>         
                </li>

                <li className="nav-item">
                     <Link to="/signin" className="nav-link"> {/* Use full route path */}
                        SignIn
                    </Link>         
                </li>
            </ul>
        </nav>
    </div>
  );
}

export default Navbar;
