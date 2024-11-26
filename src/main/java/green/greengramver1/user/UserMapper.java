package green.greengramver1.user;

import green.greengramver1.user.moder.UserSignInReq;
import green.greengramver1.user.moder.UserSignInRes;
import green.greengramver1.user.moder.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);
    UserSignInRes selUserForSignIn(UserSignInReq p);



}
