package run;

import items.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Data {
    private List<Chat> ChatList = new ArrayList<Chat>();
    private List<ChatUser> ChatUserList = new ArrayList<ChatUser>();
    private List<Message> MessageList = new ArrayList<Message>();
    private List<User> UserList = new ArrayList<User>();
    private List<UserHash> UserHashList = new ArrayList<UserHash>();

    public List<Chat> getChatList() {
        return ChatList;
    }
    public List<ChatUser> getChatUserList() {
        return ChatUserList;
    }
    public List<Message> getMessageList() { return MessageList;    }
    public List<User> getUserList() {
        return UserList;
    }
    public List<UserHash> getUserHashList() {
        return UserHashList;
    }

    public Data() throws SQLException{
        getChat();
        getChatUser();
        getMessage();
        getUser();
        getUserHash();
    }

    private void getChat() throws SQLException{
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "SELECT * FROM Chat";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Chat chat = new Chat((UUID)result.getObject(1), result.getString(2));
            ChatList.add(chat);
        }
    }
    private void getChatUser() throws SQLException{
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "SELECT * FROM chat_user";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            ChatUser chatUser = new ChatUser((UUID)result.getObject(1), (UUID)result.getObject(2),(UUID)result.getObject(3));
            ChatUserList.add(chatUser);
        }
    }
    private void getMessage() throws SQLException{
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "SELECT * FROM message";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Message message = new Message((UUID)result.getObject(1), (UUID)result.getObject(2),(UUID)result.getObject(3),result.getString(4));
            MessageList.add(message);
        }
    }
    private void getUser() throws SQLException{
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "SELECT * FROM \"user\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            User user = new User((UUID)result.getObject(1), result.getString(2), result.getString(3));
            UserList.add(user);
        }
    }
    private void getUserHash() throws SQLException{
        Statement stmt = MyConnection.connection.createStatement();
        String sql = "SELECT * FROM user_hash";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            UserHash userHash = new UserHash(result.getString(1), (UUID)result.getObject(2));
            UserHashList.add(userHash);
        }
    }
}
