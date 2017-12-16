package items;


import java.util.UUID;

public class Message {
    public UUID Id;
    public UUID FromUserId;
    public UUID ToChatId;
    public String Content;

    public Message(UUID id, UUID fromUserId, UUID toChatId, String content){
        Id = id;
        FromUserId = fromUserId;
        ToChatId = toChatId;
        Content = content;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id.equals(((Message)obj).Id) && FromUserId.equals(((Message)obj).FromUserId) && ToChatId.equals(((Message)obj).ToChatId) && Content.equals(((Message)obj).Content));
    }
}
