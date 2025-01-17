import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import DetailPage from './pages/DetailPage';
import WordBook from './pages/WordBook';
import ResultPage from './pages/ResultPage';
import MyWord from './pages/MyWord';
import './App.css'



function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/wordbook" element={<WordBook />} />
        <Route path="/detail" element={<DetailPage />} />
        <Route path="/search-result" element={<ResultPage />} />
        <Route path="/myword" element={<MyWord />} />
      </Routes>
    </Router>
  );
}

export default App;
