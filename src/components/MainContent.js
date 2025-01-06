import React from "react";
import styled from "styled-components";
import SearchButton from "./SearchButton";

const MainWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  flex: 1;
  color: #fff;
  background-color: #000;
  font-family: 'Amethysta', serif;
`;

const SubTitle = styled.h2`
  font-size: 1.5rem;
  font-weight: normal;
`;

const MainTitle = styled.h1`
  font-size: 4.5rem;
  font-weight: bold;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0;
`;

const Line = styled.span`
  display: block;
`;


function MainContent() {
  return (
    <MainWrapper>
      <SubTitle>MZ세대의 언어로 가득 찬 힙한 단어사전</SubTitle>
      <MainTitle>
        <Line>MZ Generation</Line>
        <Line>Word Dictionary</Line>
      </MainTitle>
      <SearchButton />
    </MainWrapper>
  );
}

export default MainContent;
