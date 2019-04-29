package cn.wzy.Collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	//合法性检测
	public static void allMatch() {
		List<String> list = Arrays.asList("asdfs", "assdf", "assdf");
		Stream<String> stream = list.stream();
		System.out.println(stream.allMatch((p) -> p.length() > 4));
	}

	static class User {
		Integer id;
		String name;

		User(Integer id, String name) {
			this.name = name;
			this.id = id;
		}

		@Override
		public String toString() {
			return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
		}
	}

	//map and reduce
	public static void map() {
		List<User> list = Arrays.asList(new User(1,null), new User(2,"aaa"), new User(3,"bbb"));
		Stream<User> stream = list.stream();
			list = stream.map((p) -> {
			if (p.name == null)
				p.name = "default";
			return p;
		}).collect(Collectors.toList());
		System.out.println(list);
	}

	/**
	 * 抽取出某些字段
	 */
	public static void mapReduceTest() {
		List<User> list = Arrays.asList(new User(1,null), new User(2,"aaa"), new User(3,"bbb"));
		Map<Integer, String> idNames = new HashMap<>();
		Stream<User> stream = list.stream();
		stream.forEach((p) -> {
			idNames.put(p.id,p.name);
		});
		System.out.println(idNames);
	}

	public static void main(String[] args) {
		mapReduceTest();
	}
}
