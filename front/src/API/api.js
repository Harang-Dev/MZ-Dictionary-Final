import axios from "axios";

const API = process.env.REACT_APP_API;

// 회원가입 API
export const signUp = async (formData) => {
    const response = await axios.post(`${API}/user/signup`, formData);
    console.log("데이터", response.data);
    return response.data;
};

// 로그인 API
export const signIn = async (formData) => {
    const response = await axios.post(`${API}/user/signin`, formData);
    return response.data;
};

// 검색 API
export const searchWord = async (keyWord, token) => {
    const headers = {
        "X-AUTH-TOKEN" : token,
    };
    const response = await axios.get(`${API}/word/find`, {
        params: { keyWord },
        headers,
    });
    return response.data;
};