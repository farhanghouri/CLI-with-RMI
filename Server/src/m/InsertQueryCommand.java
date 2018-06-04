package m;

public class InsertQueryCommand implements Command{
	   private QueryReceiver qr;
		
		public InsertQueryCommand(QueryReceiver qr){
	    	this.qr = qr;
	    }

		@Override
		public void execute(String query) {
			qr.insertQuery(query);
		}
	}