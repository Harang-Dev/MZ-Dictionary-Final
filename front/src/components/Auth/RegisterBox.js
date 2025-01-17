import React from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { useMutation } from "@tanstack/react-query";
import { Form, Input, Button, message } from "antd";
import { signUp } from "../../API/api";

const FormContainer = styled.div`
  width: 726px;
  height: 726px;
  background-color: #000;
  padding: 30px 150px;
  border-radius: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
`;

const TitleWrapper = styled.div`
  margin-top: 20px;
  margin-bottom: 30px;
  text-align: center;
`;

const Title = styled.h1`
  font-size: 48px;
  font-weight: bold;
  color: #fff;
  margin: 0;
`;

const Subtitle = styled.p`
  font-size: 16px;
  color: #fff;
  margin: 5px 0 0 0;
`;

const Line = styled.hr`
  width: 80%;
  border: none;
  border-top: 2px solid #ccc;
`;

const StyledForm = styled(Form)`
  width: 100%;
  margin-top: 10%;
`;

const StyledInput = styled(Input)`
  background-color: #d9d9d9 !important;
  border: 1px solid #ccc;
  &:hover,
  &:focus {
    border-color: #4096ff;
    box-shadow: 0 0 0 2px rgba(64, 150, 255, 0.2);
  }
`;

const StyledPasswordInput = styled(Input.Password)`
  background-color: #d9d9d9 !important;
  border: 1px solid #ccc;
  &:hover,
  &:focus {
    border-color: #4096ff;
    box-shadow: 0 0 0 2px rgba(64, 150, 255, 0.2);
  }
`;

const StyledButton = styled(Button)`
  width: 100%;
  background-color: #d9d9d9 !important;
  color: white;
  font-weight: bold;
  height: 40px;

  &:hover {
    background-color: #000 !important;
    color: white !important;
  }
`;

function RegisterBox() {
  const navigate = useNavigate();

  const { mutate } = useMutation({
    mutationFn: signUp,
    onSuccess: () => {
      message.success("회원가입 성공!");
      navigate('/login');
    },
    onError: (error) => {
      const errorMessage =
        error.response?.data?.message || "회원가입 실패! 예상치 못한 에러입니다.";
      message.error(errorMessage);
    },
  });

  const handleSubmit = (values) => {
    const { confirmPassword, ...filteredValues } = values;
    mutate(filteredValues);
    console.log(filteredValues);
  };

  return (
    <FormContainer>
      <TitleWrapper>
        <Subtitle>MZ세대의 언어로 가득 찬 힙한 언어사전</Subtitle>
        <Title>회원가입</Title>
      </TitleWrapper>
      <Line />
      <StyledForm
        name="registerForm"
        initialValues={{ remember: true }}
        onFinish={handleSubmit}
      >
        <Form.Item
          name="userId"
          rules={[{ required: true, message: "아이디를 입력하세요." }]}
        >
          <StyledInput placeholder="ID" size="large" />
        </Form.Item>

        <Form.Item
          name="password"
          rules={[{ required: true, message: "비밀번호를 입력하세요." }]}
        >
          <StyledPasswordInput placeholder="Password" size="large" />
        </Form.Item>

        <Form.Item
          name="confirmPassword"
          dependencies={["password"]}
          rules={[
            { required: true, message: "비밀번호를 확인하세요." },
            ({ getFieldValue }) => ({
              validator(_, value) {
                if (!value || getFieldValue("passWord") === value) {
                  return Promise.resolve();
                }
                return Promise.reject(new Error("비밀번호가 일치하지 않습니다."));
              },
            }),
          ]}
        >
          <StyledPasswordInput placeholder="Confirm Password" size="large" />
        </Form.Item>

        <Form.Item
          name="userEmail"
          rules={[
            { required: true, message: "이메일을 입력하세요." },
            { type: "email", message: "유효한 이메일을 입력하세요." },
          ]}
        >
          <StyledInput placeholder="Email" size="large" />
        </Form.Item>

        <Form.Item
          name="nickname"
          rules={[{ required: true, message: "닉네임을 입력하세요." }]}
        >
          <StyledInput placeholder="Nickname" size="large" />
        </Form.Item>

        <Form.Item>
          <StyledButton type="primary" htmlType="submit">
            회원가입
          </StyledButton>
        </Form.Item>
      </StyledForm>
    </FormContainer>
  );
}

export default RegisterBox;
