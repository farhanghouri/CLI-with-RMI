package m;

public class SelectQueryCommand implements Command{
	private QueryReceiver qr;
	
	public SelectQueryCommand(QueryReceiver qr){
    	this.qr = qr;
    }

	@Override
	public Bean execute(String query) {
		return qr.selectQuery(query);
	}
    
}
