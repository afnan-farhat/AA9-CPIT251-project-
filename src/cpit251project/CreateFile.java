/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

/**
 *
 * @author Afnan
 */
public class CreateFile {

    private String IdeaName;
    private String description;
    private String OwnerName;
    private boolean favoriteState;
    private String state;

    CreateFile() {
    }

    CreateFile(String IdeaName, String description, String OwnerName) {
        this.IdeaName = IdeaName;
        this.description = description;
        this.OwnerName = OwnerName;
        this.favoriteState = false;
        this.state = "waiting";
    }

    CreateFile(String IdeaName, String description, String OwnerName, boolean favoriteState, String state) {
        this.IdeaName = IdeaName;
        this.description = description;
        this.OwnerName = OwnerName;
        this.favoriteState = favoriteState;
        this.state = state;
    }

    public String getIdeaName() {
        return IdeaName;
    }

    public String getDescription() {
        return description;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public boolean getFavoriteState() {
        return favoriteState;
    }

    public String getState() {
        return state;
    }

    public void setIdeaName(String IdeaName) {
        this.IdeaName = IdeaName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public void setFavoriteState(boolean favoriteState) {
        this.favoriteState = favoriteState;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void ChangeFavoriteIdea() {
        if (getFavoriteState() == false) {
            setFavoriteState(true);
        } else {
            System.out.println("Already in favorite place");
        }
    }

    public void ChangeStateIdea() {
        if (getState().equalsIgnoreCase("waiting")) {
            setState("Accept");
        } else if (getState().equalsIgnoreCase("Accept")) {
            System.out.println("The idea has been accepted");
        } else {
            System.out.println("The idea wss Reject");
        }
    }

    @Override
    public String toString() {
        return "Idea: " + IdeaName + "\n" + "description: " + description + "\nOwnername: " + OwnerName + "\nState: "
                + state + "\nFavorite: " + favoriteState + "\n";
    }

}
