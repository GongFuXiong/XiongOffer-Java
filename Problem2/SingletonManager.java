package Problem2;

import java.util.HashMap;
import java.util.Map;
//import com.sun.javafx.collections.MappingChange.Map;
/*
 * 容器类实现单例模式
 * SingletonManager可以管理多个单例类型，使用时根据key获取对象对应类型的对象。
 * 这种方式可以通过统一的接口获取操作，隐藏了具体实现，降低了耦合度。
 */
public class SingletonManager {
	private static Map<String,Object> map=  new HashMap<String,Object>();  //创建一个map集合对象
	
	public static void regsiterService(String key,Object instance) {   //定义一个寄存器函数
		if (!map.containsKey(key)) {    //判断map集合是否包含key值
			map.put(key, instance);    //如果没有key值，则添加key值
		}
	}
	public static Object getService(String key) {		//得到寄存器中的key值对应的instance实例
		return map.get(key);
	}

}
