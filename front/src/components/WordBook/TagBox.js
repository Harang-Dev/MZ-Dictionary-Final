import React from 'react';
import { Tag } from 'antd';
import styled from 'styled-components';

const StyledTag = styled(Tag)`
  border-radius: 8px;
  padding: 4px 12px;
  font-size: 14px; 
  color: #fff;
`;

const TagBox = ({ label, color }) => {
  return <StyledTag color={color}>{label}</StyledTag>;
};

export default TagBox;
