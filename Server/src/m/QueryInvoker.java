package m;

public class QueryInvoker {
    private Command command;
    public QueryInvoker(Command command){
    	this.command = command;
    }
    public Bean execute(String query){
    	return command.execute(query);
    }
}
