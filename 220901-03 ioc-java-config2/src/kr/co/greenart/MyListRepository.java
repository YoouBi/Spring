package kr.co.greenart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mylist")
public class MyListRepository implements MyDataRepository {
	@Autowired
	private List<Integer> list; // (1,2,3,4,5)리스트 객체가 이쪽으로 주입될 것
	
	// 여러개의 객체가 하나의...뭘?? 가져올 수 있게끔 정의하는게 Iterable
	@Override
	public Iterable<Integer> getMyNumbers() {	
		return list;
	}
}
