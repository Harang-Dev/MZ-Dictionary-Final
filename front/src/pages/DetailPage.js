import React from "react";
import { Layout } from "antd";
import Header from "../components/Header";
import DetailBox from "../components/SearchWord/DetailBox";
import CommentBox from "../components/SearchWord/CommentBox";

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
    flexDirection: "column",
};

const footerStyle = {
  textAlign: "center",
  color: "#fff",
  backgroundColor: "#4096ff",
};

const DetailPage = () => (
  <Layout style={layoutStyle}>
    <Header />
    <Content style={contentStyle}>
        <DetailBox />
        <CommentBox />
    </Content>
    <Footer style={footerStyle}>Footer</Footer>
  </Layout>
);

export default DetailPage;