import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

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
  display: flex;
  align-items: center;
  margin: 0 16px;
  color: #fff;
  cursor: pointer;
  font-size: 1rem;
  transition: color 0.3s;

  &:hover {
    color: #4096ff;
  }

  &::after {
    content: "|";
    color: #fff;
    margin-left: 40px;
  }

  &:last-child::after {
    content: "";
  }
`;


const Header = () => {
  return (
    <HeaderWrapper>
      <Link to="/">
        <Logo>MyLogo</Logo>
      </Link>
      <NavList>
        <NavItem>WordBook</NavItem>
        <Link to="/login">
          <NavItem>Login</NavItem>
        </Link>
      </NavList>
    </HeaderWrapper>
  );
};

export default Header;
