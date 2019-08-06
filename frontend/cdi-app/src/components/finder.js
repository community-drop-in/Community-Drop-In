import React, {Component} from 'react'
import RecipientRow from './RecipientRow'

class Finder extends Component{

    render(){
        // const { id, lastName, phoneNumber, address, deliveryStatus, houseSize, firstName, dateOfBirth } = this.props.recipient;
        console.log(this.props.recipients)
        return (
            <div className='finder'>
                <section className='recipient-results'>
                    <table className='results-table'>
                        <tbody>
                            <tr className='results-table__head'>
                                <th className='head__id'>ID</th>
                                <th className='head__lastname'>Last Name</th>
                                <th className='head__phone'>Phone #</th>
                                <th className='head__address'>Address</th>
                                <th className='head__delivery-status'>Delivery</th>
                                <th className='head__household'>Household</th>
                                <th className='head__firstname'>First Name</th>
                                <th className='head__dob'>DOB</th>
                                <th className='head__eligible'>Eligable</th>
                            </tr>
                            {this.props.recipients.map((recipient)=>{
                                return <RecipientRow recipient={recipient} />
                            })}
                            {/* <RecipientRow ></RecipientRow> */}
                            {/* <tr>
                                <th className='body__id'>{id}</th>
                                <th className='body__lastname'>{lastName}</th>
                                <th className='body__phone'>{phoneNumber}</th>
                                <th className='body__address'>{address}</th>
                                <th className='body__delivery-status'>{deliveryStatus.toString()}</th>
                                <th className='body__household'>{houseSize}</th>
                                <th className='body__firstname'>{firstName}</th>
                                <th className='body__dob'>{dateOfBirth}</th>
                                <th className='body__eligible'></th>
                            </tr> */}
                        </tbody>
                    </table>
                </section>
            </div>
        )
    }
}



export default Finder;