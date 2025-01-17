import React from "react";
import { Layout } from "antd";
import Header from "../components/Header";
import LoginBox from "../components/Login/LoginBox";
import LoginImage from "../components/Login/LoginImage";

const { Footer, Content } = Layout;

const layoutStyle = {
  minHeight: "100vh",
};

const contentStyle = {
    flex: 1,
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#000',
};

const footerStyle = {
  textAlign: "center",
  color: "#fff",
  backgroundColor: "#000",
  borderTop: "0.5px solid #d9d9d9"
};

const LoginPage = () => (
  <Layout style={layoutStyle}>
    <Header />
    <Content style={contentStyle}>
        <LoginImage />
        <LoginBox />
    </Content>
    <Footer style={footerStyle}>Team H&M</Footer>
  </Layout>
);

export default LoginPage;