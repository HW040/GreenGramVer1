package green.greengramver1.user.moder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSignUpReq {
    @Schema(description = "유저 아이디", example = "mic"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private String uid;
    @Schema(description = "유저 비밀번호", example = "1212"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(description = "유저 프로필 사진")
    private String pic;
    @Schema(description = "유저 닉네임", example = "홍길동")
    private String nickName;

    @JsonIgnore
    private long userId;
}
