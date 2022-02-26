package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(1L);
        this.assertTimesheetsMatch(TIMESHEET_1, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheet = sut.getTimesheet(0L);
        Assert.assertNull(timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1L);
        Assert.assertEquals(2,timesheets.size());

        this.assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        this.assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals(3, timesheets.size());

        this.assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        this.assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        this.assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet expectedTimesheet = new Timesheet(0L,1L, 1L, LocalDate.now(), 4.0, true, "Timesheet 0");
        Timesheet actualTimesheet = sut.createTimesheet(expectedTimesheet);

        expectedTimesheet.setTimesheetId(actualTimesheet.getTimesheetId());
        this.assertTimesheetsMatch(expectedTimesheet, actualTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet expectedTimesheet = new Timesheet(0L,1L, 1L, LocalDate.now(), 4.0, true, "Timesheet 0");
        Timesheet createTimesheet = sut.createTimesheet(expectedTimesheet);

        Timesheet actualTimesheet = sut.getTimesheet(createTimesheet.getTimesheetId());
        this.assertTimesheetsMatch(createTimesheet, actualTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = sut.getTimesheet(1L);

        timesheetToUpdate.setEmployeeId(2L);
        timesheetToUpdate.setProjectId(2L);
        timesheetToUpdate.setDateWorked(LocalDate.now());
        timesheetToUpdate.setHoursWorked(6.0);
        timesheetToUpdate.setBillable(!timesheetToUpdate.isBillable());
        timesheetToUpdate.setDescription("Timesheet test");

        sut.updateTimesheet(timesheetToUpdate);

        Timesheet retrievedTimesheet = sut.getTimesheet(1L);
        this.assertTimesheetsMatch(timesheetToUpdate, retrievedTimesheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(1L);
        Timesheet retrievedTimesheet = sut.getTimesheet(1L);
        Assert.assertNull(retrievedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billableHours = sut.getBillableHours(2L, 2L);
        Assert.assertEquals(0.0, billableHours, 000.1);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
