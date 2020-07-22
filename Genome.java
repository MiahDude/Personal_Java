/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac Genome.java
 *  Execution:    java Genome
 *
 *  An incomplete implementation of a genome data type.
 *
 ************************************************************************************************************/

public class Genome
{
	private String gene;
	
	public Genome(String gene)
	{
		this.gene = gene;
	}
	
	public String toString()
	{
		return gene;
	}
	
	public void addNucleotide(char nucleotide)
	{
		if (nucleotide == 'A' || nucleotide == 'C' || nucleotide == 'G' || nucleotide == 'T')
			gene = gene + nucleotide;
		else throw new RuntimeException("Illegal nucleotide");
	}
	
	public char nucleotideAt(int i)
	{
		if (i < gene.length())
			return gene.charAt(i);
		else throw new RuntimeException("Genome out of bounds");
	}
	
	public int length()
	{
		return gene.length();
	}
	
	public static void main(String[] args)
	{
		Genome gene = new Genome("ATGC");
		System.out.println(gene);
		gene.addNucleotide('A');
		System.out.println(gene.length());
		System.out.println(gene.nucleotideAt(4));
		System.out.println(gene);
	}
}