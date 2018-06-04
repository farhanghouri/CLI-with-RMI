package m;
  

public interface QueryReceiver{
     public Bean selectQuery(String query);
     public void insertQuery(String query) ;
     public void updateQuery(String query);
     public void deleteQuery(String query);
}
