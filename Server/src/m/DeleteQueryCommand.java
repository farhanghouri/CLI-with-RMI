package m;

public class DeleteQueryCommand implements Command{
   private QueryReceiver qr;
	
	public DeleteQueryCommand(QueryReceiver qr){
    	this.qr = qr;
    }

	@Override
	public Bean execute(String query) {
		return qr.deleteQuery(query);
	}
}
