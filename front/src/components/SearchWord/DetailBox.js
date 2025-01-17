import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { Card, Typography, Tabs, Space, Modal } from 'antd';
import { LikeOutlined, PushpinOutlined, LikeFilled, PushpinFilled } from '@ant-design/icons';
import TagBox from '../WordBook/TagBox';
import { useMutation } from '@tanstack/react-query';
import { addScrap, addLike, deleteLike, deleteScrap, aboutWord } from '../../API/api';  // 새로 API 추가
import styled from 'styled-components';

const OuterBox = styled(Card)`
  width: 1028px;
  height: 490px;
  margin: 0 auto;
  background-color: #262627;
  border-radius: 8px;
  padding: 16px;
  color: #fff;
`;

const InnerBox = styled.div`
  width: 980px;
  height: 324px;
  margin: 0 auto;
  background-color: #28282a;
  border-radius: 8px;
  padding: 16px;
`;

const Text = styled(Typography.Text)`
  color: #fff;
  text-align: left;
`;

const CustomTabs = styled(Tabs)`
  .ant-tabs-tab {
    color: #aaa;
    text-align: left;
    justify-content: flex-start;
  }

  .ant-tabs-tab-active .ant-tabs-tab-btn {
    color: #fff !important;
  }

  .ant-tabs-nav {
    display: flex;
    justify-content: flex-start;
  }

  .ant-tabs-nav::before {
    border-bottom: 1px solid #fff !important;
  }
`;

const DetailBox = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const data = location.state;
  
  useEffect(() => {
    console.log("넘어온 데이터:", data.word);
  }, [data]);

  const { wordTitle, meaning, usingExample, id, scrapped, liked, likesCount, scrapCount, wordCreatedAt } = data;
  const token = localStorage.getItem("token");

  const [activeTab, setActiveTab] = useState('meaning');
  const [isLiked, setIsLiked] = useState(liked);
  const [isScraped, setIsScraped] = useState(scrapped);

  const [currentLikesCount, setCurrentLikesCount] = useState(likesCount);
  const [currentScrapCount, setCurrentScrapCount] = useState(scrapCount);

  const handleTabChange = (key) => {
    setActiveTab(key);
  };

  // 새로 데이터를 가져오는 API
  const fetchUpdatedData = async () => {
    const response = await aboutWord(token, id);  // getWordData는 서버에서 데이터를 다시 가져오는 API
    const { likesCount, scrapCount } = response;
    setCurrentLikesCount(likesCount);
    setCurrentScrapCount(scrapCount);
  };

  // 스크랩 추가
  const { mutate: scrapMutate } = useMutation({
    mutationFn: () => addScrap(token, id),
    onSuccess: () => {
      setIsScraped(true);
      fetchUpdatedData();  // 데이터 새로 고침
      Modal.success({
        title: '저장 완료',
        content: '스크랩 했습니다!',
      });
    },
    onError: (error) => {
      console.error("에러 발생:", error.message);
    },
  });

  // 스크랩 삭제
  const { mutate: deleteScrapMutate } = useMutation({
    mutationFn: () => deleteScrap(token, id),
    onSuccess: () => {
      setIsScraped(false);
      fetchUpdatedData();  // 데이터 새로 고침
      Modal.success({
        title: '저장 완료',
        content: '스크랩을 삭제했어요!',
      });
    },
    onError: (error) => {
      console.error("에러 발생:", error.message);
    },
  });

  const handleScrapClick = () => {
    if (!token) {
      Modal.confirm({
        title: '로그인이 필요합니다',
        content: '이 기능을 사용하려면 로그인해야 합니다. 로그인 화면으로 이동하시겠습니까?',
        okText: '확인',
        cancelText: '취소',
        onCancel: () => {
          console.log("취소 버튼 클릭");
        },
        onOk: () => {
          navigate("/login");
        },
      });
      return;
    }
    if (isScraped) {
      deleteScrapMutate();
    } else {
      scrapMutate();
    }
  };

  // 좋아요 추가
  const { mutate: likeMutate } = useMutation({
    mutationFn: () => addLike(token, id),
    onSuccess: () => {
      setIsLiked(true);
      fetchUpdatedData();  // 데이터 새로 고침
      Modal.success({
        title: '저장 완료',
        content: '좋아요를 했습니다!',
      });
    },
    onError: (error) => {
      console.error("에러 발생:", error.message);
    },
  });

  // 좋아요 삭제
  const { mutate: deleteLikeMutate } = useMutation({
    mutationFn: () => deleteLike(token, id),
    onSuccess: () => {
      setIsLiked(false);
      fetchUpdatedData();  // 데이터 새로 고침
      Modal.success({
        title: '저장 완료',
        content: '좋아요를 삭제했어요!',
      });
    },
    onError: (error) => {
      console.error("에러 발생:", error.message);
    },
  });

  const handleLikeClick = () => {
    if (!token) {
      Modal.confirm({
        title: '로그인이 필요합니다',
        content: '이 기능을 사용하려면 로그인해야 합니다. 로그인 화면으로 이동하시겠습니까?',
        okText: '확인',
        cancelText: '취소',
        onCancel: () => {
          console.log("취소 버튼 클릭");
        },
        onOk: () => {
          navigate("/login");
        },
      });
      return;
    }
    if (isLiked) {
      deleteLikeMutate();
    } else {
      likeMutate();
    }
  };

  return (
    <OuterBox bodyStyle={{ padding: 0 }}>
      <Typography.Title level={2} style={{ color: '#fff', textAlign: 'left', marginBottom: '16px', paddingLeft: '20px' }}>
        <h4 style={{ margin: 0, color: 'white' }}>MZ Word</h4>
        {wordTitle}
      </Typography.Title>

      <InnerBox>
        <Space size="large" style={{ display: 'flex', justifyContent: 'flex-start', marginBottom: '16px' }}>
          <Space style={{ color: '#fff' }} onClick={handleLikeClick}>
            {isLiked ? <LikeFilled style={{ color: '#ff4d4f' }} /> : <LikeOutlined />}
            <Text>{currentLikesCount || 0}</Text>
          </Space>
          <Space style={{ color: '#fff' }} onClick={handleScrapClick}>
            {isScraped ? <PushpinFilled style={{ color: '#ffcc00' }} /> : <PushpinOutlined />}
            <Text>{currentScrapCount || 0}</Text>
          </Space>
        </Space>

        <Text style={{ display: 'block', marginBottom: '16px' }}>업데이트 날짜: {wordCreatedAt}</Text>

        <Space size="small" style={{ marginBottom: '16px', display: 'flex', justifyContent: 'flex-start' }}>
          <Text>카테고리</Text>
          <TagBox label="웃겨요" color="green" />
          <TagBox label="재밌어요" color="blue" />
          <TagBox label="신나요" color="purple" />
        </Space>

        <CustomTabs activeKey={activeTab} onChange={handleTabChange} tabPosition="top">
          <Tabs.TabPane tab="Meaning" key="meaning" style={{ textAlign: 'left' }}>
            <Typography.Paragraph style={{ color: '#fff', textAlign: 'left' }}>
              {meaning}
            </Typography.Paragraph>
          </Tabs.TabPane>
          <Tabs.TabPane tab="Example" key="example" style={{ textAlign: 'left' }}>
            <Typography.Paragraph style={{ color: '#fff', textAlign: 'left' }}>
              {usingExample}
            </Typography.Paragraph>
          </Tabs.TabPane>
        </CustomTabs>
      </InnerBox>
    </OuterBox>
  );
};

export default DetailBox;
