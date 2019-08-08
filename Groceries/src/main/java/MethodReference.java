import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class MethodReference {
//public static void saySomething() {
//	System.out.println("Here is ur thread");
//}
//	public static void main(String[] args) {
//		Thread t=new Thread(MethodReference::saySomething);  
//        t.start();       
//
//	}
	public static void main(String args[]) {
		Map<Integer, String> hmap = new HashMap<Integer, String>(); 
	    hmap.put(11, "Apple"); 
	    hmap.put(22, "Orange"); 
	    hmap.put(33, "Kiwi");  
	    hmap.put(44, "Banana"); 

	    Map<Integer, String> result = hmap.entrySet() 
	        .stream() 
	        .filter(map -> map.getKey().intValue() <= 22) 
	        .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));  

	    System.out.println("Result: " + result);

	}
	
	
}
