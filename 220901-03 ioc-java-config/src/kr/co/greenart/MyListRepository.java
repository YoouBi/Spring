package kr.co.greenart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("mylist")
public class MyListRepository implements MyDataRepository {
	// 여러개의 객체가 하나의...가져올 수 있게끔 정의하는게 Iterable
	@Override
	public Iterable<Integer> getMyNumbers() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);		
		return list;
	}
}
