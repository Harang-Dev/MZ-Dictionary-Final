import React from "react";
import styled from "styled-components";
import { Typography, Space, message } from "antd";
import { LikeOutlined, CommentOutlined, PushpinOutlined } from "@ant-design/icons";
import { useQuery, useMutation } from "@tanstack/react-query";
import { allWord, aboutWordGuest } from "../../API/api";
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
`;

const TitleText = styled(Title)`
  color: white !important;
  text-align: center;
  margin-bottom: 20px;
`;

const Text = styled(Title)`
  color: white !important;
  margin: 0;
  text-align: left;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
`;

function RandomCard() {
  const token = localStorage.getItem("token");
  const navigate = useNavigate();

  const { data, isLoading, error } = useQuery({
    queryKey: ["allWordData"],
    queryFn: () => allWord(token),
    enabled: !!token,
  });

  // useMutation 훅을 추가하여 카드 클릭 시 API 호출
  const mutation = useMutation({
    mutationFn: (wordId) => aboutWordGuest(wordId), // wordId를 API 함수로 전달
    onSuccess: (data) => {
      navigate("/detail", { state: data });
    },
    onError: (error) => {
      console.error("API 호출 실패:", error);
      message.error("데이터를 가져오는 데 실패했습니다.");
    },
  });

  if (isLoading) {
    return <OuterBox>Loading...</OuterBox>;
  }

  if (error) {
    return <OuterBox>Error: {error.message}</OuterBox>;
  }

  // 랜덤하게 6개 데이터 뽑기
  const randomData = data
    .sort(() => Math.random() - 0.5) // 데이터를 무작위로 섞기
    .slice(0, 6); // 상위 6개 데이터만 추출

  // 카드 클릭 핸들러
  const handleCardClick = (id) => {
    if (!id) {
      message.warning("유효한 검색어가 없습니다.");
      return;
    }
    mutation.mutate(id); // mutation을 사용하여 API 호출
  };

  return (
    <>
      {/* 타이틀 추가 */}
      <TitleText level={2}>MZ 사전의 다른 단어들</TitleText>
      <CardGrid>
        {randomData.map((word, index) => (
          <OuterBox
            key={index}
            onClick={() => handleCardClick(word.id)} // 클릭 시 id를 전달
          >
            {/* Header: Title and Date */}
            <Header>
              <Title level={3} style={{ color: "white", margin: 0 }}>
                {word.wordTitle || "Title"}
              </Title>
              <Title level={5} style={{ color: "white", margin: 0 }}>
                {word.date || ''}
              </Title>
            </Header>

            {/* Inner Box with Text Overflow Handling */}
            <InnerBox>
              <Text level={5}>{word.meaning}</Text>
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
    </>
  );
}

export default RandomCard;
