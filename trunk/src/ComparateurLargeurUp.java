import java.util.Comparator;


public class ComparateurLargeurUp implements Comparator<Forme>
{
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getWidth() < forme2.getNseq())
		{
			value = 1;
		}
		return value;
	}
}