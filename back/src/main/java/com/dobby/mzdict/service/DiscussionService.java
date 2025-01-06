package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.DiscussionMapper;
import com.dobby.mzdict.vo.DiscussionVO;
import com.dobby.mzdict.vo.UserDiscussionVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiscussionService {
    private final DiscussionMapper mapper;

    public DiscussionService(DiscussionMapper mapper) {
        this.mapper = mapper;
    }

    public boolean addDiscussion(DiscussionVO discussionVO){
        LocalDateTime now = LocalDateTime.now();
        discussionVO.setCreateTime(now);
        discussionVO.setUseStatus(false);

        return mapper.addDiscussion(discussionVO);
    }

    public boolean updateDiscussion(DiscussionVO discussionVO){
        return mapper.updateDiscussion(discussionVO);
    }

    public boolean deleteDiscussion(int id){
        return mapper.deleteDiscussion(id);
    }

    public DiscussionVO getTodayDiscussion() {
        return mapper.getTodayDiscussion();
    }

    public DiscussionVO getDiscussionById(int id) {
        return mapper.getDiscussionById(id);
    }

    public List<DiscussionVO> getDiscussions() {
        return mapper.getDiscussions();
    }

    public boolean selectOption(UserDiscussionVO userDiscussionInfo){
        return mapper.selectOption(userDiscussionInfo);
    }

    public Map<String, Integer> getOptionCounts() {
        List<DiscussionVO> trueOptions = mapper.getTrueOptions();
        List<DiscussionVO> falseOptions = mapper.getFalseOptions();

        Map<String, Integer> optionCounts = new HashMap<>();
        optionCounts.put("option1", trueOptions.size());
        optionCounts.put("option2", falseOptions.size());

        return optionCounts;
    }
}
