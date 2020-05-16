/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author Lukas Langrock
 * @version 16-05-2020
 */
public class CD
{
    public String title;
    public String artist;
    public int year;
    private String DRM_protection_key;

    /**
     * Konstruktor für Objekte der Klasse CD
     */
    public CD(String pTitle, String pArtist, int pYear)
    {
        title = pTitle;
        artist = pArtist;
        year = pYear;
        
        AddDRMProtection();
    }
    
    public void AddDRMProtection()
    {
        // very secure private key that is used for all songs
        // TODO: https://www.passwordrandom.com/query?command=password
        DRM_protection_key = "d6M3Bx4q2Rx4au3SQQcuxeLnfkugGKzQ";
    }
}
