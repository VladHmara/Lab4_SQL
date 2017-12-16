package items;

import java.util.UUID;

public class ChatUser {
    public UUID Id;
    public UUID ChatId;
    public UUID UserId;

    public ChatUser(UUID id, UUID chatId, UUID userId){
        Id = id;
        ChatId = chatId;
        UserId = userId;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id.equals(((ChatUser)obj).Id) && ChatId.equals(((ChatUser)obj).ChatId) && UserId.equals(((ChatUser)obj).UserId));
    }
}
