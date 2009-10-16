import java.util.Comparator;

/**
 * @author AJ04310
 *
 */
public class ComparateurLargeurDown implements Comparator<Forme>
{
	/**
	 * Retourne l'entier 1 s'il doit interchanger les objets ou non, -1 s'il ne doit pas.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getWidth() < forme2.getWidth())
		{
			value = 1;
		}
		return value;
	}
}
