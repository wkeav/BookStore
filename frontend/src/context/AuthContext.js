import React, {createContext, useState, useContext, useSyncExternalStore} from 'react'; 
/*
* Tell authentication state across application; telling the application when a user is logged in/logged out
*/
const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {

    const [isAuthenticated, setIsAuthenticated] = useState(false); // dynamic user authentication 
    const [user, setUser] = useState(null); //user information 

    //when a user logs in
    const login = (userData) => {
        setIsAuthenticated(true); 
        setUser(userData); //save their info
    };

    //when user logs out 
    const logout = () => {
        setIsAuthenticated(false);
        setUser(null); //remove their info
    };

    return(
        //context provider component that will be wrapped around the application
        <AuthContext.Provider 
            value={{isAuthenticated, user, login, logout}}
        >
            {children}
        </AuthContext.Provider>
    );
};

//useContext is a React hook that gives the current context for AuthContext
// in this case, it is isAuthenticated, user, login & logout 
//this allow other components in React, to access the authentication context 
export const useAuth = () => useContext(AuthContext);