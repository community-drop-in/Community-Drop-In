import React, {useEffect, useState} from 'react'
import AllHohTable from '../components/all-hoh-table'


const Api = () => {
	const [recipients, setRecipients] = useState([])
	useEffect(() =>{
		fetch(getRootURL() + 'recipients')
			.then(response => response.json())
			.then(recipients => setRecipients(recipients))
	}, [])
	{console.log(recipients)}
	if(recipients !==undefined){
		return(
			<AllHohTable recipients={recipients}/>
			// <h1>{getRecipients()}</h1>
		)
	}
}


function getRootURL() {
	return 'http://localhost:8080/api/';
}


export default Api