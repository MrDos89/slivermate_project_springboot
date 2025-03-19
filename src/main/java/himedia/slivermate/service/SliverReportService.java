package himedia.slivermate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.slivermate.mappers.SliverReportMapper;
import himedia.slivermate.repository.vo.SliverReport;

@Service
public class SliverReportService {
	@Autowired
	private SliverReportMapper sliverReportMapper;
	
	public List<SliverReport> selectAllReports() {
		List<SliverReport> reports = sliverReportMapper.selectAllReports();
		
		return reports;
	}
	
	public SliverReport insertReport(SliverReport report) {
		sliverReportMapper.insertReport(report);
		
		Long rid = report.getId();
		
		return sliverReportMapper.selectById(rid);
	}
	
	public SliverReport updateReport(SliverReport report) {
		sliverReportMapper.updateReport(report);
		
		return report;
	}
	
	public int deleteReport(Long rid) {
		return sliverReportMapper.deleteReport(rid);
	}
}
