import React, {Component} from 'react'
import RecipientRow from './RecipientRow'
import Api from '../Api/Api'

class Finder extends Component{

    constructor(){
        super()
        this.state = {
            recipients: [],
            sortQuery: ''
        }
    }

    getRecipients(){
        Api().getRequest(Api().getRootURL()+`recipients/${this.state.sortQuery}`, (recipients) => {
            this.setState({recipients})
            console.log(this.state.sortQuery)
        })
    }

    componentDidMount(){
        console.log('App - Mounted')
        this.getRecipients()
    }

    render(){
        console.log('App - Rendered')
        // const { id, lastName, phoneNumber, address, deliveryStatus, houseSize, firstName, dateOfBirth } = this.state.recipient;
        
        // this.getRecipients()
        console.log(this.state.recipients)
        return (
            <div className='finder'>
                <section className='recipient-results'>
                    <table className='results-table'>
                        <tbody>
                            <tr className='results-table__head'>
                                {/* <th className='head__id'>ID</th> */}
                                {/* <th className='head__lastname'><button onClick={this.setState({sortQuery: ''})}>Last Name</button></th>
                                <th className='head__phone'><button onClick={this.setState({sortQuery: 'sortby-phone-number'})}>Phone #</button></th> */}
                                <th className='head__lastname'><button onClick={
                                    (e) => {
                                        e.preventDefault()
                                        console.log(e)
                                        this.setState({sortQuery: ''})
                                        console.log(this.state.sortQuery)
                                        this.getRecipients()
                                        // this.getRecipients()
                                    }}>
                                        Last Name</button></th>
                                <th className='head__phone'><button onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-phone-number'})
                                        console.log(this.state.sortQuery)
                                        this.getRecipients()
                                    }}>
                                        Phone #</button></th>
                                <th className='head__address'><button onClick={(() => {this.setState({sortQuery: 'sortby-address'})})}>Address</button></th>
                                <th className='head__delivery-status'>Delivery</th>
                                <th className='head__household'>Household</th>
                                <th className='head__firstname'>First Name</th>
                                <th className='head__dob'>DOB</th>
                                <th className='head__eligible'>Eligable</th>
                            </tr>
                            {this.state.recipients.map((recipient)=>{
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