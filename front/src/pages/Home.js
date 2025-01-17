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
  backgroundColor: "#000",
  borderTop: "0.5px solid #d9d9d9"
};

const Home = () => (
  <Layout style={layoutStyle}>
    <Header />
    <MainContent />
    <Footer style={footerStyle}>Team H&M</Footer>
  </Layout>
);

export default Home;
