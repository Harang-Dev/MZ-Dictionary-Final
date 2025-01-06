package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.DiscussionVO;
import com.dobby.mzdict.vo.UserDiscussionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscussionMapper {
    public Boolean addDiscussion(DiscussionVO discussionVO);
    public Boolean updateDiscussion(DiscussionVO discussionVO);
    public Boolean deleteDiscussion(int discussionId);
    public List<DiscussionVO> getDiscussions();
    public DiscussionVO getTodayDiscussion();
    public DiscussionVO getDiscussionById(int id);
    public Boolean selectOption(UserDiscussionVO userDiscussionInfo);
    public List<DiscussionVO> getTrueOptions();
    public List<DiscussionVO> getFalseOptions();
}
