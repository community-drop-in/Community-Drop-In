import React, {Component} from 'react'
import RecipientRow from './RecipientRow'
import SingleRecipientPageContent from'./hoh-info-page'
// import FinderTable from './FinderTable'
import Api from '../Api/Api'

class Finder extends Component{

    constructor(props){
        super(props)
        this.state = {
            sortQuery: '',
            sortedRecipients: []
        };
    }

    getSortedRecipients = () => {
        
    }

    componentDidMount(){
        console.log('App - Mounted')
        // console.log(this.state.recipients)
         this.getSortedRecipients()
    }

    render(){
        // console.log('App - Rendered')
        // const { id, lastName, phoneNumber, address, deliveryStatus, houseSize, firstName, dateOfBirth } = this.state.recipient;
        
        // console.log(this.state.recipients)
        // this.getRecipients()
        // console.log(this.state.recipients)
        return (
            <div className='finder'>
                <section className='recipient-results'>
                    <table className='results-table'>
                        <tbody>
                            <tr className='results-table__head'>
                                <th className='head__lastname' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: ''})

                                        //  this.getRecipients()
                                    }}>
                                        Last Name</th>
                                <th className='head__phone' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-phone-number'})
                                        
                                        //  this.getRecipients()
                                    }}>
                                        Phone #</th>
                                <th className='head__address' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-address'})

                                        //  this.getRecipients()
                                    }}>
                                        Address</th>
                                <th className='head__delivery-status' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-delivery-status'})
                                        
                                        //  this.getRecipients()
                                    }}>
                                        Delivery</th>
                                <th className='head__household-size' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-house-size'})
                                        
                                        //  this.getRecipients()
                                    }}>
                                        Household</th>
                                <th className='head__firstname' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-first-name'})
                                        
                                        //  this.getRecipients()
                                    }}>
                                        First Name</th>
                                <th className='head__dob' onClick={
                                    (e) => {
                                        e.preventDefault()
                                        this.setState({sortQuery: 'sortby-date-of-birth'})
                                        
                                        //  this.getRecipients()
                                    }}>
                                        Date of Birth</th>         
                                <th className='head__eligible'>Eligable</th>
                            </tr>
                            {/* {console.log(this.props.recipients)} */}
                            {this.props.recipients.map((recipient)=>{
                                return <RecipientRow recipient={recipient} />
                            })}
                        </tbody>
                    </table>
                </section>
            </div>
        )
    }
}



export default Finder;