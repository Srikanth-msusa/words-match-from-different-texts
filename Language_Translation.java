import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Language_Translation 

{	

	    public static void main(String[] args) throws IOException 
	{
	        
	        FileInputStream file = new FileInputStream("fr-eng sentences.txt");
	        Scanner sc = new Scanner(file);
	        
	        ArrayList<String> engword = new ArrayList<String>();
	        ArrayList<Integer> engnumber = new ArrayList<Integer>();

		 ArrayList<String> frword = new ArrayList<String>();
	        ArrayList<Integer> frnumber = new ArrayList<Integer>();
	        
	    while(sc.hasNextLine())
	    {     		
			String com_line=sc.nextLine();
			String[] lines=com_line.split("\t");
			
		       
		String[] ewords=lines[0].split(" ");

		for(int i=0;i<ewords.length;i++)
		{
			ewords[i]=ewords[i].toLowerCase();
			ewords[i]=ewords[i].replace(".","");
			ewords[i]=ewords[i].replace("!","");
			
		}
		
		    for(int i=0;i<ewords.length;i++)
		    { 

			
			if(engword.contains(ewords[i]))
			{
	                int index1 = engword.indexOf(ewords[i]);
	                engnumber.set(index1, engnumber.get(index1) + 1);
	                }
	            else{
	                engword.add(ewords[i]);
	                engnumber.add(1);
	                }
		     }
	      

		lines[1]=lines[1].replaceAll("\\??","");
		lines[1]=lines[1].replaceAll("\\? ","");
  		String[] fwords=lines[1].split(" ");
		
		
			for(int i=0;i<fwords.length;i++)
			{
				fwords[i]=fwords[i].toLowerCase();
				fwords[i]=fwords[i].replace(".","");
				fwords[i]=fwords[i].replace("!","");
				
			}
		
		    for(int i=0;i<fwords.length;i++)
		    { 			
	           	 if(frword.contains(fwords[i]))
			{
	                int index2 = frword.indexOf(fwords[i]);
	                frnumber.set(index2, frnumber.get(index2) + 1);
	                }
	            else{
	                frword.add(fwords[i]);
	                frnumber.add(1);
	            	}
		    }
	        }

                    sc.close();
	            file.close();


	    SortList(engword,engnumber);
	    SortList(frword,frnumber);
	    printList(engword,frword,engnumber,frnumber);

	


	}
	    
	static void SortList(ArrayList<String> engword, ArrayList<Integer> engnumber)
	{
	        for(int i=0; i < engnumber.size(); i++)
	        {
	            for(int j=0; j < engnumber.size() - 1; j++)
	            {
	                if(engnumber.get(j) < engnumber.get(j+1))
	                {
	                    // Swapping in the number list
	                    int temp = engnumber.get(j);
	                    engnumber.set(j, engnumber.get(j+1));
	                    engnumber.set(j+1, temp);
	                    
	                    // Swapping in the word list
	                    String tpword = engword.get(j);
	                    engword.set(j, engword.get(j+1));
	                    engword.set(j+1, tpword);
	                }
	            }
	            
	        }
	            

	 }

	static void printList(ArrayList<String> engword, ArrayList<String> frword,ArrayList<Integer> engnumber,ArrayList<Integer> frnumber)
	{
		for(int k=0;k<50;k++)
	System.out.println(engword.get(k)+" "+engnumber.get(k)+"  has higher frequency matching with : "+frword.get(k)+" "+frnumber.get(k));

	}

}