package Users;



import Notifications.NotificationChannels.NotificationChannel;



import java.util.List       ;
import java.util.ArrayList  ;

import java.util.Map    ;
import java.util.HashMap;

import java.util.Objects;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;



public class User {
    private String userName ;
    private String email    ;
    private String phone    ;
    private String password ;
    private String address  ;

    private final   LocalDateTime createdTime;
    private         LocalDateTime updatedTime;

    Map<String, List<String>>   chats;
    List<NotificationChannel>   rules;



    public User(String userName, String email, String phone, String password, String address) {
        if (    !this.valUserName   (userName   )   ||
                !this.valEmail      (email      )   ||
                !this.valPhone      (phone      )   ||
                !this.valPassword   (password   )   ||
                !this.valAddress    (address    )
        ) {
            throw new IllegalArgumentException("Invalid User Arguments!");
        }

        this.userName   =   userName    ;
        this.email      =   email       ;
        this.phone      =   phone       ;
        this.password   =   password    ;
        this.address    =   address     ;

        this.createdTime    =   LocalDateTime.now();
        this.updatedTime    =   LocalDateTime.now();

        this.chats  =   new HashMap<>   ();
        this.rules  =   new ArrayList<> ();
    }



    public String getUserName   ()  { return this.userName  ;   }
    public String getEmail      ()  { return this.email     ;   }
    public String getPhone      ()  { return this.phone     ;   }
    public String getPassword   ()  { return this.password  ;   }
    public String getAddress    ()  { return this.address   ;   }

    public LocalDateTime getCreatedTime()   { return this.createdTime;  }
    public LocalDateTime getUpdatedTime()   { return this.updatedTime;  }

    public List<NotificationChannel> getRules() { return this.rules;    }



    public void setUserName (String userName    )   { if (!this.valUserName (userName   ))  { throw new IllegalArgumentException("Invalid UserName  Argument!"  );  }   this.userName     =   userName    ;   this.updateUser();  }
    public void setEmail    (String email       )   { if (!this.valEmail    (email      ))  { throw new IllegalArgumentException("Invalid Email     Argument!"  );  }   this.email        =   email       ;   this.updateUser();  }
    public void setPhone    (String phone       )   { if (!this.valPhone    (phone      ))  { throw new IllegalArgumentException("Invalid Phone     Argument!"  );  }   this.phone        =   phone       ;   this.updateUser();  }
    public void setPassword (String password    )   { if (!this.valPassword (password   ))  { throw new IllegalArgumentException("Invalid Password  Argument!"  );  }   this.password     =   password    ;   this.updateUser();  }
    public void setAddress  (String address     )   { if (!this.valAddress  (address    ))  { throw new IllegalArgumentException("Invalid Address   Argument!"  );  }   this.address      =   address     ;   this.updateUser();  }



    private Boolean valUserName (String userName)   { return userName   != null && !userName.trim().isEmpty()  ;   }
    private Boolean valEmail    (String email   )   { return email      != null && !email   .trim().isEmpty()  ;   }
    private Boolean valPhone    (String phone   )   { return phone      != null && !phone   .trim().isEmpty()  ;   }
    private Boolean valPassword (String password)   { return password   != null && !password.trim().isEmpty()  ;   }
    private Boolean valAddress  (String address )   { return address    != null && !address .trim().isEmpty()  ;   }



    public void sendMessage(User user, String message) {
        if (user.getUserName().equals(this.userName)) {
            throw new RuntimeException("Invalid SEND Operation!");
        }

        List<String> result = this.chats.get(user.getUserName());

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (result == null) {
            this.chats.put(user.getUserName(), new ArrayList<>());
        }

        this.chats.get(user.getUserName()).add(timeStamp + " Me: " + message);

        user.recvMessage(this, message);
    }

    private void recvMessage(User user, String message) {
        if (user.getUserName().equals(this.userName)) {
            throw new RuntimeException("Invalid RECV Operation!");
        }

        List<String> result = this.chats.get(user.getUserName());

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (result == null) {
            this.chats.put(user.getUserName(), new ArrayList<>());
        }

        this.chats.get(user.getUserName()).add(timeStamp + " " + user.getUserName() + ": " + message);
    }

    public List<String> viewMessages(String userName) {
        if (!this.chats.containsKey(userName)) {
            throw new RuntimeException("Invalid VIEW Operation!");
        }

        return new ArrayList<>(this.chats.get(userName));
    }



    public void addNotificationRule(NotificationChannel rule) {
        this.rules.add(rule);
    }



    private void updateUser() {
        this.updatedTime = LocalDateTime.now();
    }



    public Boolean valPasswd(String password) {
        return this.password.equals(password);
    }



    @Override
    public String toString() {
        return  "User ["        +
                this.userName   +   " " +
                this.email      +   " " +
                this.phone      +   " " +
                this.address            +
                "]";
    }



    @Override
    public int hashCode() {
        return Objects.hash(this.userName, this.email, this.phone, this.password, this.address);
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (!(object instanceof User other)) {
            return false;
        }

        return  other.userName  .equals(this.userName   )   &&
                other.email     .equals(this.email      )   &&
                other.phone     .equals(this.phone      )   &&
                other.password  .equals(this.password   )   &&
                other.address   .equals(this.address    );
    }
}
