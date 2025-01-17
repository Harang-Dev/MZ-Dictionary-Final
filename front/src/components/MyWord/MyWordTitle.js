import React from "react";
import styled from "styled-components";

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
  margin-bottom: 10%;
`;

const SubTitle = styled.h2`
  font-size: 1.5rem;
  font-weight: normal;
`;

const MainTitle = styled.h1`
  font-size: 8.5rem;
  font-weight: bold;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0;
  margin-bottom: 100px;
`;

const Line = styled.span`
  display: block;
  margin-top: 10px;
`;


function MyWordTitle() {
  return (
    <MainWrapper>
      <SubTitle>MZ세대의 언어로 가득 찬 힙한 단어사전</SubTitle>
      <MainTitle>
        <Line>My Word</Line>
        <Line style={{ fontSize: '1rem'}}>위 내용에 대한 저작권 및 법적 책임은 자료 제공사 또는 글쓴이에게 있으며 Team의 입장과 다를 수 있습니다.</Line>
      </MainTitle>
    </MainWrapper>
  );
}

export default MyWordTitle;