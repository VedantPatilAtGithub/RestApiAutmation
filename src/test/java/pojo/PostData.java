package pojo;

public class PostData {
    String firstName;
    String lastName;
    int subjectId;
    int id;

    public PostData(){}

    public PostData(String firstName, String lastName, int subjectId, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectId = subjectId;
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getId() {
        return id;
    }
}
