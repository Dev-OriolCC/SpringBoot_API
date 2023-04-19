import React from 'react';
import { Link } from 'react-router-dom';

export const Navbar = () => {
    return (
        <nav className="Navbar">
            <div className="container">
                <p>Navbar</p>
                <Link to="/home">Home</Link>
                {/* <ul className="Navbar-links">
                    <li>
                        <Link to="/home">Home</Link>
                    </li>
                    <li>
                        <Link to="/home">About</Link>
                    </li>
                    <li>
                        <Link to="/home">Contact</Link>
                    </li>
                </ul> */}
            </div>
        </nav>
    );
}

export default Navbar;
