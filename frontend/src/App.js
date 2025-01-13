import React, {useState} from 'react';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Books from './components/Books';
import Cart from './components/Cart';
import Login from './components/Login';
import './App.css';

function App() {
    const [currentPage,setCurrentPage] = useState('home');

    //render between pages, by default it is set to home 
    const renderPage = () => {
      switch(currentPage) {
        case 'home':
          return <Home />;
        case 'books':
          return <Books />;
        case 'cart':
          return <Cart />;
        case 'login':
          return <Login />
        default:
          return <Home />;
      }
    };
  
  
  return (
      <div className="App">
        <Navbar  currentPage={currentPage} setCurrentPage={setCurrentPage}/>
        <main className="main">
        {renderPage()}
        </main>
      </div>
    );
}
export default App;
