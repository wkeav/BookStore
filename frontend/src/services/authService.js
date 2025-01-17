
/*
 * Handles user authentication by communicating with backend API:
 * - Login: send a Post request to /login backend with user's email & password. If successful it stores the retrieve token in localStorage for management 
 * - Logout: remove token from user's browser, effectively logging the user out
 * - getCurrentUser: get the current user by retrieving their token, to check if a user is logged in
 */
const API_URL = 'http://localhost:8080/api/auth';

const AuthService = {
    //login method process using an async function 
    login: async (email,password) => {
        const response = await fetch(`${API_URL}/login`, {
            Method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({email,password})  //in JSON format 
        });
        //if response is not in 200 
        if (!response.ok){
            throw new Error("Login failed!");
        }

        //saving the received token in localStorage
        //token can then be use to authenticate the user, without needing to re-enter login credentials next time
        const data = await response.json();
        localStorage.setItem('token', data.token);
        return data;
    },
    //clears the authentication token from the browser
    logout: () => {
        localStorage.removeItem('token');
    },

    getCurrentUser: () => {
        return localStorage.getItem('token');
    }
};
export default authService;