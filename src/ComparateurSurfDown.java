import java.util.Comparator;

public class ComparateurSurfDown implements Comparator<Forme>
{
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getAire()<forme2.getAire())
		{
			value = 1;
		}
		return value;
	}
}
