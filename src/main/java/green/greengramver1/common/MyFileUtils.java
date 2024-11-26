package green.greengramver1.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Slf4j
@Component
public class MyFileUtils {
    private final String uploadPath;

    /*
    @Value("${file.directory}")
    yaml 파일에 있는 file.directory 속성에 저장된 값을 생성자 호출할 때 값을 넣어준다.
     */

    public MyFileUtils(@Value("${file.directory}") String uploadPath) {
        log.info("MyFileUtils: uploadPath = {}", uploadPath);
        this.uploadPath = uploadPath;
    }

    // path = "ddd/aaa"
    // D:/RYU/2024-02-board-1/greengram_ver1/ddd/aaa
    //디렉토리 생성
    public String makeFolders(String path) {
        File file = new File(uploadPath, path);
        file.mkdirs();
        return file.getAbsolutePath(); //AbsolutePath 절대경로
    }

    public String getExt(String fileName) {
        int lastIdx = fileName.lastIndexOf(".");
        return fileName.substring(lastIdx);
    }

    //랜덤파일명 생성
    public String makeRandomFileName() {        // makeRandomFileName 똑같은명 의 메소드 이름을 오버로딩 이라 한다 파라미터만 다르면 됨

        return UUID.randomUUID().toString();
    }

    //랜덤파일명 + 확장자 생성하여 리턴
    public String makeRandomFileName(String originalFileName) {
        return makeRandomFileName() + this.getExt(originalFileName);
    }

    // String savedPicName = myFileUtils.makeRandomFileName(pic.getOriginalFilename());
    // 위와 같이 하는 방법
    public String makeRandomFileName(MultipartFile file) {
        return makeRandomFileName(file.getOriginalFilename());
    }

    //파일을 원하는 경로에 저장
    public void transForTo(MultipartFile mf, String path) throws IOException {
        File file = new File(uploadPath, path);
        mf.transferTo(file);
    }


}

class Test {
    public static void main(String[] args) {
        MyFileUtils myFileUtils = new MyFileUtils("C:/temp");
        String randomFileName = myFileUtils.makeRandomFileName("707211_1532672215.jpg");
        System.out.println(randomFileName);
    }
}