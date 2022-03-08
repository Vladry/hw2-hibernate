import React from 'react';
import Button from "@material-ui/core/button";

const CreateCustomer = () => {

    const submit = async (data) => {
        const {name, email, age} = data;
        const url = "/customer";

        const create = await fetch(url, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(
                {
                    name: name,
                    email: email,
                    age: age
                }
            )
        });
        const result = await create.then(r => r.json().then(r => console.log(r)))
        console.log(`name: ${name}, email: ${email}, age: ${age}`);

        result();
    }


    return (
        <form /*action={submit} method="POST"*/>
            customer-name: <input name="name" type="text" placeholder="input customer name"/><br/>
            customer-name: <input name="email" type="text" placeholder="input customer email"/><br/>
            customer-name: <input name="age" type="number" placeholder="input customer age"/><br/>
            submit: <Button type="button" color="primary" variant="contained" onClick={submit}>submit</Button>
        </form>
    );
};

export default CreateCustomer;