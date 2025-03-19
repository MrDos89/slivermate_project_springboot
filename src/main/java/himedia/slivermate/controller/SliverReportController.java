package himedia.slivermate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.repository.vo.SliverReport;
import himedia.slivermate.service.SliverReportService;

@RestController
@RequestMapping("/api/report")
public class SliverReportController {
	@Autowired
	private SliverReportService sliverReportService;
	
//	GET : /api/report
	@GetMapping
	public ResponseEntity<List<SliverReport>> getAllReports() {
		List<SliverReport> reports = sliverReportService.selectAllReports();
		return ResponseEntity.ok(reports);
	}
	
//	POST : /api/report -> 새로운 신고 항목 생성
	@PostMapping
	public ResponseEntity<SliverReport> createReport(@RequestBody SliverReport report) {
		SliverReport savedReport = sliverReportService.insertReport(report);
		return ResponseEntity.ok(savedReport);	
		//	ResponseEntity.created로 하는 것이 의미상 더 나을 수도 있다.
	}
	
//	PUT : /api/report/{rid} -> 기존 신고 항목 수정
	@PutMapping("/{rid}")
	public ResponseEntity<SliverReport> updateReport(@RequestBody SliverReport report, @PathVariable Long rid) {
		report.setRid(rid);
		SliverReport updatedReport = sliverReportService.updateReport(report);
		return ResponseEntity.ok(updatedReport);
	}
	
//	DELETE : /api/report/{rid} -> 기존 신고 항목 삭제
	@DeleteMapping("/{rid}")
	//	Body에 실어 보낼 내용이 없음 -> Void
	public ResponseEntity<Void> deleteReport(@PathVariable Long rid) {
		sliverReportService.deleteReport(rid);
		return ResponseEntity.ok().<Void>build();
	}
}
