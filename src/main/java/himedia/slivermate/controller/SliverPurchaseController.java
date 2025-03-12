package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverPurchase;
import himedia.slivermate.service.SliverPurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class SliverPurchaseController {
	@Autowired
	private SliverPurchaseService sliverPurchaseService;
	
//	GET : /api/purchase
	@GetMapping
	public ResponseEntity<List<SliverPurchase>> getAllPurchases() {
		List<SliverPurchase> purchases = sliverPurchaseService.selectAllPurchases();
		
		return ResponseEntity.ok(purchases);
	}

//	GET : /api/purchase/{id}
	@GetMapping("/{id}")
	public ResponseEntity<SliverPurchase> selectPurchaseById(@PathVariable Long id) {
		SliverPurchase purchase = sliverPurchaseService.selectPurchaseById(id);
		
		return ResponseEntity.ok(purchase);
	}
	
//	GET : /api/purchase/u/{uid}
	@GetMapping("/u/{uid}")
	public ResponseEntity<List<SliverPurchase>> selectPurchaseByUid(@PathVariable Long uid) {
		List<SliverPurchase> purchases = sliverPurchaseService.selectPurchaseByUid(uid);
		
		return ResponseEntity.ok(purchases);
	}
	
// POST : /api/purchase -> 새로운 구매 기록 생성
	@PostMapping
	public ResponseEntity<SliverPurchase> insertPurchase(@RequestBody SliverPurchase purchase) {
		SliverPurchase savedPurchase = sliverPurchaseService.insertPurchase(purchase);
		
		return ResponseEntity.ok(savedPurchase);
	}
}
