import React from "react";
import styled from "styled-components";
import { Typography, Space, message } from "antd";
import { LikeOutlined, CommentOutlined, PushpinOutlined } from "@ant-design/icons";
import { useLocation, useNavigate } from "react-router-dom";
import { useMutation } from "@tanstack/react-query";
import { aboutWord,aboutWordGuest } from "../../API/api";

const { Title } = Typography;

// Styled Components
const OuterBox = styled.div`
  width: 382px;
  height: 158px;
  background-color: #262627;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 16px;
  cursor: pointer;
`;

const InnerBox = styled.div`
  width: 347px;
  height: 66px;
  background-color: #28282a;
  border: 2px solid #3e3e40;
  border-radius: 10px;
  padding: 10px;
`;

const Header = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
`;

const IconText = styled(Space)`
  color: #fff;
  font-size: 14px;
  display: flex;
  align-items: center;
`;

const IconWrapper = styled.div`
  display: flex;
  justify-content: flex-start;
  width: 100%;
  margin-top: 10px;
`;

const CardGrid = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  gap: 20px;
  margin-bottom: 10%;
`;


const Text = styled(Title)`
  color: white !important;
  margin: 0;
  text-align: left;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
`;

function SearchCard() {
  const location = useLocation();
  const navigate = useNavigate();
  const token = localStorage.getItem("token");
  const searchData = location.state || [];

  // 리액트 쿼리 mutation 설정
  const mutation = useMutation({
    mutationFn: (wordId) => {
      // token이 있을 경우 aboutWord 호출, 없으면 aboutWordGuest 호출
      return token ? aboutWord(token, wordId) : aboutWordGuest(wordId);
    },
    onSuccess: (data) => {
      // 데이터 성공적으로 받아오면 detail 페이지로 이동
      navigate("/detail", { state: data });
    },
    onError: (error) => {
      // 에러 발생 시 메시지 출력
      console.error("API 호출 실패:", error);
      message.error("데이터를 가져오는 데 실패했습니다.");
    },
  });

  // 카드 클릭 핸들러
  const handleCardClick = (id) => {
    if (!id) {
      message.warning("유효한 검색어가 없습니다.");
      return;
    }
    // ID 전달하여 mutation 호출
    mutation.mutate(id);
  };

  return (
    <CardGrid>
      {searchData.length > 0 ? (
        searchData.map((word, index) => (
          <OuterBox
            key={index}
            onClick={() => handleCardClick(word.id)} // 클릭 시 id를 전달
          >
            <Header>
              <Title level={3} style={{ color: "white", margin: 0 }}>
                {word.wordTitle || "Title"}
              </Title>
              <Title level={5} style={{ color: "white", margin: 0 }}>
                {word.updateTime || ''}
              </Title>
            </Header>

            <InnerBox>
              <Text level={5}>{word.meaning || "내용 없음"}</Text>
            </InnerBox>

            <IconWrapper>
              <IconText style={{ marginRight: "10px" }}>
                <LikeOutlined style={{ color: "#fff" }} />
                <span>{word.likeCount || 0}</span>
              </IconText>
              <IconText style={{ marginRight: "10px" }}>
                <CommentOutlined style={{ color: "#fff" }} />
                <span>{word.commentCount || 0}</span>
              </IconText>
              <IconText>
                <PushpinOutlined style={{ color: "#fff" }} />
                <span>{word.scrapCount || 0}</span>
              </IconText>
            </IconWrapper>
          </OuterBox>
        ))
      ) : (
        <div style={{ color: "white", textAlign: "center", marginTop: "20px" }}>
          검색 결과가 없습니다.
        </div>
      )}
    </CardGrid>
  );
}

export default SearchCard;
