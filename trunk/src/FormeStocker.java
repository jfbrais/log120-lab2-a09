import java.util.Comparator;

/******************************************************
 * Cours : LOG120 Session : Saison automne 2009 Groupe : 03 Projet : Laboratoire
 * #1 Étudiant(e)(s) : Gabriel Desmarais Code(s) perm. : DESG24078908 Professeur
 * : Jocelyn Benoît Chargé de labo.: Vincent Carrier Yanick Rochon Nom du
 * fichier : FormeStocker.java Date créée : 2009-09-29 Date dern. modif. :
 * 2009-09-29
 * 
 ******************************************************* 
 * Historique des modifications
 ******************************************************* 
 * 2009-09-29 : Status Initial
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
		int number = 1;
		while (last.getNext() != null)
		{
			last = last.getNext();
			number++;
		}

		if (number > 9)
		{
			head = head.getNext();
			head.setPrevious(null);
		}
		last.setNext(newForme);
		newForme.setPrevious(last);
	}

	public Forme getForme(int emplacement)
	{
		Forme node = head;
		for (int i = 0; i < emplacement; i++)
		{
			if (node != null)
				node = node.getNext();
			else
				return null;
		}
		return node;
	}

	public void sort(Comparator<Forme> comparateur)
	{
		Forme current, prev, next;
		for (int i = 0; i < 10; i++)
		{
			current = head;
			prev = null;
			next = current.getNext();
			for (int j = 0; j < 10; j++)
			{
				if (next != null)
				if (comparateur.compare(current, next)==1)
				{
					if (current == head)
					{
						head = next;
						current.setPrevious(next);
						next.setPrevious(null);
						current.setNext(next.getNext());
						next.getNext().setPrevious(current);
						next.setNext(current);
						prev = next;
						next = current.getNext();
					}
					else
					{
						if (next.getNext() == null)
						{
							prev.setNext(next);
							next.setPrevious(prev);
							next.setNext(current);
							current.getPrevious().setNext(next);
							current.setPrevious(next);
							current.setNext(null);

							prev = next;
							next = current.getNext();
						}
						else
						{
							prev.setNext(next);
							current.setNext(next.getNext());
							next.setPrevious(prev);
							next.getNext().setPrevious(current);
							next.setNext(current);
							current.setPrevious(next);

							prev = next;
							next = current.getNext();
						}
					}
				}
				else
				{
					prev = current;
					current = next;
					next = current.getNext();
				}
			}
		}
		
		Forme node = head;
		for (int i = 0; i < 10; i++)
		{
			node.setNewPoint(i*40);
			node = node.getNext();
		}
		
		
		node = head;
		for (int i = 0; i < 10; i++)
		{
			System.out.println(node.getNseq());
			node = node.getNext();
		}
	}
}
