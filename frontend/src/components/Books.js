import React from 'react'; 

function Books(){
    const sampleBooks =[
        {id: 1, title: 'Sample Book1', author: 'Author1', price: 29.99},
        {id: 2, title: 'Sample Book 2', author: 'Author 2', price: 19.990},
        {id: 3, title: 'Sample Book 3', author: 'Author 3', price: 24.99}
    ];

    //return each book with a "card" displaying title, author, price and an add to cart button
    return (
        <div>
            <h2>Available Books</h2>
            <div className="book-grid">
            {sampleBooks.map((book)=>
            (<div key={book.id} className="card">
                <div className="card-content">
                <h3 className="book-title">{book.title}</h3>
                <p className="book-author">{book.author}</p>
                <p className="book-price">{book.price}</p>
                <button className="add-to-cart-btn">Add to Cart</button>
                </div>
            </div>
            ))}
            </div>
        </div>
    );
}
export default Books; 