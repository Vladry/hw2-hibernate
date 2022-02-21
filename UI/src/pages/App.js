import './App.css';
import React, {useState} from 'react';
import Button from "@material-ui/core/Button";
import AllCustomers from "../components/AllCustomers";

function App() {

    const getCustomers = async () => {
        const allCustomersUrl = '/customers/all';

        try {
            await fetch(allCustomersUrl, {
                method: 'GET',
                headers: {'Content-Type': 'application/json'}
            }).then(r => r.json()).then(result => setCustomersArr(result));
        } catch {
            console.warn('error loading customers')
        }
    }


    const [customersArr, setCustomersArr] = useState([]);

    return (
        <div className="App">
            <header className="App-header">
                <p>
                    All Customer List:
                </p>
                <div>
                    <AllCustomers customers={customersArr}/>
                </div>
            </header>
            <div>

                <Button type="button" className=""
                        color='primary'
                        variant='contained'
                        onClick={getCustomers}>
                    get customers
                </Button>
            </div>
        </div>
    );

}

export default App;
