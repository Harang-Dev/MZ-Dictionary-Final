import React from "react";
import { Link, useNavigate } from "react-router-dom";
import styled from "styled-components";
import { useQuery } from "@tanstack/react-query";
import { userDetail } from "../API/api";
import { message } from "antd";

const HeaderWrapper = styled.header`
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
  height: 64px;
  background-color: #000;
  color: #fff;
`;

const LogoBox = styled.div`
  background-image: url('/media/logo.png');
  background-size: 50px;
  background-repeat: no-repeat;
  background-position: center;
  width: 70px;
  height: 70px;

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
  const token = localStorage.getItem("token");
  const navigate = useNavigate();

  const userQuery = useQuery({
    queryKey: ["userDetail", token], // 쿼리 키
    queryFn: () => userDetail(token), // 데이터 패칭 함수
    enabled: !!token, // token이 있을 때만 실행
  });

  const handleLogout = () => {
    localStorage.removeItem("token");
    message.success("로그아웃 되었습니다.");
    navigate("/");
  };

  const handleMyWord = () => {
    if(!token) {
      message.error("로그인이 필요합니다 !");
      navigate("/login");
    }
    else if(token) {
      navigate("myword");
    }
  }

  return (
    <HeaderWrapper>
      <Link to="/">
        <LogoBox />
      </Link>
      <NavList>
        <Link to="/wordbook">
          <NavItem>WordBook</NavItem>
        </Link>
        {!token ? (
          <Link to="/login">
            <NavItem>Login</NavItem>
          </Link>
        ) : (
          <Link to="/">
            <NavItem onClick={handleLogout}>Logout</NavItem>
          </Link>
        )}
        {token && userQuery.data && (
          <NavItem>{userQuery.data.userId}</NavItem>
        )}
            <NavItem onClick={handleMyWord}>My Word</NavItem>
      </NavList>
    </HeaderWrapper>
  );
};

export default Header;