package green.greengramver1.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import green.greengramver1.common.model.ResultResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@Schema(title = "피드 등록")
public class FeedPostReq {
    @JsonIgnore
    private long feedId;
    @Schema(title = "로그인 유저 PK")
    private long writerUserId;
    @Schema(title = "내용")
    private String contents;
    @Schema(title = "위치")
    private String location;




}
