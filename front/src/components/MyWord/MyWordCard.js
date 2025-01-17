import React from "react";
import styled from "styled-components";
import { Typography, Space } from "antd";
import { LikeOutlined, CommentOutlined, PushpinOutlined } from "@ant-design/icons";
import { useQuery } from "@tanstack/react-query";
import { myWordScrap } from "../../API/api";
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

function MyWordCard() {
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  const { data } = useQuery({
    queryKey: ["단어정보들"],
    queryFn: () => myWordScrap(token),
    enabled: !!token,
  });

  const handleClick = (word) => {
    navigate("/detail", { state:  word });
    console.log("전달한 값입니다.", word);
  };


  return (
    <CardGrid>
      {data?.map((word, index) => (
       <OuterBox key={index} onClick={() => handleClick(word)}>
          {/* Header: Title and Date */}
          <Header>
            <Title level={3} style={{ color: "white", margin: 0 }}>
              {word.wordTitle || "Title"}
            </Title>
            <Title level={5} style={{ color: "white", margin: 0 }}>
              {word.createTime || "Date"}
            </Title>
          </Header>

          {/* Inner Box with Text Overflow Handling */}
          <InnerBox>
            <Text level={5}>{word.meaning || "Meaning"}</Text>
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

export default MyWordCard;

