import React from 'react';

const InfoSize = ({houseSize}) => (
    <section className='info-section size'>
    <div className='info-section__content-div'>
        <h3 className='info-section__content-div__title size-title'>Household Size:</h3>
        <h4 className='info-section__content-div__content size-value'>{houseSize}</h4>
    </div>
    <button className='info-section__modify-button size-modify-button'>Change Household Size</button>
</section>
);

export default InfoSize;