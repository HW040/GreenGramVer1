package green.greengramver1.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedGetRes {
    private long writerId;
    private long feedId;
    private String contents;
    private String location;
    private String createdAt;
    private String writerNm;
    private String writerPic;

    private List<String> pics;




}
