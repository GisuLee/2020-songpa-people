package com.songpapeople.hashtagmap.instagram.service;

import com.songpapeople.hashtagmap.blacklist.service.dto.AbnormalInstagramDto;
import com.songpapeople.hashtagmap.instagram.domain.model.Instagram;
import com.songpapeople.hashtagmap.instagram.domain.repository.InstagramQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InstagramQueryService {
    public static final int SUB_BLACK_LIST_SIZE = 20;

    private final InstagramQueryRepository instagramQueryRepository;

    public List<AbnormalInstagramDto> findSemiBlackListInstagram() {
        List<Instagram> instagrams = instagramQueryRepository.findAllOrderByHashtagCountAndLimitBy(SUB_BLACK_LIST_SIZE);
        return instagrams.stream()
                .map(AbnormalInstagramDto::of)
                .collect(Collectors.toList());
    }
}
