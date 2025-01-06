import React from "react";
import styled from "styled-components";

const ImageBox = styled.div`
    width: 726px;
    height: 726px;
    background-image: url('/media/sample.png');
    background-repeat: no-repeat;
    background-size: contain;
    margin-right: 100px;
    background-position: center;
`;

function LoginImage () {
    return(
        <ImageBox />
    );
}

export default LoginImage