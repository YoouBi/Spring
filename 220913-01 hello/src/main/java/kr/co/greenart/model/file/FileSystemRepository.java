package kr.co.greenart.model.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	@Override
	public Resource getByName(String fileName) {
		throw new UnsupportedOperationException("미구현");
	}

	@Override
	public List<String> getAllnames() {
		throw new UnsupportedOperationException("미구현");
	}

	@Override
	public int save(MultipartFile file) {
		File saveFolder = new File("d:\\temp\\");
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		
		try {
			file.transferTo(new File(saveFolder.getAbsolutePath()
					+ File.separatorChar
					+ file.getOriginalFilename()));
			// transferTo 안에 어느경로에 저장할건지만 파일 또는 패스 객체로만 전달해주면
			// (혹은 직접 경로를 전달해주거나 Resource-스프링에서 자원들을 다룰 때 쉽게 쓸 수 있게끔 만드는 객체- 전달)
			// 알아서 변환해준다
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return 0;
		}
		
//		Path saveFolder = Paths.get("d:\\");
//		try {
//			if(!Files.exists(saveFolder)) {
//				Files.createDirectories(saveFolder);
//			}
//			file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename()).normalize()));
//			return 1;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return 0;
//		}
	}
}
