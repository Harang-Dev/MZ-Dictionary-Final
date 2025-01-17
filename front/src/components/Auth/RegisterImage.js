import React from "react";
import styled from "styled-components";

const ImageBox = styled.div`
    width: 836px;
    height: 780px;
    background-image: url('/media/3.png');
    background-repeat: no-repeat;
    background-size: contain;
    background-position: center;
    opacity: 0.3;
`;

function RegisterImage () {
    return(
        <ImageBox />
    );
}

export default RegisterImage