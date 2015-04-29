package com.github.jlgrock.snp.core.data;

public class stub {
	
	public class SimplePricingService implements PricingService
	{ 
	 PricingRepository repository;

	 public SimplePricingService(PricingRepository pricingRepository) {
	  this.repository = pricingRepository;
	 }

	 @Override
	 public Price priceTrade(Trade trade) {
	  return repository.getPriceForTrade(trade);
	 }

	 @Override
	 public Price getTotalPriceForTrades(Collection<trade> trades) {
	  Price totalPrice = new Price();
	  for (Trade trade : trades)
	  {
	   Price tradePrice = repository.getPriceForTrade(trade);
	   totalPrice = totalPrice.add(tradePrice);
	  }
	  return totalPrice;
	 }
	</trade>
	
	
	
	
	
	@Test
	public void testGetHighestPricedTrade() throws Exception {
	  Price price1 = new Price(10); 
	  Price price2 = new Price(15);
	  Price price3 = new Price(25);
	 
	  PricingRepository pricingRepository = mock(PricingRepository.class);
	  when(pricingRepository.getPriceForTrade(any(Trade.class)))
	    .thenReturn(price1, price2, price3);
	   
	  PricingService service = new SimplePricingService(pricingRepository);
	  Price highestPrice = service.getHighestPricedTrade(getTrades());
	  
	  assertEquals(price3.getAmount(), highestPrice.getAmount());
	}
	
	
	
	
	
	@Test(expected=TradeNotFoundException.class)
	public void testInvalidTrade() throws Exception {

	  Trade trade = new FixtureHelper().getTrade();
	  TradeRepository tradeRepository = mock(TradeRepository.class);

	  when(tradeRepository.getTradeById(anyLong()))
	    .thenThrow(new TradeNotFoundException());

	  TradingService tradingService = new SimpleTradingService(tradeRepository);
	  tradingService.getTradeById(trade.getId());
	}
	
}
