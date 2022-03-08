import React from 'react';
import Button from '@material-ui/core/button';

const CreateAccount = () => {

    const submit = async ()=>{}

    return (
        <form action={submit}>
            customerId: <input type="text" name="id" placeholder="input customerId"/><br/>
            currency: <input type="number" name="currency" placeholder="input currency number"/><br/>
            amount: <input type = "number" name="balance" placeholder="input balance amount" /><br/>
            submit: <Button type="submit" color="primary" variant="contained" onClick={null}>submit</Button>
        </form>
    );
};

export default CreateAccount;