import React, { useState } from "react";
import styled from "styled-components";
import { SearchOutlined } from "@ant-design/icons";

const ButtonWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
`;

const SearchButton = styled.button`
  width: ${({ isClicked }) => (isClicked ? "800px" : "200px")};
  height: 50px;
  background-color: #fff;
  color: #000;
  border: 2px solid #ddd;
  border-radius: 25px;
  font-size: 1rem;
  font-weight: normal;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: ${({ isClicked }) => (isClicked ? "space-between" : "center")};
  padding: 0;
  overflow: hidden;
  transition: width 0.3s ease, background-color 0.3s ease;

  &:hover {
    background-color: ${({ isClicked }) => (isClicked ? "#f9f9f9" : "#ddd")};
  }
`;

const Input = styled.input`
  flex: 1;
  height: 100%;
  border: none;
  border-radius: 25px 0 0 25px;
  padding: 0 20px;
  font-size: 1rem;
  font-family: "Amethysta", serif;
  outline: none;
  display: ${({ isClicked }) => (isClicked ? "block" : "none")};

  &::placeholder {
    color: #aaa;
  }
`;

const SearchIconWrapper = styled.div`
  width: 10%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #fff;
  color: #aaa;
  border-radius: 0 25px 25px 0;
  cursor: pointer;

  &:hover {
    background-color: #000;
  }
`;

function SearchButtonComponent() {
  const [isClicked, setIsClicked] = useState(false);
  const [searchText, setSearchText] = useState("");

  const handleClick = () => {
    setIsClicked(true);
  };

  const handleChange = (e) => {
    setSearchText(e.target.value);
  };

  const handleSearch = () => {
    alert(`검색: ${searchText}`);
  };

  return (
    <ButtonWrapper>
      <SearchButton
        isClicked={isClicked}
        onMouseOver={!isClicked ? handleClick : undefined}
      >
        {!isClicked ? (
          "시작하기"
        ) : (
          <>
            <Input
              type="text"
              isClicked={isClicked}
              value={searchText}
              onChange={handleChange}
              placeholder="검색어를 입력하세요"
              autoFocus
            />
            <SearchIconWrapper onClick={handleSearch}>
              <SearchOutlined style={{ fontSize: "20px" }} />
            </SearchIconWrapper>
          </>
        )}
      </SearchButton>
    </ButtonWrapper>
  );
}

export default SearchButtonComponent;
