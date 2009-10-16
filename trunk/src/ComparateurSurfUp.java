import java.util.Comparator;

/**
 * @author Gab
 *
 */
public class ComparateurSurfUp implements Comparator<Forme>
{
	/**
	 * Retourne l'entier 1 s'il doit interchanger les objets ou non, -1 s'il ne doit pas.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getAire()>forme2.getAire())
		{
			value = 1;
		}
		return value;
	}
}
