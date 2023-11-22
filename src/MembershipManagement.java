import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    private final Scanner reader = new Scanner(System.in);
    private final Scanner Name = new Scanner(System.in);

    private int getIntInput() {
        System.out.println("Введите число: ");
        while (!reader.hasNextInt()) {
            reader.next();
            System.out.println("error");
        }
        int nummer = reader.nextInt();
        return nummer;
    }
    private String getStringLina() {
        System.out.println("Введите имя: ");
       String name = Name.nextLine();
        return name;
    }

    private void printClubOptions() {
        System.out.println(("1) Club Mercury"));
        System.out.println(("2) Club Neptune"));
        System.out.println(("3) Club Jupiter"));
        System.out.print(("4) Multi Clubs"));
    }

    public int getChoice() {
        int choice;
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println(" 2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println(" Please select an option (or Enter -1 to quit):");
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        String name = null;
        int club;
        String mem = null;
        double fees = 0;
        int memberID;
        Member mbr = null;
        Calculator<Integer> cal;
        printClubOptions();
        System.out.println("Введите доступный идентификатор клуба");
        club = getIntInput();
        memberID = m.getLast().getMemberID();
       // System.out.println("Введите имя");
        name=getStringLina();

        if (m.isEmpty()) {
            memberID = 1;
        } else {
            memberID = m.getLast().getMemberID() + 1;
        }
        if (club >= 1 && club <= 3) {
            cal = new Calculator<Integer>() {
                @Override
                public double calculateFees(Integer clubID) {
                    if (clubID == 1) {
                        return 900;
                    } else if (clubID == 2) {
                        return 950;
                    } else if (clubID == 3) {
                        return 1000;
                    } else {
                        return -1;
                    }
                }
            };

            fees = cal.calculateFees(club);
            mbr = new Member('g', memberID,name,fees);
            m.add(mbr);
            mem = "Добавлен посетитель: " + mbr.toString();
        System.out.println(mem);
        }

        if (club == 4) {
            cal = (clubID) -> {
                if (clubID == 4) {
                    return 1200;
                } else {
                    return -1;
                }
            };

            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);

            mem = "Добавлен посетитель нескольких клубов: " + mbr.toString();

            System.out.println(mem);
        }

        String memberInfo = "Name: " + name +
                "\nClub: " + club +
                "\nMembership: " + mem +
                "\nFees: " + fees +
                "\nMember ID: " + memberID;
        System.out.println("Новый посетитель: " + memberInfo);

        return memberInfo;
    }

    public void removeMember(LinkedList<Member> list) {
        int memberID;
        System.out.println("Введите посетитяля:");
        memberID = getIntInput();
        for (Member member : list) {
            if (member.getMemberID() == memberID) {
                list.remove(member);
                System.out.println("Удален");
                return;
            }
        }
        System.out.println("Посетитель не найден");
    }public void printMemberInfo(LinkedList<Member> list) {
        int memberID;
        System.out.println("Введите посетитяля:");
        memberID = getIntInput();
        for (Member member : list) {
            if (member.getMemberID() == memberID) {
                System.out.println(member.toString());
                return;
            }
        }
        System.out.println("Посетитель не найден");
    }


}

