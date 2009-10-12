/******************************************************
 Cours :             LOG120
 Session :           Saison automne 2009
 Groupe :            03
 Projet :            Laboratoire #1
 �tudiant(e)(s) :    Gabriel Desmarais
 Code(s) perm. :     DESG24078908
 Professeur :        Jocelyn Beno�t
 Charg� de labo.:    Vincent Carrier
 					 Yanick Rochon
 Nom du fichier :	 FormeStocker.java 					 
 Date cr��e :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

public class FormeStocker
{
	private Forme head;
	
	public void add(Forme newForme)
	{
		Forme last;
		if (head == null)
		{
			head = newForme;
			return;
		}
		
		last = head;
		int number=1;
		while (last.getNext()!=null)
		{
			last = last.getNext();
			number++;
		}
		
		if (number>9)
		{
			head = head.getNext();
		}
		last.setNext(newForme);
		newForme.setPrevious(last);
	}
	
	public Forme getForme(int emplacement)
	{
		Forme node = head;
		for (int i=0;i<emplacement;i++)
		{
			if (node != null)
				node = node.getNext();
			else
				return null;
		}
		return node;
	}
}
