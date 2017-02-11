package csemall;

/**
 * Created by jihun on 2017. 2. 10..
 */
public class Offer {
    private int id;
    private String email;
    private String name;
    private String text;

    public Offer() {

    }

    public Offer(String email, String name, String text) {
        this.email = email;
        this.name = name;
        this.text = text;
    }

    public Offer(int id, String email, String name, String text) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
