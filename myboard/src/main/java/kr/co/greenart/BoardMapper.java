package kr.co.greenart;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper // ibatis의 mapper라는 인터페이스를 만들 것인데 @Mapper라는 어노테이션으로
public interface BoardMapper {
	// 구현체를 따로 만들 필요없이 SQL문을 바로 적을 수 있다
	@Select("SELECT * FROM board") // 컬럼에 대해서 맵핑은 해줘야해서 result set mapper를 하나 만들어준다
	@Results(id = "boardResult" // 아이디를 써주고 나중에 재활용이 가능함
			, value = { @Result(property = "no", column = "no", id = true)
						,@Result(property = "title", column = "title")
						,@Result(property = "writer", column = "writer")
			})
	List<Article> getAll();
	
	@Select("SELECT COUNT(*) FROM board")
	int getCount();

	@Insert("INSERT INTO board(title, write) VALUES(#{title}, #{writer})")
	int write(Article a);
}
