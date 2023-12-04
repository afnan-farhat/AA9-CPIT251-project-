
package cpit251project;


public class Ideas{

   private static String IdeaName;
    private static String description;
    private static String OwnerName;
    private static boolean favoriteState;
    private static String state;

    Ideas() {
    }

    Ideas(String IdeaName, String description, String OwnerName) {
        this.IdeaName = IdeaName;
        this.description = description;
        this.OwnerName = OwnerName;
        this.favoriteState = false;
        this.state = "waiting";
    }

    Ideas(String IdeaName, String description, String OwnerName, boolean favoriteState, String state) {
        this.IdeaName = IdeaName;
        this.description = description;
        this.OwnerName = OwnerName;
        this.favoriteState = favoriteState;
        this.state = state;
    }


    public  String getIdeaName() {
        return IdeaName;
    }

    public  String getDescription() {
        return description;
    }

    public  String getOwnerName() {
        return OwnerName;
    }

    public  void setIdeaName(String IdeaName) {
        this.IdeaName = IdeaName;
    }

    public  void setDescription(String description) {
        this.description = description;
    }

    public  void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public static boolean getFavoriteState() {
        return favoriteState;
    }

    public static String getState() {
        return state;
    }

    public  void setFavoriteState(boolean favoriteState) {
        this.favoriteState = favoriteState;
    }

    public  void setState(String state) {
        this.state = state;
    }
}
