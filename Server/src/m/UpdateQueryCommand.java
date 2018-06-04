package m;

public class UpdateQueryCommand implements Command{
	   private QueryReceiver qr;
		
		public UpdateQueryCommand(QueryReceiver qr){
	    	this.qr = qr;
	    }

		@Override
		public void execute(String query) {
			qr.updateQuery(query);
		}
	}