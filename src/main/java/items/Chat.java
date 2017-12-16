package items;

import java.util.UUID;

public class Chat {
    public UUID Id;
    public String Name;

    public Chat(UUID id, String name){
        Id = id;
        Name = name;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id.equals(((Chat)obj).Id) && Name.equals(((Chat)obj).Name));
    }
}
