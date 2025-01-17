import React, { useState } from 'react';
function Login(){
    //formData is in the form of email & password 
    const [formData,setFormData] = useState({
        email: '',
        password: ''
    });
    //error handling
    const [error, setError] = useState('');
    
    //onchange listener, update data from user input 
    const onChange = (e) => {
        const{name, value} = e.target; // name = email or password , value = enter by user 
        setFormData(prevState => ({
            ...prevState,  //keeping all previous values
            [name]:value //only update the field that has changed 
        }));
    };
    

    const handleSubmit = async (e) => {
        e.preventDefault(); //causes page to reload 
        //validate if both input are fill 
        if(!formData.email || !formData.password){
            setError("Please fill in all fields!");
            return;
        }
        console.log('Login attempted: ', formData);
        setError('');

    };

    return(
    <div className="login-container">
        <form className="login-form" onSubmit={handleSubmit}>
            <h2>Login</h2>
            {error && <div className="error-message"> {error}</div>}
            <div className="form">
                <label>Email:</label>
                <input
                    type="email"
                    id="email"
                    name="email"
                    value={formData.email}
                    onChange={onChange}
                    placeholder="Enter your email"
                />
            </div>
            <div className="form">
                    <label>Password:</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={onChange}
                        placeholder="Enter your password"
                    />
                </div>
                <button className="login-btn" type="submit">Login</button>
        </form>
    </div>
    );
}
export default Login;