import java.util.Comparator;

public class ComparateurOriginal implements Comparator<Forme>
{
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
