import React from "react";
import { Layout } from "antd";
import Header from "../components/Header";
import WordBookTitle from "../components/WordBook/WordBookTitle";
import WordCardBox from "../components/WordBook/WordCardBox";

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
  backgroundColor: "#000",
  borderTop: "0.5px solid #d9d9d9"
};

const WordBook = () => (
  <Layout style={layoutStyle}>
    <Header />
    <Content style={contentStyle}>
    <WordBookTitle />
    <WordCardBox />
    </Content>
    <Footer style={footerStyle}>Team H&M</Footer>
  </Layout>
);

export default WordBook;
