package Library.members;

public class Member {
    String name;
    int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public void displayMember() {
        System.out.println("Member Name: " + name);
        System.out.println("Member ID: " + memberId);
    }
}
