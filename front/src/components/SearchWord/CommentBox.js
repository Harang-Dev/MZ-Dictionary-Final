import React, { useState } from "react";
import { Card, Input, Button, Typography } from "antd";
import { LikeOutlined } from "@ant-design/icons";
import { useLocation } from 'react-router-dom';
import styled from "styled-components";
import { useMutation } from '@tanstack/react-query';
import { addComment } from "../../API/api";

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

const ButtonWrapper = styled.div`
  display: flex;
  justify-content: flex-end;
  margin-top: 16px;
`;

const LikeButtonWrapper = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  margin-top: 8px;
`;

const CommentBox = () => {
  const location = useLocation();
  const { comments, id } = location.state;

  const [newComment, setNewComment] = useState("");

  const { mutate: addNewComment, isLoading } = useMutation({
    mutationFn: async (commentText) => {
      const token = localStorage.getItem("token");
      if (!token) {
        throw new Error("No authentication token found");
      }

      const wordId = id;

      console.log("Token:", token);
      console.log("Comment Text:", commentText);
      console.log("Word ID:", wordId);

      return addComment(token, commentText, wordId);
    },
    onSuccess: (data) => {
      setNewComment("");
    },
    onError: (error) => {
      console.error("Error adding comment:", error);
      console.log(token, commentText, wordId);
    }
  });

  const handleAddComment = () => {
    if (newComment.trim()) {
      addNewComment(newComment);
    }
  };

  return (
    <Card style={cardStyle}>
      <Typography.Title level={4} style={{ color: "#fff", marginBottom: "16px" }}>
        댓글 입력
      </Typography.Title>
      <Input
        style={inputStyle}
        value={newComment}
        onChange={(e) => setNewComment(e.target.value)}
        placeholder="댓글을 입력하세요"
      />
      <ButtonWrapper>
        <Button
          type="primary"
          onClick={handleAddComment}
          loading={isLoading}
        >
          등록
        </Button>
      </ButtonWrapper>

      <div style={{ marginTop: "16px" }}>
        {comments.map((comment, index) => (
          <Card
            key={index}
            style={{ backgroundColor: "#222", border: "none", marginBottom: "8px", padding: "8px" }}
          >
            <Typography.Text style={{ color: "#fff" }}>
              {comment.commentText}
            </Typography.Text>
            <LikeButtonWrapper>
              <Button
                type="text"
                icon={<LikeOutlined style={{ color: "#4096ff" }} />}
                style={{ padding: 0 }}
              />
              <Typography.Text style={{ color: "#aaa", marginLeft: "8px" }}>
                {comment.commentLikeCount}
              </Typography.Text>
            </LikeButtonWrapper>
          </Card>
        ))}
      </div>
    </Card>
  );
};

export default CommentBox;
