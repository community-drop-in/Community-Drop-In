import React from 'react'

function DeliveryStatusText (deliveryStatus) {
    if (deliveryStatus == true) {
        return 'Yes';
    }
    return 'No';
 };

const HohTableRow = ({ recipient }) => (
    <tr className='single-recipient-table__row'>
        <th className='recipient-first-name'>{recipient.firstName}</th>
        <th className='recipient-last-name'>{recipient.lastName}</th>
        <th className='recipient-dob'>{recipient.dateOfBirth}</th>
        <th className='recipient-phone-number'>
        {'(' + recipient.phoneNumber.toString().slice(0,3) + ') ' +
            recipient.phoneNumber.toString().slice(3,6) + '-' +
            recipient.phoneNumber.toString().slice(6,10)}
        </th>
        <th className='recipient-address'>{recipient.address}</th>
        <th className='recipient-household'>{recipient.houseSize}</th>
        <th className='recipient-delivery'>{DeliveryStatusText(recipient.deliveryStatus)}</th>
        <th className='recipient-eligible'></th>

    </tr>

)






export default HohTableRow;