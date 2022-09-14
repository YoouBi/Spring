package kr.co.greenart.model.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	private final File saveFoler = new File("d:\\temp\\");
	private final Path root = Paths.get("d:\\temp\\");
	
	@Override
	public Resource getByName(String fileName) {
//		throw new UnsupportedOperationException("미구현");
		try {
			return new UrlResource(new File(saveFoler.getAbsolutePath()
					+ File.separatorChar
					+ fileName).toURI());
		} catch (MalformedURLException e) {
			return null;
		}
	}

	@Override
	public List<String> getAllnames() {
		File[] filearr = saveFoler.listFiles(new FileFilter() { // (1)파일 필터라는 것으로 원하는 파일을 찾아낼 수 있다
			@Override
			public boolean accept(File pathname) {
				return !pathname.isDirectory();
			}
		});
		
//		return new ArrayList<String>(filearr); // 인터페이스... 스트링으로 해놔서 어쩔 수 없이 순환해야함...
//		List<File> list = new ArrayList<>();
		List<String> list = new ArrayList<>();
		for (File f : filearr) {
			list.add(f.getName());
//			if(!f.isDirectory()) {
//				list.add(f);
//			}
		} // 이렇게 하나씩 순환하면서 찾아도 되지만(1)
		
		return list;
		
//		// 표현은 똑같은데 그냥 봐도 당황하지 말라고 알려준 것
//		try {
//			Files.walk(root, 1) // Files.walk는 해당 경로의 목록들을 가져와서 스트링으로 반환하는데 자기자신까지 가져온다
//			// 1은 루트 경로에 있는 파일들을 1단계만 확인하겠다는 것 2를 쓰면 1 안에 있는 다른 2단계의 파일들도 볼 것
//					.filter(x -> !x.equals(this.root)) // 필터 안에 함수를 넣어서 원하는 객체를 골라낼 수 있는데
//			// 자바에서는 함수를 넣을 수 없다 객체가 아니기 때문
//			// 그래서 하나의 추상 메소드를 가지고 있는 인터페이스를 구현하면 함수를 표현할 수 있는데
//			// 자바 8버전에서는 함수를 인터페이스 형태로 구현할 수 있는데 '람다식'이라는 표현으로 만들 수 있다
//			// 지금 쓴 필터로는 자기 자신을 걸러냄
//					.map(y -> y.toString()) // .map은 원하는 형식으로 바꾸는 것
//					.collect(Collectors.toList()); // 스트링은 자바에서 1회용이기 때문에 컬렉터로 쓰는 것
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
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
