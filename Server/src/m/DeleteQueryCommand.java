package m;

public class DeleteQueryCommand implements Command{
   private QueryReceiver qr;
	
	public DeleteQueryCommand(QueryReceiver qr){
    	this.qr = qr;
    }

	@Override
	public void execute(String query) {
		qr.deleteQuery(query);
	}
}
