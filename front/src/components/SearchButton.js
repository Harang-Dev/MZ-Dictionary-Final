import React, { useState } from "react";
import styled from "styled-components";
import { SearchOutlined } from "@ant-design/icons";
import { useMutation } from "@tanstack/react-query";
import { searchWord } from "../API/api";
import { message } from "antd";
import { useNavigate } from "react-router-dom";

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
  
  const navigate = useNavigate();

  const [searchText, setSearchText] = useState("");
  const [isClicked, setIsClicked] = useState(false);
  const token = localStorage.getItem("token");

  const { mutate, isLoading } = useMutation({
    mutationFn: (keyWord) => searchWord(keyWord, token), // 수정된 함수명
    onSuccess: (data) => {
      console.log("검색 결과:", data);
      navigate('/detail', { state: data });

    },
    onError: (error) => {
      const errorMessage = error.message || "검색 실패! 예상치 못한 에러가 발생했습니다.";
      message.error(errorMessage);
    },
  });

  const handleSearchRequest = () => {
    if (!token) {
      message.warning("로그인이 필요합니다!");
      return;
    }

    if (!searchText.trim()) {
      message.warning("검색어를 입력하세요!");
      return;
    }

    console.log("토큰값 :", token);

    mutate(searchText.trim()); // 검색 요청 수행
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      handleSearchRequest();
    }
  };

  const handleClick = () => {
    setIsClicked(true);
  };

  const handleChange = (e) => {
    setSearchText(e.target.value);
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
              onKeyPress={handleKeyPress}
              autoFocus
            />
            <SearchIconWrapper onClick={handleSearchRequest}>
              <SearchOutlined style={{ fontSize: "20px" }} />
            </SearchIconWrapper>
          </>
        )}
      </SearchButton>
    </ButtonWrapper>
  );
}

export default SearchButtonComponent;