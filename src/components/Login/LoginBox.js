import React from "react";
import styled from "styled-components";
import { Form, Input, Button, Typography } from "antd";

const { Link } = Typography;

const FormContainer = styled.div`
  width: 726px;
  height: 726px;
  background-color: #858585;
  padding: 30px 150px;
  border-radius: 50px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
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
  margin: 20px 0;
`;

const StyledForm = styled(Form)`
  width: 100%;
  margin-top: 20%;
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

const LinkWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
`;

const StyledLink = styled(Link)`
  color: #000 !important;

  &:hover {
    text-decoration: underline !important;
  }
`;

function LoginBox() {
  const handleSubmit = (values) => {
    console.log("Login Form Submitted:", values);
  };

  return (
    <FormContainer>
      <TitleWrapper>
        <Subtitle>MZ세대의 언어로 가득 찬 힙한 언어사전</Subtitle>
        <Title>WELCOME</Title>
      </TitleWrapper>
      <Line />
      <StyledForm
        name="loginForm"
        initialValues={{ remember: true }}
        onFinish={handleSubmit}
      >
        <Form.Item
          name="id"
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

        <Form.Item>
          <StyledButton type="primary" htmlType="submit">
            로그인
          </StyledButton>
        </Form.Item>

        <LinkWrapper>
          <StyledLink href="#">아이디 찾기</StyledLink>
          <StyledLink href="#">비밀번호 찾기</StyledLink>
        </LinkWrapper>
      </StyledForm>
    </FormContainer>
  );
}

export default LoginBox;
