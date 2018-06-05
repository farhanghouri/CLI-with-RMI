package m;

public class UpdateQueryCommand implements Command{
	   private QueryReceiver qr;
		
		public UpdateQueryCommand(QueryReceiver qr){
	    	this.qr = qr;
	    }

		@Override
		public Bean execute(String query) {
			return qr.updateQuery(query);
		}
	}