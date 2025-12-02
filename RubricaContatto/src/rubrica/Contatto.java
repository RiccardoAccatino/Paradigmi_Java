package rubrica;

import java.util.ArrayList;

public class Contatto {
	private String email="";
	private String nome="";
	private ArrayList<String> numTel; 
	public Contatto(String email, String nome)
	{
		this.setEmail(email);
		this.setNome(nome);
		numTel=new ArrayList<String>();
		
	}
	
	public Contatto(String email)
	{
		this.setEmail("");
		this.setNome("");
		numTel=new ArrayList<String>();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
	
	public boolean inserisciNumTel(String num)
	{
		if(numTel.contains(num)==true)
		{
			return false;
		}else
		{
			numTel.add(num);
			return true;
		}
	}
	
	public boolean eliminaNumTel(String num)
	{
		if(numTel.contains(num)==true)
		{
			numTel.remove(num);
			return true;
		}else
		{
			return false;
		}
	}
	
	public String numTel()
	{
		return numTel.toString();
	}
	
	public boolean matchNome(String str)
	{
		if(nome.contains(str)==true)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public boolean matchEmail(String str)
	{
		if(email.contains(str)==true)
		{
			return true;
		}else
		{
			return false;
		}	
	}
	
	public String toString()
	{
		return Contatto.class.toString();
	}

}
