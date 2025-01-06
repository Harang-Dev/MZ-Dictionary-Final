import React from "react";
import styled from "styled-components";

// Styled-components로 스타일 정의
const HeaderWrapper = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
  height: 64px;
  background-color: #000;
  color: #fff;
`;

const Logo = styled.div`
  font-size: 1.5rem;
  font-weight: bold;
  color: #fff;
`;

const NavList = styled.ul`
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
`;

const NavItem = styled.li`
  display: flex; /* 플렉스 박스 사용 */
  align-items: center; /* 세로 가운데 정렬 */
  margin: 0 16px;
  color: #fff;
  cursor: pointer;
  font-size: 1rem;
  transition: color 0.3s;

  &:hover {
    color: #4096ff;
  }

  /* 가상 요소로 구분선 추가 */
  &::after {
    content: "|";
    color: #fff;
    margin-left: 40px;
  }

  /* 마지막 항목은 구분선 제거 */
  &:last-child::after {
    content: "";
  }
`;

// 컴포넌트 정의
const Header = () => {
  return (
    <HeaderWrapper>
      <Logo>MyLogo</Logo>

      {/* 메뉴 */}
      <NavList>
        <NavItem>WordBook</NavItem>
        <NavItem>Login</NavItem>
      </NavList>
    </HeaderWrapper>
  );
};

export default Header;
