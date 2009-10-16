import java.util.Comparator;


public class ComparateurHauteurUp implements Comparator<Forme>
{
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getHeight() > forme2.getHeight())
		{
			value = 1;
		}
		return value;
	}
}
