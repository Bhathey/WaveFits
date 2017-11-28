package testCollections;
 
import java.util.ArrayList;

public class DropdownEntity {

	public static void main(String[] args) {
		ArrayList<String> country = new ArrayList<String>();
		country.add("United States");
		country.add("Tuvalu");
		country.add("Aruba");
		country.add("Uganda");
		country.add("Zambia");
		
		String x = country.get(2);
		System.out.println(x);
	}

}
