package maven.project.JavaRoadmap.collectionsFramework;

import java.util.Hashtable;

public class CFHashTable {

	public static void main(String[] args) {
		Hashtable<Integer, String> hash = new Hashtable<>(10);
		
		hash.put(1, "A");
		hash.put(2, "B");
		hash.put(3, "C");
		hash.put(12, "Ab");
		hash.put(13, "Ac");
		hash.put(23, "Bc");
		
		
		for(Integer key : hash.keySet()) {
			System.out.println(key.hashCode()%10+"\t"+key+"\t"+hash.get(key));
		}
	}

}
