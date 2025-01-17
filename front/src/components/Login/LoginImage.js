import React from "react";
import styled from "styled-components";

const ImageBox = styled.div`
    width: 836px;
    height: 780px;
    background-image: url('/media/2.png');
    background-repeat: no-repeat;
    background-size: contain;
    background-position: center;
    opacity: 0.4;
`;

function LoginImage () {
    return(
        <ImageBox />
    );
}

export default LoginImage