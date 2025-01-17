import React from "react";
import { Layout } from "antd";
import Header from "../components/Header";
import MyWordTitle from "../components/MyWord/MyWordTitle";
import MyWordCard from "../components/MyWord/MyWordCard";

const { Footer, Content } = Layout;

const layoutStyle = {
  minHeight: "100vh",
  backgroundColor: '#000'
};

const contentStyle = {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'column',
    padding: '0 100px'
}

const footerStyle = {
  textAlign: "center",
  color: "#fff",
  backgroundColor: "#4096ff",
};

const MyWord = () => (
  <Layout style={layoutStyle}>
    <Header />
    <Content style={contentStyle}>
        <MyWordTitle />
        <MyWordCard />
    </Content>
    <Footer style={footerStyle}>Footer</Footer>
  </Layout>
);

export default MyWord;
