import React from 'react';



export default function HohForm({ model, submitNewRecipient }) {

    return (
        <div className='wrapper'>
            <header className='main-header'>
                <h1>New Recipient</h1>
            </header><br />
            <form className='recipient-form' onSubmit={(e) => {
                e.preventDefault()
                submitNewRecipient(model)
            }}>
                First Name:
            <input type="text" placeholder="FirstName" onChange={(e) => {
                    model.firstName = e.target.value
                }} /><br />
                Last Name:
            <input type="text" placeholder="LastName" onChange={(e) => {
                    model.lastName = e.target.value
                }} /><br />
                Date Of Birth:
            <input type="text" placeholder="DateOfBirth" onChange={(e) => {
                    model.dateOfBirth = e.target.value
                }} /><br />
                Address:
            <input type="text" placeholder="Address" onChange={(e) => {
                    model.address = e.target.value
                }} /><br />
                Phone Number:
            <input type="text" placeholder="PhoneNumber" onChange={(e) => {
                    model.phoneNumber = e.target.value
                }} /><br />
                Household Size:
            <input type="text" placeholder="HouseholdSize" onChange={(e) => {
                    model.houseSize = e.target.value
                }} /><br />
                <button className='give-food-button' type="submit" value="Submit">Submit</button><br />

            </form>
        </div>
    )
}
