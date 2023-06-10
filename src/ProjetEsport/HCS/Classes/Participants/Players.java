package ProjetEsport.HCS.Classes.Participants;
import java.util.*;


public class Players extends Members implements Comparable<Players>, Cloneable
{
    private Status Role;

    public Players(){
        super();
    }
    public Players(String Pseudo, boolean isStarter, String location){
        super();
        this.Pseudo = Pseudo;
        this.setNationality(location);

        if(isStarter)
            this.Role = Status.STARTER;
        else
            this.Role = Status.SUBSTITUTE;
    }
    public Players(int Id, String Pseudo,boolean isStarter, String location){
        super(Id);
        this.Pseudo = Pseudo;
        this.setNationality(location);

        if(isStarter)
            this.Role = Status.STARTER;
        else
            this.Role = Status.SUBSTITUTE;
    }

    /****************************** Get Members Function ************************************/
    public Status getRole() {
        return Role;
    }

    /****************************************************************************************/



    /****************************** Set Members Function ************************************/

    public Players setRole(Status role) {
        Role = role;
        return this;
    }

    /***************************************************************************************/


    @Override
    public int compareTo(Players o) {
        return this.Pseudo.compareTo(o.Pseudo);
    }

    @Override
    public String toString() {
        return String.format("*\t%04d [%-10s] %-20s - %s [%s]\n",this.getID(), this.getPseudo(), this.getNationality(), this.getRegisterTime(), (this.getRole() == Status.STARTER)? "STARTER" : "SUBSTITUTE");
    }
    @Override
    public Players clone() {
        try
        {
            return (Players) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Players players = (Players) o;
        return Role == players.Role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Role);
    }

    public enum Status{
        STARTER,
        SUBSTITUTE
    }


    public static void main(String argv[]){
        Players p = new Players("PTG",true,"Be");

        Players q = p.clone();

        System.out.println(p);
        System.out.println(q);


        // demande d'égalité par reference/zone memoire (est ce qu'il s'agit du meme objet)
        if(p == q)
            System.out.println("Sont egaux");
        else
            System.out.println("ne sont pas egaux");


        // demande d'égalité par valeur
        if(p.equals(q))
            System.out.println("Sont egaux");
        else
            System.out.println("ne sont pas egaux");
    }

}
