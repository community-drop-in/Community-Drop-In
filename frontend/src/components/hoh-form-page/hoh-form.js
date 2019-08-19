import React from 'react';

export default function HohForm ({ model, submitNewRecipient, goBackClick }) {

    return (
        <div className='form-wrapper'>
                <h1>New Recipient</h1><br />
            <form className='recipient-form' onSubmit={(e) => {
                e.preventDefault()
                submitNewRecipient(model)
            }}>
                First Name
            <input type="text" placeholder="FirstName" onChange={(e) => {
                    model.firstName = e.target.value
                }} /><br />
                Last Name
            <input type="text" placeholder="LastName" onChange={(e) => {
                    model.lastName = e.target.value
                }} /><br />
                Password
            <input type="password" placeholder="Password" onChange={(e) => {
                }} /><br />
                Confirm Password
            <input type="password" placeholder="Password" onChange={(e) => {
                }} /><br />
                Date Of Birth
            <input type="date" placeholder="DateOfBirth" onChange={(e) => {

                    model.dateOfBirth = e.target.value.replace("/", "-")
                }} /><br />
                Address
            <input type="text" placeholder="Address" onChange={(e) => {
                    model.address = e.target.value
                }} /><br />
                Phone Number
            <input type="tel" pattern="[0-9]{3}[0-9]{3}[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="PhoneNumber" onChange={(e) => {
                    model.phoneNumber = e.target.value.replace("-", "").replace("-", "")
                }} /><br />
                Household Size
            <input type="text" placeholder="HouseholdSize" onChange={(e) => {
                    model.houseSize = e.target.value
                }} /><br />
                Delivery             
            <select className='delivery-button' type="text" placeholder="Delivery" onChange={(e) => {
                    model.deliveryStatus = e.target.value
                }}>
                    <option value={false}>no</option>
                    <option value={true}>yes</option>
                </select>
                <br />
                <button className='give-food-button' type="submit" value="Submit">Submit</button><br />
            </form>

            <button onClick={()=>goBackClick('user')} className='create-user-button'>Go Back</button><br />
        </div>
    )
}
