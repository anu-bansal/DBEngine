package org.Springframework.samples.SpringJDBCMaven;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
public class Testing1  {
    @Test
    public void check1() {
    	Goal obj2=new Goal();
		String name="select venue from ipl.csv";
		ArrayList<String> resulttoken1= new ArrayList<String>();
		resulttoken1.add("select");
		resulttoken1.add("venue");
		resulttoken1.add("from");
		resulttoken1.add("ipl.csv");
		assertEquals(resulttoken1,obj2.token1(name));
    }
    @Test
	public void check2(){		
		Goal obj2=new Goal();
		String name="select venue from ipl.csv";
		String resultfname=obj2.fname(name);
		assertTrue(resultfname.equals("ipl.csv"));}
	@Test
	public void check3(){			
		Goal obj2=new Goal();
		String name="select venue from ipl.csv where venue = mohali";
		String resultbasefilter=obj2.basefilter(name);
		assertTrue(resultbasefilter.equals("select venue from ipl.csv "));
    }
	@Test
	public void check4(){			
		Goal obj2=new Goal();
		String name="select venue from ipl.csv where venue = mohali";
		String resultendfilter=obj2.endfilter(name);
		assertTrue(resultendfilter.equals("venue = mohali"));
	}
	@Test
	public void check7(){			
		Goal obj2=new Goal();
		String name="select venue from ipl.csv where venue = mohali";
		String resultconditions=obj2.conditions(name);
		assertTrue(resultconditions.equals("venue = mohali"));
	}
	@Test
	public void check5(){			
		Goal obj2=new Goal();
		String name="select venue from ipl.csv where venue = mohali order by team";
		String resultorder=obj2.order(name);
		assertTrue(resultorder.equals("team"));
	}
	@Test
	public void check6(){			
		Goal obj2=new Goal();
		String name="select venue from ipl.csv where venue = mohali group by team";
		String resultgroup=obj2.group(name);
		assertTrue(resultgroup.equals("team"));
	}
}
