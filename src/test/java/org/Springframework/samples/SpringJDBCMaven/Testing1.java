package org.Springframework.samples.SpringJDBCMaven;

//import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class Testing1 extends TestCase {
	Goal g2=new Goal();
	@Test
	public void check(){	
	assertEquals("in operator",g2.operator("anu"));
	}
	@Test
    void test2() {
    	assertEquals("selectinfo checked",g2.selectInfo("bansal"));
    }
}
