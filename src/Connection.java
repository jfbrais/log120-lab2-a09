/******************************************************
 Cours :             LOG120
 Session :           Saison automne 2009
 Groupe :            03
 Projet :            Laboratoire #1
 Étudiant(e)(s) :    Gabriel Desmarais
 Code(s) perm. :     DESG24078908
 Professeur :        Jocelyn Benoît
 Chargé de labo.:    Vincent Carrier
 					 Yanick Rochon
 Nom du fichier :	 Connection.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Connection
{
	private Socket connect;
	private PrintWriter output;
	private BufferedReader input;

	/**
	 * Connection à un nouveau serveur
	 * 
	 * @return boolean
	 */
	public boolean seConnecter()
	{
		String serverIP;
		Integer port;
		Boolean wrongServer = false;
		do
		{
			if (wrongServer)
			{
				JOptionPane.showMessageDialog(null,
						"Enter the server AND the port!");
			}
			serverIP = JOptionPane.showInputDialog("What is your server?",
					"localhost:10000");
			wrongServer = true;
		}
		while (serverIP == null || serverIP.equals("")
				|| serverIP.indexOf(":") == -1);

		port = Integer.parseInt(serverIP.substring(serverIP.indexOf(":") + 1));

		serverIP = serverIP.substring(0, serverIP.indexOf(":"));

		try
		{
			/* Ouverture des sockets et des streams */
			connect = new Socket(InetAddress.getByName(serverIP), port);
			output = new PrintWriter(connect.getOutputStream());
			input = new BufferedReader(new InputStreamReader(connect
					.getInputStream()));
			return true;
		}
		catch (UnknownHostException unknownHost)
		{
			JOptionPane.showMessageDialog(null, "No server found.\nPlease check the name.");
		}
		catch (IOException ioException)
		{
			JOptionPane.showMessageDialog(null, "No server started.\nPlease check the port.");
		}
		return false;
	}

	/**
	 * Déconnection du serveur avec envoie de END
	 * 
	 * @return boolean
	 */
	public boolean seDeconnecter()
	{
		try
		{
			output.println("END");
			output.flush();
			output.close();
			input.close();
			connect.close();
			return false;
		}
		catch (IOException ioException)
		{
			JOptionPane.showMessageDialog(null, "Cannot close connection.");
		}
		return true;
	}

	/**
	 * Requête d'une forme au serveur
	 * 
	 * @return cmd
	 */
	public String getForme()
	{
		String cmd = null;
		try
		{
			input.readLine();
		}
		catch (IOException e1)
		{
			JOptionPane.showMessageDialog(null, "Cannot receive shape.");
		}

		output.println("GET");
		output.flush();

		try
		{
			cmd = input.readLine();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Cannot receive shape.\nServer is probably down/closed.");
			return null;
		}

		return cmd;
	}
}
