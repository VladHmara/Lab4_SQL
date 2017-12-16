package items;


import java.util.UUID;

public class UserHash {
    public String Hash;
    public UUID UserId;

    public UserHash(String hash, UUID userId){
        Hash = hash;
        UserId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        return (Hash.equals(((UserHash)obj).Hash)&& UserId.equals(((UserHash)obj).UserId));
    }
}
