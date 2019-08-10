import React from 'react'
import HohTableRow from './hoh-table-row'


const AllHohTable = ({ recipients }) => (
    <table className='results-table'>
        <tbody className='results-table__body'>
            <tr className='results-table__head'>
                <th className='head__firstname'>First Name</th>
                <th className='head__lastname'>Last Name</th>
                <th className='head__dob'>DOB</th>
                <th className='head__phone'>Phone #</th>
                <th className='head__address'>Address</th>
                <th className='head__household'>Household</th>
                <th className='head__delivery'>Delivery</th>
                <th className='head__eligible'>Eligible</th>
            </tr>
            {recipients.map(recipient => <HohTableRow recipient={recipient}/>)}
            

        </tbody>
    </table>

);




export default AllHohTable