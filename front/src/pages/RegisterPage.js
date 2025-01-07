import React from "react";
import { Layout } from "antd";
import Header from "../components/Header";
import RegisterImage from "../components/Auth/RegisterImage";
import RegisterBox from "../components/Auth/RegisterBox";

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
  backgroundColor: "#4096ff",
};

const RegisterPage = () => (
  <Layout style={layoutStyle}>
    <Header />
    <Content style={contentStyle}>
      <RegisterImage />
      <RegisterBox />
    </Content>
    <Footer style={footerStyle}>Footer</Footer>
  </Layout>
);

export default RegisterPage;