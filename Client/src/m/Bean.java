package m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Bean implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String table_name; 
    public ArrayList<Map<String, String>> tuples;
}
