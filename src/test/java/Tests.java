import org.junit.*;
import org.junit.runners.MethodSorters;
import liquibase.exception.LiquibaseException;

import items.*;
import run.*;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.*;

import static junit.framework.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    @BeforeClass
    public static void beforeClass()throws SQLException, LiquibaseException{
        MyConnection.connect();
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "DROP TABLE IF EXISTS public.databasechangelog; DROP TABLE IF EXISTS user_copy;";
        stmt.execute(sql);
        Main.updateChangelog("1.0","2.0","5.0");
    }
    @AfterClass
    public static void afterClass()throws SQLException, LiquibaseException{
        Main.updateChangelog("4.0");
        MyConnection.disconnect();
    }

    @Test
    public void IdNotNullTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Data d = new Data();
        for (Chat e : d.getChatList()) {
            assertEquals(false, e.Id.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
        }
        for (ChatUser e : d.getChatUserList()) {
            assertEquals(false, e.Id.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
            assertEquals(false, e.ChatId.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
            assertEquals(false, e.UserId.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
        }
        for (Message e : d.getMessageList()) {
            assertEquals(false, e.Id.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
            assertEquals(false, e.FromUserId.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
            assertEquals(false, e.ToChatId.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
        }
        for (User e : d.getUserList()) {
            assertEquals(false, e.Id.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
        }
        for (UserHash e : d.getUserHashList()) {
            assertEquals(false, e.UserId.equals(UUID.fromString("00000000-0000-0000-0000-000000000000")));
        }
    }

    @Test
    public void ChatRelationTest() throws SQLException, LiquibaseException, ClassNotFoundException{
        Data d = new Data();
        for (Message m: d.getMessageList()) {
            boolean flag = false;
            for (Chat c: d.getChatList()) {
                if(m.ToChatId.equals(c.Id)) {
                    flag = true;
                    break;
                }
            }
            assertEquals(true,flag);
        }
        for (ChatUser cu: d.getChatUserList()) {
            boolean flag = false;
            for (Chat c: d.getChatList()) {
                if(cu.ChatId.equals(c.Id)) {
                    flag = true;
                    break;
                }
            }
            assertEquals(true,flag);
        }
    }

    @Test
    public void UserRelationTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Data d = new Data();
        for (Message m : d.getMessageList()) {
            boolean flag = false;
            for (User u : d.getUserList()) {
                if (m.FromUserId.equals(u.Id)) {
                    flag = true;
                    break;
                }
            }
            assertEquals(true, flag);
        }
        for (ChatUser cu : d.getChatUserList()) {
            boolean flag = false;
            for (User u : d.getUserList()) {
                if (cu.UserId.equals(u.Id)) {
                    flag = true;
                    break;
                }
            }
            assertEquals(true, flag);
        }
        for (UserHash uh : d.getUserHashList()) {
            boolean flag = false;
            for (User u : d.getUserList()) {
                if (uh.UserId.equals(u.Id)) {
                    flag = true;
                    break;
                }
            }
            assertEquals(true, flag);
        }
    }

}
