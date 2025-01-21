import React, { useEffect, useState } from 'react'; 
import BookService from '../services/BookService';

function Books(){
    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    //function to fetch all books from backend 
    useEffect(() => {
        console.log('Books component mounted');
        fetchBooks(); //Fetch data from an API 
    },[]); //run once

    const fetchBooks = async () => {
        try{
            setLoading(true);
            console.log('Fetching books...');
            const data = await BookService.getAllBooks();
            console.log('Received books:', data);
            setBooks(data); 
        } catch (error) {
            console.error('Error details:', error);
            setError('Failed to fetch books. Please try again later.');
        } finally {
            setLoading(false);
        }
    };

    console.log('Current state:', { loading, error, booksLength: books.length });

    if (loading) {
        return <div className="loading">Loading books...</div>;
    }

    if (error) {
        return <div className="error">{error}</div>;
    }

    //return each book with a "card" displaying title, author, price and an add to cart button
    return (
        <div>
            <h2 className="book-page">Available Books</h2>
            <div className="book-grid">
            {books && books.length > 0 ? (
                books.map((book) => (
                    <div key={book.id} className="card">
                        <div className="card-content">
                            <h3 className="book-title">{book.title}</h3>
                            <p className="book-author">{book.author}</p>
                            <p className="book-price">${book.price}</p>
                            <button className="add-to-cart-btn">Add to Cart</button>
                        </div>
                    </div>
                ))
            ) : (
                <div>No books available</div>
            )}
            </div>
        </div>
    );
}

export default Books; 