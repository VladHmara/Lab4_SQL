package items;


import java.util.UUID;

public class User {
    public UUID Id;
    public String FirstName;
    public String LastName;

    public User(UUID id, String firstName, String lastName){
        Id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id.equals(((User)obj).Id) && FirstName.equals(((User)obj).FirstName) && LastName.equals (((User)obj).LastName));
    }
}
