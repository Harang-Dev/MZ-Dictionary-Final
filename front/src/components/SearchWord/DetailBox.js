import React from 'react';
import { useLocation } from 'react-router-dom';
import { Card, Flex, Typography } from 'antd';

const cardStyle = {
  maxWidth: 1034,
  width: '100%',
  margin: '0 auto',
  padding: 0,
  backgroundColor: 'black',
  border: 'none',
};

const imgStyle = {
  display: 'block',
  width: 410,
  height: 525,
  marginRight: 186,
};

const DetailBox = () => {
  const location = useLocation();
  const data = location.state;
  const { wordTitle, meaning, usingExample } = data[0];

  return (
    <Card style={cardStyle} bodyStyle={{ padding: 0 }}>
      <Flex justify="space-between">
        <img alt="avatar" src="/media/gunssak.png" style={imgStyle} />
        <Flex vertical align="flex-start" justify="center" style={{ width: '100%' }}>
          <Flex justify="start" align="center" style={{ marginBottom: '8px' }}>
            <Typography.Text style={{ color: '#fff', marginRight: '16px' }}>
              좋아요 120
            </Typography.Text>
            <Typography.Text style={{ color: '#fff', marginRight: '16px' }}>
              댓글 15
            </Typography.Text>
          </Flex>

          <Typography.Title level={1} style={{ color: '#fff' }}>
            {wordTitle}
          </Typography.Title>

          <div style={{ marginTop: '16px' }}>
            <Typography.Title level={4} style={{ marginBottom: '8px', color: '#fff' }}>
              Meaning
            </Typography.Title>
            <Typography.Paragraph style={{ color: '#fff' }}>
              {meaning}
            </Typography.Paragraph>
          </div>

          <div style={{ marginTop: '16px' }}>
            <Typography.Title level={4} style={{ marginBottom: '8px', color: '#fff' }}>
              Using Example
            </Typography.Title>
            <Typography.Paragraph style={{ color: '#fff' }}>
              {usingExample}
            </Typography.Paragraph>
          </div>
        </Flex>
      </Flex>
    </Card>
  );
};

export default DetailBox;
