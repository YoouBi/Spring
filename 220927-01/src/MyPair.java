
public class MyPair<K, V> { // 지금은 Key와 Value를 써주려고 K와 V를 쓴 것
	private K key; // 이렇게 여러개도 된다
	private V value;
	
	public MyPair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
