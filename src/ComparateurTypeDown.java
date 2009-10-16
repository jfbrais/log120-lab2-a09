import java.util.Comparator;

/**
 * @author Gab
 *
 */
public class ComparateurTypeDown implements Comparator<Forme>
{
	/**
	 * Retourne s'il doit interchanger les objets ou non
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int valForme1 = 0;
		int valForme2 = 0;

		if (forme1 instanceof Carre)
			valForme1 = 1;
		else if (forme1 instanceof Rectangle)
			valForme1 = 2;
		else if (forme1 instanceof Cercle)
			valForme1 = 3;
		else if (forme1 instanceof Ovale)
			valForme1 = 4;
		else if (forme1 instanceof Ligne)
			valForme1 = 5;
		
		if (forme2 instanceof Carre)
			valForme2 = 1;
		else if (forme2 instanceof Rectangle)
			valForme2 = 2;
		else if (forme2 instanceof Cercle)
			valForme2 = 3;
		else if (forme2 instanceof Ovale)
			valForme2 = 4;
		else if (forme2 instanceof Ligne)
			valForme2 = 5;

		int value = -1;
		if (valForme1 < valForme2)
		{
			value = 1;
		}
		return value;
	}
}
