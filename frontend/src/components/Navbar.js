import React from 'react';

function Navbar({ setCurrentPage, currentPage}){
    return(
        <nav className="navbar">
            <div className="navbar-content">
                <span 
                    className="navbar-brand"
                    onClick={() => setCurrentPage('home')}
                    style={{cursor: 'pointer'}}
                >
                Astra's BookStore
                </span>
                <div className="navbar-links">
                    <button
                        className={`nav-link ${currentPage === 'books' ? 'active' : ''}`}
                        onClick={() => setCurrentPage('books')}
                    >
                        Books
                    </button>
                    <button
                        className={`nav-link ${currentPage === 'login' ? 'active' : ''}`}
                    >
                        Login 
                    </button>
                    <button
                        className={`nav-link ${currentPage === 'cart' ? 'active' : ''}`}
                        onClick={() => setCurrentPage('cart')}
                    >
                        Cart
                    </button>
                </div>
            </div>
        </nav>
    );
}
export default Navbar;