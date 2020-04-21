public class CD {
    private String title;
    private String artist;
    private int year;

    public CD(String pTitle, String pArtist, int pYear){
        title = pTitle;
        artist = pArtist;
        year = pYear;
    }

    public String GetTitle(){
        return title;
    }
    public String GetArtist(){
        return artist;
    }
    public int GetYear(){
        return year;
    }
    public void SetTitle(String pTitle){
        title = pTitle;
    }
    public void SetArtist(String pArtist){
        artist = pArtist;
    }
    public void SetYear(int pYear){
        year = pYear;
    }
}