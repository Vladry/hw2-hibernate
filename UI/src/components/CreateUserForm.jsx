import React from 'react';
import Button from "@material-ui/core/button";

const CreateUserForm = () => {

    const submit = ()=>{}


    return (
        <form action ={submit}>
            customer-name: <input name="name" type = "text" placeholder="input customer name"/><br/>
            customer-name: <input name="email" type = "text" placeholder="input customer email"/><br/>
            customer-name: <input name="age" type = "number" placeholder="input customer age"/><br/>
            submit: <Button type="submit" color="primary" variant="contained" onClick={null}>submit</Button>
        </form>
    );
};

export default CreateUserForm;