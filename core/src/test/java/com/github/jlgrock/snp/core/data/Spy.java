package com.github.jlgrock.snp.core.data;

import org.mockito.Spy;

public class spy {

	@Spy
	List<string> listSpy = new ArrayList<string>();

	@Test
	public void testSpyReturnsRealValues() throws Exception {
	 String s = "dobie";
	 listSpy.add(new String(s));

	 verify(listSpy).add(s);
	 assertEquals(1, listSpy.size());
	}
	</string></string>
	
	
	
	
	
	@Mock
	List<string> listMock = new ArrayList<string>();

	@Test
	public void testMockReturnsZero() throws Exception {
	 String s = "dobie";

	 listMock.add(new String(s));

	 verify(listMock).add(s);
	 assertEquals(0, listMock.size());
	}
	</string></string>
	
	
	
	
	
	@Test(expected=RuntimeException.class)
	public void testSpyReturnsStubbedValues() throws Exception {
	 listSpy.add(new String("dobie"));  
	 assertEquals(1, listSpy.size());
	  
	 when(listSpy.get(anyInt())).thenThrow(new RuntimeException());
	 listSpy.get(0);
	}
	
	
	
	
	
	public void testSpyReturnsStubbedValues2() throws Exception {
		 int size = 5;
		 when(listSpy.size()).thenReturn(1, size);
		  
		 int mockedListSize = listSpy.size();
		 assertEquals(1, mockedListSize);
		  
		 mockedListSize = listSpy.size();
		 assertEquals(5, mockedListSize);  

		 mockedListSize = listSpy.size();
		 assertEquals(5, mockedListSize);  
		} 
	
}
