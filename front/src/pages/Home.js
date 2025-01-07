import React from "react";
import { Layout } from "antd";
import Header from "../components/Header";
import MainContent from "../components/MainContent";

const { Footer } = Layout;

const layoutStyle = {
  minHeight: "100vh",
};

const footerStyle = {
  textAlign: "center",
  color: "#fff",
  backgroundColor: "#4096ff",
};

const Home = () => (
  <Layout style={layoutStyle}>
    <Header />
    <MainContent />
    <Footer style={footerStyle}>Footer</Footer>
  </Layout>
);

export default Home;
