import React from "react";
import styled from "styled-components";
import { Typography, Space, message } from "antd";
import { LikeOutlined, CommentOutlined, PushpinOutlined } from "@ant-design/icons";
import { useQuery, useMutation } from "@tanstack/react-query";
import { allWordGuest, aboutWord, aboutWordGuest } from "../../API/api"; // aboutWord, aboutWordGuest 임포트
import { useNavigate } from "react-router-dom";

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
  align-items: center; /* 아이콘과 텍스트 수평 정렬 */
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

function WordCardBox() {
  const navigate = useNavigate(); // 네비게이션 훅
  const token = localStorage.getItem("token");

  const { data, isLoading, error } = useQuery({
    queryKey: ["allWordData"],
    queryFn: () => allWordGuest(),
  });

  // 리액트 쿼리 mutation 설정
  const mutation = useMutation({
    mutationFn: (wordId) => {
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
  const handleCardClick = (wordId) => {
    if (!wordId) {
      message.warning("유효한 검색어가 없습니다.");
      return;
    }
    // ID 전달하여 mutation 호출
    mutation.mutate(wordId);
  };

  if (isLoading) {
    return <OuterBox>Loading...</OuterBox>;
  }

  if (error) {
    return <OuterBox>Error: {error.message}</OuterBox>;
  }

  return (
    <CardGrid>
      {data.map((word, index) => (
        <OuterBox key={index} onClick={() => handleCardClick(word.id)}> {/* 클릭 시 handleCardClick 호출 */}
          {/* Header: Title and Date */}
          <Header>
            <Title level={3} style={{ color: "white", margin: 0 }}>
              {word.wordTitle || "Title"}
            </Title>
            <Title level={5} style={{ color: "white", margin: 0 }}>
              {word.date || ""}
            </Title>
          </Header>

          {/* Inner Box with Text Overflow Handling */}
          <InnerBox>
            <Text level={5}>
              {word.meaning}
            </Text>
          </InnerBox>

          {/* Icons for Likes, Comments, and Saves */}
          <IconWrapper>
            <IconText style={{ marginRight: "10px" }}>
              <LikeOutlined style={{ color: "#fff" }} />
              <span>{word.likeCount || 0}</span>
            </IconText>
            <IconText style={{ marginRight: "10px" }}>
              <CommentOutlined style={{ color: "#fff" }} />
              <span>{word.comments || 0}</span>
            </IconText>
            <IconText>
              <PushpinOutlined style={{ color: "#fff" }} />
              <span>{word.scrapCount || 0}</span>
            </IconText>
          </IconWrapper>
        </OuterBox>
      ))}
    </CardGrid>
  );
}

export default WordCardBox;
