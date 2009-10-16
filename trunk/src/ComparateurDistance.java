import java.util.Comparator;

public class ComparateurDistance implements Comparator<Forme>
{
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getDist()>forme2.getDist())
		{
			value = 1;
		}
		return value;
	}
}