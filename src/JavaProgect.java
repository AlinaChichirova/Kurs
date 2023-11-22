import java.util.LinkedList;

public class JavaProgect {
    public static void main(String[] args) {
        LinkedList<Member> members = new LinkedList<Member>();
        members.add(new Member('M', 1, "Anna", 1000));
        members.add(new MultiClubMember('M', 2, "Igor", 1200, 100));
        members.add(new SingleClubMember('S', 3, "David", 900, "Jupiter"));
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        int choice;

        choice = mm.getChoice();
        {
            if (choice == 1) {
                mm.addMembers(members);
                fh.appendFile(String.valueOf(members));
            } else if (choice == 2) {
                mm.removeMember(members);
                fh.overwriteFile(members);
            } else if (choice == 3) {
                mm.printMemberInfo(members);
            }else
            System.out.println("exit");
        }
    }
}

