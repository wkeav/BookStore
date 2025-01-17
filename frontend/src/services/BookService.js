import Books from "../components/Books";

/*
* Provides functions to interact with backend API for book data 
*/
const API_URL = 'http://localhost:8080/api/books';

const BookService =  {
    //fetch all books in JSON form
    getAllBooks: async () => {
        const response = await fetch(API_URL);
        if(!response.ok){
            throw new Error('Failed to fetch all books');
        }
        return response.json();
    },
    //fetch a book id
    getBookById: async(id) => {
        const response = await fetch (`${API_URL}/${id}`);
        if(!response.ok){
            throw new Error('Failed to fetch book');
        }
        return response.json();
    }
};
export default BookService; 