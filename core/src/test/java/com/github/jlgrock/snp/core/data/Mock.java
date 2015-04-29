package com.github.jlgrock.snp.core.data;

public class mock {

	when(customer.getSurname()).thenReturn(surname);
	
	
	
	
	
	verify(listMock).add(s);
	
	
	
	
	
	public class SimpleTradingService implements TradingService{

		  TradeRepository tradeRepository;
		  AuditService auditService;
		 
		  public SimpleTradingService(TradeRepository tradeRepository, 
		                              AuditService auditService)
		  {
		    this.tradeRepository = tradeRepository;
		    this.auditService = auditService;
		  }

		  public Long createTrade(Trade trade) throws CreateTradeException {
		  Long id = tradeRepository.createTrade(trade);
		  auditService.logNewTrade(trade);
		  return id;
		}
		  
		  
		  
		  
		  
		  @Mock
		  TradeRepository tradeRepository;
		   
		  @Mock
		  AuditService auditService;
		    
		  @Test
		  public void testAuditLogEntryMadeForNewTrade() throws Exception { 
		    Trade trade = new Trade("Ref 1", "Description 1");
		    when(tradeRepository.createTrade(trade)).thenReturn(anyLong()); 
		    
		    TradingService tradingService 
		      = new SimpleTradingService(tradeRepository, auditService);
		    tradingService.createTrade(trade);
		    
		    verify(auditService).logNewTrade(trade);
		  }
		  
		  
		  
		  
		  
		  verify(auditService).logNewTrade(trade);
		  
}
