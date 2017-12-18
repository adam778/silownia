package Database;

public class DBMenager {
    private static DBMenager ourInstance = new DBMenager();

    public static DBMenager getInstance(){
        return ourInstance;
    }

    private DBMenager(){
        
    }

}
