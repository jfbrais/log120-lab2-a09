import java.util.Comparator;


public class ComparateurLargeurDown implements Comparator<Forme>
{
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
