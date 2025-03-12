package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverPurchase;
import himedia.slivermate.service.SliverPurchaseService;

@RestController
@RequestMapping("/api/sliverPurchase")
public class SliverPurchaseController {
	@Autowired
	private SliverPurchaseService sliverPurchaseService;
	
	@GetMapping
	public ResponseEntity<List<SliverPurchase>> getAllPurchases() {
		List<SliverPurchase> purchases = sliverPurchaseService.selectAllPurchases();
		
		return ResponseEntity.ok(purchases);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SliverPurchase> selectPurchaseById(@PathVariable )
}
