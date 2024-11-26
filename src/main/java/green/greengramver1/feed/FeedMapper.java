package green.greengramver1.feed;

import green.greengramver1.feed.model.FeedGetReq;
import green.greengramver1.feed.model.FeedGetRes;
import green.greengramver1.feed.model.FeedPicDto;
import green.greengramver1.feed.model.FeedPostReq;
import green.greengramver1.user.moder.UserSignInReq;
import green.greengramver1.user.moder.UserSignInRes;
import green.greengramver1.user.moder.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedPostReq p);
    List<FeedGetRes> selFeedList(FeedGetReq p);

    int insFeedPic(FeedPicDto p);
    List<String> selFeedPicList(long p);



}
