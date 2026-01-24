// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";
	private Random rand = new Random();

	public MadLib()
	{
		verbs.add("run");
		nouns.add("Jonathan Leohr");
		adjectives.add("purple");
		story = "Jonathan Leohr run down the purple road.";
	}

	public MadLib(String fileName) throws IOException
	{
		//load stuff
		loadNouns();
		loadVerbs();
		loadAdjectives();
		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner chopper = new Scanner(new File(fileName));

			//While there is more of the story, read in the word/symbol
			while(chopper.hasNext())
			{
				//If what was read in is one of the symbols, find a random
				//word to replace it.
				if(chopper.next().equals("#"))
				{
					story += getRandomNoun();
				}
				else if(chopper.next().equals("@"))
				{
					story += getRandomVerb();
				}
				else if(chopper.next().equals("&"))
				{
					story += getRandomAdjective();
				}
				else
					story += chopper.next();
			}


		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns() throws IOException
	{
		try
		{
			Scanner nounReader = new Scanner(new File("nouns.dat"));

			while(nounReader.hasNext())
			{
				nouns.add(nounReader.nextLine());
			}
			nounReader.close();
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs() throws IOException
	{
		try
		{
			Scanner verbReader = new Scanner(new File("verbs.dat"));

			while(verbReader.hasNext()) 
			{
				verbs.add(verbReader.nextLine());
			}
			verbReader.close();
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives() throws IOException
	{
		try
		{
			Scanner adjReader = new Scanner(new File("adjectives.dat"));

			while(adjReader.hasNext())
			{
				adjectives.add(adjReader.nextLine());
			}
			adjReader.close();
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb() 
	{
		int randomVerb = rand.nextInt(verbs.size());

		return verbs.get(randomVerb);
	}

	public String getRandomNoun() 
	{
		int randomNoun = rand.nextInt(nouns.size());

		return nouns.get(randomNoun);
	}

	public String getRandomAdjective() 
	{
		int randomAdj = rand.nextInt(adjectives.size());

		return adjectives.get(randomAdj);
	}

	public String toString()
	{
		return "";
	}
}