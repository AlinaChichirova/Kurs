public class SingleClubMember extends Member{
    private String club;
    public SingleClubMember(char memberType, int memberID, String name, double fees, String club) {
        super(memberType, memberID, name, fees);
        this.club=club;
    }
    public String toString() {
        return "SingleClubMember{" +
                "memberType=" + getMemberType() +
                ", memberID=" + getMemberID() +
                ", name='" + getName() + '\'' +
                ", fees=" + getFees() +
                "club=" + club +
                '}';
    }
}
