package m;

public class InsertQueryCommand implements Command{
	   private QueryReceiver qr;
		
		public InsertQueryCommand(QueryReceiver qr){
	    	this.qr = qr;
	    }

		@Override
		public Bean execute(String query) {
			return qr.insertQuery(query);
		}
	}