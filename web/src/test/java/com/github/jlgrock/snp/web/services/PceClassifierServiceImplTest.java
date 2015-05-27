package com.github.jlgrock.snp.web.services;

public class PceClassifierServiceImplTest {
	//TODO
//	@Mock
//	PceClassifier<LegoEnvelope> assertionClassifier;
//
//	@Mock
//	ClassifiedPceStore cAssertStore;
//
//	@Mock
//	LegoEnvelope assertion;
//
//	@Mock
//	ClassifiedPce cAssertion;
//
//    @BeforeClass
//    public void setUpTests() throws Exception {
//        // Required to make this work on TestNG
//        MockitoAnnotations.initMocks(this);
//    }
//
//	@Test
//	public void testClassifyAssertion() {
//
//		Mockito.when(assertionClassifier.classify(assertion)).thenReturn(cAssertion);
////		Mockito.verify(cAssertStore.save(Mockito.anyLong(), cAssertion));
//
//		String expected = readFile("Assertion_Example_01.xml");
//		PceClassifierServiceLegoImpl classSvc = new PceClassifierServiceLegoImpl(assertionClassifier, cAssertStore);
////		classSvc.classifyAssertion(expected);
//
////		 TODO: need to add to test
//	}
//
//	/**
//	 * Prints the string content read from input stream
//	 * @return content in file
//	 */
//	private String readFile(String xmlFile) {
//		BufferedReader br = null;
//		StringBuilder out = new StringBuilder();
//		try {
//			InputStream in = getClass().getClassLoader().getResourceAsStream(xmlFile);
//	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//	        String line;
//	        while ((line = reader.readLine()) != null) {
//	        	if(!"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>".equals(line.trim())) {
//	        		out.append(line.trim());
//	        	}
//	        }
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null) {
//					br.close();
//				}
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		 return out.toString();
//	}
}
