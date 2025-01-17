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

// 유저 디테일 API
export const userDetail = async (token) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.get(`${API}/user/detail`, {
        headers,
    });
    return response.data;
}

// 비회원 검색 API
export const searchWordGuest = async (keyWord) => {
    const response = await axios.get(`${API}/word/find/non-member`, {
        params: { keyWord },
    });
    return response.data;
};

// 회원 검색 API
export const searchWord = async (token, keyWord) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/word/find`, {
        params: { keyWord },
        headers,
    });
    return response.data;
}

// 회원용 전체 단어 조회 API
export const allWord = async (token) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/word/`, {
        headers,
    });
    console.log(response);
    return response.data;
};

// wordbook 페이지에 쓸 비회원 모든 단어 조회 API
export const allWordGuest = async () => {
    const response = await axios.get(`${API}/word/non-member`);
    console.log("워드북", response.data);
    return response.data;
}


// 스크랩 추가 API
export const addScrap = async (token, wordId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/scrap/add`, {
        params: { wordId },
        headers,
    });
    return response.data;
};

// 스크랩 삭제 API
export const deleteScrap = async (token, wordId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/scrap/delete`, {
        params: { wordId },
        headers,
    });
    return response.data;
};

// 좋아요 추가 API
export const addLike = async (token, wordId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/like/add`, {
        params: { wordId },
        headers,
    });
    return response.data;
};

// 좋아요 삭제 API
export const deleteLike = async (token, wordId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/like/delete`, {
        params: { wordId },
        headers,
    });
    return response.data;
};

//  비회원 특정 단어 조회 API
export const aboutWordGuest = async (wordId) => {
    const response = await axios.get(`${API}/word/info/non-member`, {
        params: { wordId },
    });
    return response.data;
}

// 특정 단어 조회 API
export const aboutWord = async (token, wordId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.get(`${API}/word/info`, {
        params: { wordId },
        headers,
    });
    console.log(response.data);
    return response.data;
};

// 댓글 조회
export const getComment = async (token) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.get(`${API}/comment`, {
        headers,
    });
    return response.data;
};



// 댓글 추가 API
export const addComment = async (token, commentText, wordId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.post(`${API}/comment/add`, {
        params: { commentText, wordId },
        headers,
    });
    return response.data;
};

// 답글 추가 API
export const addReply = async (token, replyText, commentId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.post(`${API}/comment/replay/add`, {
        params: { replyText, commentId },
        headers,
    });
    return response.data;
};

// 댓글 좋아요 추가 API
export const addReaction = async (token, targetId, reaction) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.post(`${API}/reaction/comment/add`, {
        params: { targetId, reaction },
        headers,
    });
    return response.data;
};

// 댓글 좋아요 삭제 API
export const deleteReaction = async (token, commentId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.get(`${API}/reaction/comment/delete`, {
        params: { commentId },
        headers,
    });
    return response.data;
};

// 답글 좋아요 추가 API
export const addReplyReaction = async (token, targetId, reaction) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.post(`${API}/reaction/reply/add`, {
        params: { targetId, reaction },
        headers,
    });
    return response.data;
};

// 답글 좋아요 삭제 API
export const deleteReplyReaction = async (token, replyId) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.get(`${API}/reaction/reply/delete`, {
        params: { replyId },
        headers,
    });
    return response.data;
};

// 스크랩한 단어 조회 API
export const myScrap = async (token) => {
    const headers = {
        "X-AUTH-TOKEN": token,
    }
    const response = await axios.get(`${API}/scrap/`, {
        headers,
    });
    const data = response.data.list;
    const wordIdData = data.map(item => item.wordId);
    return wordIdData;
};

// 스크랩한 단어조회 API (/word/)
export const myWordScrap = async (token) => {
    // 헤더 설정
    const headers = {
        "X-AUTH-TOKEN": token,
    };
    const response = await axios.get(`${API}/word/`, { headers });
    const data = response.data;
    const scrapData = [];

    for (let i = 0; i < data.length; i++) {
        if (data[i]?.scrapped === true) {
            scrapData.push(data[i]);
        }
    }
    console.log(scrapData);
    return scrapData;
};
