import React, { useState } from "react";
import { Card, Flex, Typography, Input, Button, Select } from "antd";

const cardStyle = {
  maxWidth: 1034,
  width: "100%",
  margin: "0 auto",
  padding: 16,
  backgroundColor: "black",
  border: "none",
};

const inputStyle = {
  backgroundColor: "#333",
  color: "#fff",
  border: "1px solid #555",
  borderRadius: "4px",
  padding: "8px",
};

const CommentBox = () => {
  const [comments, setComments] = useState([]);
  const [newComment, setNewComment] = useState("");
  const [sortOption, setSortOption] = useState("latest"); // 정렬 옵션

  const handleAddComment = () => {
    if (newComment.trim()) {
      const newCommentData = {
        text: newComment,
        likeCount: 0, // 좋아요 초기값
        createdAt: new Date(), // 생성 시간
      };
      setComments([newCommentData, ...comments]);
      setNewComment("");
    }
  };

  const handleLike = (index) => {
    const updatedComments = [...comments];
    updatedComments[index].likeCount += 1; // 좋아요 수 증가
    setComments(updatedComments);
  };

  const handleSortChange = (value) => {
    setSortOption(value);
  };

  const sortedComments = comments.sort((a, b) => {
    if (sortOption === "latest") {
      return b.createdAt - a.createdAt; // 최신순 정렬
    } else if (sortOption === "likes") {
      return b.likeCount - a.likeCount; // 좋아요 순 정렬
    }
    return 0;
  });

  return (
    <Card style={cardStyle}>
      {/* 댓글 입력 및 정렬 옵션 */}
      <Typography.Title level={4} style={{ color: "#fff", marginBottom: "16px" }}>
        댓글 입력
      </Typography.Title>
      <Flex justify="space-between" align="center" style={{ marginBottom: "16px" }}>
        <Input
          style={inputStyle}
          value={newComment}
          placeholder="주제와 무관한 댓글은 삭제될 수 있습니다."
          onChange={(e) => setNewComment(e.target.value)}
        />
        <Button type="primary" style={{ marginLeft: "8px" }} onClick={handleAddComment}>
          등록
        </Button>
      </Flex>
      <Flex justify="end" style={{ marginBottom: "16px" }}>
        <Select
          value={sortOption}
          onChange={handleSortChange}
          style={{ width: 120 }}
          options={[
            { value: "latest", label: "최신순" },
            { value: "likes", label: "좋아요 순" },
          ]}
        />
      </Flex>
      <div>
        {sortedComments.map((comment, index) => (
          <Card
            key={index}
            style={{
              backgroundColor: "#222",
              border: "none",
              marginBottom: "8px",
              padding: "8px",
            }}
          >
            <Typography.Text style={{ color: "#fff" }}>{comment.text}</Typography.Text>
            <Flex justify="space-between" align="center" style={{ marginTop: "8px" }}>
              <Typography.Text style={{ color: "#aaa" }}>
                좋아요: {comment.likeCount}
              </Typography.Text>
              <Button
                type="link"
                style={{ color: "#4096ff", padding: 0 }}
                onClick={() => handleLike(index)}
              >
                좋아요
              </Button>
            </Flex>
          </Card>
        ))}
      </div>
    </Card>
  );
};

export default CommentBox;
