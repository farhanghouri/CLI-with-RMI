package m;
  

public interface QueryReceiver{
     public Bean selectQuery(String query);
     public Bean insertQuery(String query) ;
     public Bean updateQuery(String query);
     public Bean deleteQuery(String query);
}
