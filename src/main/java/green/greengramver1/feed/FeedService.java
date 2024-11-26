package green.greengramver1.feed;

import green.greengramver1.common.MyFileUtils;
import green.greengramver1.feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final MyFileUtils myFileUtils;

    public FeedPostRes postFeed(List<MultipartFile> pics, FeedPostReq p) {

        int result = mapper.insFeed(p);

        //파일 저장
        //middlePath: feed/${feedId}
        String middlePath = String.format("feed/%s", p.getFeedId());

        // 폴더 만들기
        myFileUtils.makeFolders(middlePath);

        // 파일 저장
        FeedPicDto feedPicDto = new FeedPicDto();
        List<String> picList = new ArrayList<>();

        //feedPicDto에 feedId값 넣어주세요

        feedPicDto.setFeedId(p.getFeedId());

        for (MultipartFile pic : pics) {


            String savedPicName = myFileUtils.makeRandomFileName(pic);
            picList.add(savedPicName);

            String filePath = String.format("%s/%s", middlePath, savedPicName);
            try {
                myFileUtils.transForTo(pic, filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            feedPicDto.setPic(savedPicName);
            mapper.insFeedPic(feedPicDto);
        }
        FeedPostRes feedPostRes = new FeedPostRes();
        feedPostRes.setFeedId(p.getFeedId());
        feedPostRes.setPics(picList);


        return feedPostRes;
    }

    public List<FeedGetRes> getFeedList(FeedGetReq p) {
        List<FeedGetRes> list = mapper.selFeedList(p);
        // 사진 메핑
        for (FeedGetRes res : list) {
            List<String> picList = mapper.selFeedPicList(res.getFeedId());
            res.setPics(picList);
        }

        return list;
    }

}
