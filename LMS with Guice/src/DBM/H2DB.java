package DBM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class H2DB {
    private static final String dburl="jdbc:h2:/Users/bisheshh/Downloads/MyWorkplace/MyGitExp/Database/LMSDB";
    private static Connection connection;
    private static Statement statement;
    private static String tablename;
    private static H2DB instance=null;

    public static H2DB getInstance(String t){
         if(instance==null){
             instance=new H2DB();
         }

         tablename=t;
         try{
             connection=DriverManager.getConnection(dburl);
             statement = connection.createStatement();
         }catch (SQLException e){
             connection=null;
             statement=null;
             System.out.println("Failed! ---->"+e.getMessage());
         }

         return instance;
    }

    public static H2DB add(List<String> args){
        Optional<String> s=args.stream().reduce((a, b)->a+"','"+b);
        String values="'" + s.get() + "'";

        String sql=String.format("Insert into %s values (%s)",tablename,values);

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instance;
    }

    public static List<List<String>> access(List<String> args){
        List<List<String>> list=new ArrayList<>();

        String sql=String
                .format("select * from " + tablename);

        try {
            ResultSet res=statement.executeQuery(sql);

            while(res.next()){
                List<String> ls=new ArrayList<>();

                for (String arg : args) {
                    ls.add(res.getString(arg));
                }

                list.add(ls);
            }

        } catch (SQLException e) {
            return null;
        }

        close();
        return list;
    }

    public static boolean close(){
        try {
            connection.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static H2DB delete(String idname,String id){

        String sql=String.format("delete from %s where %s = %s",tablename,idname,id);

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instance;
    }
}
