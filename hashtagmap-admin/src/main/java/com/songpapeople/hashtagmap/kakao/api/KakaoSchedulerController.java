package com.songpapeople.hashtagmap.kakao.api;

import com.songpapeople.hashtagmap.kakao.service.KakaoScheduleCommandService;
import com.songpapeople.hashtagmap.kakao.service.KakaoScheduleQueryService;
import com.songpapeople.hashtagmap.kakao.service.dto.KakaoScheduleToggleDto;
import com.songpapeople.hashtagmap.response.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao/scheduler")
public class KakaoSchedulerController {

    private final KakaoScheduleCommandService kakaoScheduleCommandService;
    private final KakaoScheduleQueryService kakaoScheduleQueryService;

    @PostMapping("/toggle")
    @ResponseStatus(HttpStatus.OK)
    public CustomResponse<Void> startCron(@RequestBody final KakaoScheduleToggleDto kakaoScheduleToggleDto) {
        kakaoScheduleCommandService.toggleSchedule(kakaoScheduleToggleDto.getName());
        return CustomResponse.empty();
    }

    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public CustomResponse<Boolean> getActiveStatus(@RequestParam("name") String name) {
        return CustomResponse.of(kakaoScheduleQueryService.getKakaoScheduleActiveStatus(name));
    }

}
