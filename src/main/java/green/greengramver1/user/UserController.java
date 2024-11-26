package green.greengramver1.user;

import green.greengramver1.common.model.ResultResponse;
import green.greengramver1.user.moder.UserSignInReq;
import green.greengramver1.user.moder.UserSignInRes;
import green.greengramver1.user.moder.UserSignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "유저", description = "회원가입, 로그인")
public class UserController {
    private final UserService service;

    /*
        파일 업로드시에는 RequestBody를 사용할 수 없음.
        RequestPart 애노테이션 사용해야 함

     */


    @PostMapping("sign-up")
    @Operation(summary = "회원 가입")
    public ResultResponse<Integer> signUp(@RequestPart UserSignUpReq p //파일이 여러개면 List<>들어간다
            , @RequestPart(required = false) MultipartFile pic) {
        log.info("UserInsReq: {}, file: {}", p, pic != null ? pic.getOriginalFilename() : null);
        {

        }

        {

            int result = service.postSignUp(pic, p);
            return ResultResponse.<Integer>builder()
                    .resultMessage("회원가입 완료")
                    .resultData(result)
                    .build();
        }
    }

    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultResponse<UserSignInRes> signIn(@RequestBody UserSignInReq p){
        UserSignInRes res = service.postSignIn(p);
        return ResultResponse.<UserSignInRes>builder()
                .resultMessage(res.getMessage())
                .resultData(res)
                .build();
    }
}
