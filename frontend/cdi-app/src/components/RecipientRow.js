import React, {Component} from 'react'

class RecipientRow extends Component{
    
    render(){
        const { id, lastName, phoneNumber, address, deliveryStatus, houseSize, firstName, dateOfBirth } = this.props.recipient;
        return (
            <tr>
                {/* <th className='body__id'>{id}</th> */}
                <th className='body__lastname'>{lastName}</th>
                <th className='body__phone'>{phoneNumber}</th>
                <th className='body__address'>{address}</th>
                <th className='body__delivery-status'>{deliveryStatus.toString()}</th>
                <th className='body__household'>{houseSize}</th>
                <th className='body__firstname'>{firstName}</th>
                <th className='body__dob'>{dateOfBirth}</th>
                <th className='body__eligible'></th>
            </tr>
        );
    }
}

export default RecipientRow;