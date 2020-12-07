package com.cg.attendance.services;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.attendance.dto.AttendanceDto;
import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.entities.Employee;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.repositories.AttendanceDetailRepository;
/**
 * Attendance Detail Service Interface methods are implemented here.
 * @author Suparna Arya
 *
 */
@Service
public class AttendanceDetailService implements IAttendanceDetailService {

	Logger log=Logger.getLogger(getClass());
	@Autowired
	private AttendanceDetailRepository attendanceRepo;

	@Autowired
	private EmployeeService empService;

	@Override
	public AttendanceDetail addAttendanceDetail(AttendanceDto attendanceDto) {
		try {

			Employee emp = empService.viewEmployeeByEmpId(attendanceDto.getEmployeeId());

			AttendanceDetail attendance = new AttendanceDetail(attendanceDto.getInTime(), attendanceDto.getOutTime(),
					attendanceDto.getAttendanceDate(), attendanceDto.getReason(), attendanceDto.getTypeId(),
					attendanceDto.getStatus(), emp);
			
			log.info("attendance detail added");
			return attendanceRepo.save(attendance);
		} catch (Exception ex) {
			throw new AttendanceIDException("attendance id  is already present");
		}
		

	}

	@Override
	public AttendanceDetail updateAttendanceStatus(String attendanceId, String updateType) {
		Optional<AttendanceDetail> detail = attendanceRepo.findById(Long.valueOf(attendanceId));
		if (!detail.isPresent()) {

			throw new AttendanceIDException("No attendance is present for attendance id " + attendanceId);
		}

		AttendanceDetail attendance = detail.get();
		if (attendance.getStatus().equalsIgnoreCase("APPLIED")) {
			attendance.setStatus(updateType);
		}
		log.info("update attendance");
		return attendanceRepo.save(attendance);

	}

	@Override
	public AttendanceDetail viewAttendanceByAttendanceId(String attendanceId) {

		Optional<AttendanceDetail> detail = attendanceRepo.findById(Long.valueOf(attendanceId));
		if (!detail.isPresent()) {

			throw new AttendanceIDException("No attendance is present for attendance id " + attendanceId);
		}

		AttendanceDetail attendance = detail.get();
		log.info("fetched  attendance detail by an employee with attendanceid "+attendanceId);
		return attendance;
	}

}