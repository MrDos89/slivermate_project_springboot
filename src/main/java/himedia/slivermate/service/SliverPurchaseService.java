package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverPurchaseMapper;
import himedia.slivermate.repository.vo.SliverPurchase;

@Service
public class SliverPurchaseService {
	@Autowired
	private SliverPurchaseMapper sliverPurchaseMapper;
	
	public List<SliverPurchase> selectAllPurchases() {
		List<SliverPurchase> purchases = sliverPurchaseMapper.selectAllPurchases();
		
		return purchases;
	}
	
	public SliverPurchase selectPurchaseById(Long id) {
		SliverPurchase purchase = sliverPurchaseMapper.selectPurchaseById(id);
		
		return purchase;
	}

	public List<SliverPurchase> selectPurchaseByUid(Long uid) {
		List<SliverPurchase> purchases = sliverPurchaseMapper.selectPurchaseByUid(uid);
		
		return purchases;
	}
	
	public SliverPurchase insertPurchase(SliverPurchase purchase) {
		sliverPurchaseMapper.insertPurchase(purchase);
		
		Long id = purchase.getId();
		
		return sliverPurchaseMapper.selectPurchaseById(id);
	}
	
	public SliverPurchase updatePurchase(SliverPurchase purchase) {
		sliverPurchaseMapper.updatePurchase(purchase);
		
		return purchase;
	}
	
	public int deletePurchase(Long id) {
		return sliverPurchaseMapper.deletePurchase(id);
	}
}
