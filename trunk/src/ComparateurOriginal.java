import java.util.Comparator;

/**
 * @author Gab
 *
 */
public class ComparateurOriginal implements Comparator<Forme>
{
	/**
	 * Retourne s'il doit interchanger les objets ou non
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getOriginal()>forme2.getOriginal())
		{
			value = 1;
		}
		return value;
	}
}
