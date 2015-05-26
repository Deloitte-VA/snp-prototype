package com.github.jlgrock.snp.web.resources.query;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

@SuppressWarnings("serial")
public class QueryParamParserTest {
	
//	private QueryParamBean queryParamBean;
//
//	@BeforeMethod
//	public void setUp() {
//		queryParamBean = new QueryParamBean();
//	}
	
	@Test
	public void parseLimitEmptyListTest() {
		int limit = QueryParamParser.parseLimit(new ArrayList<String>());
		assertEquals(limit, QueryConstants.LIMIT_PARAM_DEFAULT);
	}
	
	@Test
	public void parseLimitNullListTest() {
		int limit = QueryParamParser.parseLimit(null);
		assertEquals(limit, QueryConstants.LIMIT_PARAM_DEFAULT);
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseLimitNegativeValueTest() {
		QueryParamParser.parseLimit(new ArrayList<String>() {{add("-1");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseLimitZeroValueTest() {
		QueryParamParser.parseLimit(new ArrayList<String>() {{add("0");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseLimitMultipleValuesTest() {
		QueryParamParser.parseLimit(new ArrayList<String>() {{add("36"); add("42");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseLimitAlphaValueTest() {
		QueryParamParser.parseLimit(new ArrayList<String>() {{add("a");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseLimitAlphaNumericValueTest() {
		QueryParamParser.parseLimit(new ArrayList<String>() {{add("1a");}});
	}
	
	@Test
	public void parseLimitTest() {
		int limit = QueryParamParser.parseLimit(new ArrayList<String>() {{add("36");}});
		assertEquals(limit, 36);
	}
	
	@Test
	public void parseOffsetEmptyListTest() {
		int offset = QueryParamParser.parseOffset(new ArrayList<String>());
		assertEquals(offset, QueryConstants.OFFSET_PARAM_DEFAULT);
	}
	
	@Test
	public void parseOffsetNullListTest() {
		int offset = QueryParamParser.parseOffset(null);
		assertEquals(offset, QueryConstants.OFFSET_PARAM_DEFAULT);
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseOffsetNegativeValueTest() {
		QueryParamParser.parseOffset(new ArrayList<String>() {{add("-1");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseOffsetMultipleValuesTest() {
		QueryParamParser.parseOffset(new ArrayList<String>() {{add("36"); add("42");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseOffsetAlphaValueTest() {
		QueryParamParser.parseOffset(new ArrayList<String>() {{add("a");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseOffsetAlphaNumericValueTest() {
		QueryParamParser.parseOffset(new ArrayList<String>() {{add("1a");}});
	}
	
	@Test
	public void parseOffsetTest() {
		int offset = QueryParamParser.parseOffset(new ArrayList<String>() {{add("36");}});
		assertEquals(offset, 36);
	}
	
	@Test
	public void parseSortEmptyListTest() {
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>());
		assertNotNull(sort);
		assertEquals(sort.isEmpty(), true);
	}
	
	@Test
	public void parseSortNullListTest() {
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(null);
		assertNotNull(sort);
		assertEquals(sort.isEmpty(), true);
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMissingFieldTest() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add(":ASC");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMissingDirectionTest() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add("abc:");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMissingColonTest() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add("abc?ASC");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMissingColon2Test() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add("abc:ASC, def$DESC");}});
	}

	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMissingValueTest() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add("abc:ASC,, def:DESC");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMissingValueBlankspaceTest() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add("abc:ASC, , def:DESC");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseSortMultipleValuesTest() {
		QueryParamParser.parseSort(new ArrayList<String>() {{add("abc:ASC"); add("def:DESC");}});
	}
	
	@Test
	public void parseSortAlphaAscTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc", QuerySortDirection.ASC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc:ASC");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortAlphaDescTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc", QuerySortDirection.DESC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc:DESC");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortAlpha2Test() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc", QuerySortDirection.ASC); put("def", QuerySortDirection.DESC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc:ASC, def:DESC");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortTrailingCommaTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc", QuerySortDirection.ASC); put("def", QuerySortDirection.DESC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc:ASC, def:DESC,");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortTrailingCommaWithBlankspaceTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc", QuerySortDirection.ASC); put("def", QuerySortDirection.DESC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc:ASC, def:DESC, ");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortAlphaNumericTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("aBc123", QuerySortDirection.DESC); put("123Abc", QuerySortDirection.DESC); 
				put("123", QuerySortDirection.ASC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("aBc123:DESC, 123Abc:DESC, 123:ASC");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortAlphaNumericMixedCaseDirectionTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc123", QuerySortDirection.DESC); put("123abc", QuerySortDirection.DESC); 
				put("123", QuerySortDirection.ASC); put("abc", QuerySortDirection.ASC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc123:desc, 123abc:DeSC, 123:asc, abc:Asc");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseSortAlphaNumericWithAndWithoutWhitespaceTest() {
		Map<String, QuerySortDirection> expected = new LinkedHashMap<String, QuerySortDirection>() 
				{{put("abc123", QuerySortDirection.DESC); put("123abc", QuerySortDirection.DESC); 
				put("123", QuerySortDirection.ASC); put("abc", QuerySortDirection.ASC);}};
		Map<String, QuerySortDirection> sort = QueryParamParser.parseSort(new ArrayList<String>() 
				{{add("abc123: desc,123abc : DeSC, 123: asc,abc :Asc");}});
		assertEquals(sort, expected);
	}
	
	@Test
	public void parseFieldsEmptyListTest() {
		List<String> fields = QueryParamParser.parseFields(new ArrayList<String>());
		assertNotNull(fields);
		assertEquals(fields.isEmpty(), true);
	}
	
	@Test
	public void parseFieldsNullListTest() {
		List<String> fields = QueryParamParser.parseFields(null);
		assertNotNull(fields);
		assertEquals(fields.isEmpty(), true);
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseFieldsMissingValueTest() {
		QueryParamParser.parseFields(new ArrayList<String>() {{add("abc,, def");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseFieldsMissingValueBlankspaceTest() {
		QueryParamParser.parseFields(new ArrayList<String>() {{add("abc, , def");}});
	}
	
	@Test(expectedExceptions = QueryParamException.class)
	public void parseFieldsMultipleValuesTest() {
		QueryParamParser.parseFields(new ArrayList<String>() {{add("abc"); add("def");}});
	}

	@Test
	public void parseFieldsValueTest() {
		List<String> expected = new ArrayList<String>() {{add("abc");}};
		List<String> fields = QueryParamParser.parseFields(new ArrayList<String>() {{add("abc");}});
		assertEquals(fields, expected);
	}
	
	@Test
	public void parseFieldsTrailingCommaTest() {
		List<String> expected = new ArrayList<String>() {{add("abc");}};
		List<String> fields = QueryParamParser.parseFields(new ArrayList<String>() {{add("abc,");}});
		assertEquals(fields, expected);
	}
	
	@Test
	public void parseFieldsTrailingCommaWithBlankspaceTest() {
		List<String> expected = new ArrayList<String>() {{add("abc");}};
		List<String> fields = QueryParamParser.parseFields(new ArrayList<String>() {{add("abc, ");}});
		assertEquals(fields, expected);
	}
	
	@Test
	public void parseFieldsMultiValueWithAndWithoutWhitespaceTest() {
		List<String> expected = new ArrayList<String>() {{add("abc"); add("123"); add("def");}};
		List<String> fields = QueryParamParser.parseFields(new ArrayList<String>() {{add("abc, 123,def");}});
		assertEquals(fields, expected);
	}
}
