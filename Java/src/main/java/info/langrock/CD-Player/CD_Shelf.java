
/**
 * Beschreiben Sie hier die Klasse CD_Shelf.
 * 
 * @author Lukas Langrock 
 * @version 16-05-2020
 */
public class CD_Shelf
{
    private CD CD_Collection[];

    /**
     * Konstruktor für Objekte der Klasse CD_Shelf
     */
    public CD_Shelf(int amount, boolean awesome)
    {
        CD_Collection = new CD[amount];
        if (awesome)
        {
            for (int i = 0; i < amount; i++)
            {
                CD_Collection[i] = new CD("Never Gonna Give You Up", "Rick Astley", 1987);
            }
        }
    }
    
    //fancy solution to dynamically make your shelf bigger
    //public void AddCD_fancypants(String pTitle, String pArtist, int pYear)
    //{
    //    CD newCD = new CD(pTitle, pArtist, pYear);
    //    CD CD_Collection_new[] = new CD[CD_Collection.length + 1];
    //    
    //    for (int i = 0; i < CD_Collection.length; i++)
    //    {
    //        CD_Collection_new[i] = CD_Collection[i];
    //    }
    //    
    //    CD_Collection_new[CD_Collection_new.length] = newCD;
    //}
    
    public void AddCD(String pTitle, String pArtist, int pYear)
    {
        CD newCD = new CD(pTitle, pArtist, pYear);
        int newCD_index = 0;
        while(CD_Collection[newCD_index] != null) { newCD_index++; }
        int real_newCD_index = newCD_index + 1;
        CD_Collection[newCD_index] = newCD;
        
        System.out.println("Added CD to shelf at index " + real_newCD_index + " of "+ CD_Collection.length);
    }
    
    public void DeleteCD(int index)
    {
        int internal_index = index - 1;
        CD_Collection[internal_index] = null;
        System.out.println("Removed CD with index " + index + " from the shelf");
    }
    
    public void CatCDs()
    {
        System.out.println("Running index lookup against all results...");
        for (int i = 0; i < CD_Collection.length; i++)
        {
            int real_index = i + 1;
            try { System.out.println("Index " + real_index + "/" + CD_Collection.length + ": '" + CD_Collection[i].title + "' by '" + CD_Collection[i].artist + "' from " + CD_Collection[i].year); }
            catch(Exception e) { System.out.println("Index " + real_index + "/" + CD_Collection.length + ": empty"); }
        }
        System.out.println("Index lookup of " + CD_Collection.length + " CDs done!");
    }
    
    public void FindCDs(String search)
    {
        System.out.println("Running index lookup against matches with '" + search + "'...");
        for (int i = 0; i < CD_Collection.length; i++)
        {
            int real_index = i + 1;
            
            try {
                if (CD_Collection[i].title.contains(search) || CD_Collection[i].artist.contains(search) || String.valueOf(CD_Collection[i].year).contains(search))
                {
                    System.out.println("Index " + real_index + "/" + CD_Collection.length + ": '" + CD_Collection[i].title + "' by '" + CD_Collection[i].artist + "' from " + CD_Collection[i].year);
                }
            }
            catch(Exception e) {}
        }
        System.out.println("Index lookup of " + CD_Collection.length + " CDs done!");
    }
}
